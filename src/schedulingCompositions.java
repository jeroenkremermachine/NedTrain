import java.util.ArrayList;

public class schedulingCompositions {
	private int[][] linking; //typingID arrivalID departureID arrivalTime departureTime arrivalTrack departureTrack


	public schedulingCompositions(initializeData data){ //create a schedule
		this.linking = new int[20][7];
		scheduling(data);
	}

	public void scheduling(initializeData data){
		ArrayList<trainComposition> arrivals = new ArrayList<trainComposition>();
		ArrayList<trainComposition> departures = new ArrayList<trainComposition>();
		for(int i=0; i< data.allCompositions.size();i++){
			if(data.allCompositions.get(i).getArrival()){
				arrivals.add(data.allCompositions.get(i));
			} else {
				departures.add(data.allCompositions.get(i));
			}
		}
		//		System.out.println("Arrivals");
		//		for(int i=0;i<arrivals.size();i++){
		//			System.out.println(arrivals.get(i).getID());
		//		}
		//		System.out.println("Departure");
		//		for(int i=0;i<departures.size();i++){
		//			System.out.println(departures.get(i).getID());
		//		}

		int countlink = 0;
		int i=0;
		while(i<arrivals.size()){
			int foundj = 0;
			int j=0;
			while(foundj==0 && j<departures.size()){
				if(compareCompositions(arrivals.get(i), departures.get(j)) && arrivals.get(i).getTime()<=departures.get(j).getTime()){
					//link compositions
					linking[countlink][0] = arrivals.get(i).getID();
					linking[countlink][1] = arrivals.get(i).getID();
					linking[countlink][2] = departures.get(j).getID();
					linking[countlink][3] = arrivals.get(i).getTime();
					linking[countlink][4] = departures.get(j).getTime();
					int arrivaltrack = 0;
					if(arrivals.get(i).get906a()){
						arrivaltrack = 906;
					} else {
						arrivaltrack = 104;
					}
					int departuretrack = 0;
					if(departures.get(j).get906a()){
						departuretrack = 906;
					} else {
						departuretrack = 104;
					}
					linking[countlink][5] = arrivaltrack;
					linking[countlink][6] = departuretrack;

					arrivals.remove(i);//remove the assigned links
					departures.remove(j);
					i=i-1;

//					for(int s=0;s<7;s++){
//						System.out.print(linking[countlink][s] + "  ");
//					}
//					System.out.println("Linking added");
					countlink = countlink+1;
					foundj =1;
				}
				j=j+1;
			}
			i=i+1; //always look for next i compesated after removal
		}

		//// Now all identical compositions have been linked
//		System.out.println(arrivals.size());
//		System.out.println(departures.size());

		//Check if remaining departing number of types are equal to remaining arriving types
//		int arr = 0;
//		int dep = 0;
//		for(int x=0;x<arrivals.size();x++){
//			arr = arr + arrivals.get(x).getTypes().size();
//		}
//		for(int x=0;x<departures.size();x++){
//			dep = dep + departures.get(x).getTypes().size();
//		}
//		System.out.println("Arrivals: " + arr + " Departures: " + dep);
		
		
		
		//Sort the arrival and departing compositions on number of types

		//while compositionlist not empty	

		//for largest departing compositions, make list of all arriving compositions that fit in it
		//	try to match as few arriving compositions to make the departing one
		//		start with trying to match the biggest with second biggest etc.
		//	link the compositions
		//end

		//for largest arriving compositions, make list of all departing compositions that fit in it
		//	try to match as few departing compositions to make the arriving one
		//		start with trying to match the biggest with second biggest etc.
		//	link the compositions
		//end

		//endwhile
	}
	public int[][] getLinking(){
		return linking;
	}

	public void printLinking(){
		for (int i=0;i<linking.length;i++){
			for(int j=0;j<linking[0].length;j++){
				System.out.print(linking[i][j] + "  ");
			}
			System.out.println();
		}
	}
	
	public void sortArrayList(ArrayList<trainComposition> bb){
		boolean sorted = false;
		while(sorted == false){
			sorted = true;
			for(int i=1;i<bb.size();i++){
				for(int p =0;p<i;p++){
					if(bb.get(i).getTypes().size()>bb.get(p).getTypes().size()){
						sorted = false;
						//move to the top
						trainComposition nu = bb.get(i);
						for(int j=0;j<i;j++){
							bb.set(i-j, bb.get(i-j-1));
						}
						bb.set(0, nu);
					}
				}
			}
		}
	}
	
	public boolean compareCompositions(trainComposition a, trainComposition b){
		ArrayList<trainType> aType= a.getTypes();
		ArrayList<trainType> bType= b.getTypes();

		boolean equal = false; 
		boolean straight = true;//innocent untill proven otherwise
		boolean reversed = true;

		if(aType.size()==bType.size()){
			for (int i=0; i<aType.size();i++){
				if(!aType.get(i).equals(bType.get(i))){
					straight = false;
				}
			}
			for (int i=0; i<aType.size();i++){
				if(!aType.get(i).equals(bType.get(bType.size()-i-1))){
					reversed = false;
				} 
			}
			if(straight==true || reversed==true){
				equal=true;
			}
		}
		return equal;
	}
	

	public ArrayList<trainComposition> createList(ArrayList<trainComposition> small, trainComposition big){
		//create a list with all compositions from small that fit in big
		ArrayList<trainType> bigList = big.getTypes();
		ArrayList<trainComposition> smallList = new ArrayList<trainComposition>();
		for (int i=0;i<small.size();i++){//check all compositions
			ArrayList<trainType> types = small.get(i).getTypes();
			boolean fit=false;
			boolean typesFit = true;
			for(int j=0;j<types.size();j++){
				if(!bigList.contains(types.get(j))){
					typesFit=false; //types all in the big
				}
			}
			if(typesFit){
				int shiftcount=0;
				for(int shift=0;shift<=bigList.size()-types.size();shift++){ //if for any shift all types are the same
					boolean shiftfit = true;
					for (int j=0;j<types.size();j++){
						if(j+shift<bigList.size()){
							if(!types.get(j).equals(bigList.get(j+shift))){ //same type order somewhere with shift
								shiftfit=false;
							}
						}
					}
					System.out.println( "compositie "+i+"   Shift" + shift + " " + shiftfit);
					if(shiftfit){
						shiftcount = shiftcount+1;
					}
				}
				if(shiftcount>0){
					fit=true;
				}
			}
			if(fit){
				smallList.add(small.get(i));
			}
		}
		return smallList;
	}

	
	public void fillExcel(){
		//write everyting in right layout for reading the eventlist filling
	}
}
