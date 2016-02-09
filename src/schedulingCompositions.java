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
		//				System.out.println("Arrivals");
		//				for(int i=0;i<arrivals.size();i++){
		//					System.out.println(arrivals.get(i).getID());
		//				}
		//				System.out.println("Departure");
		//				for(int i=0;i<departures.size();i++){
		//					System.out.println(departures.get(i).getID());
		//				}

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
		//				System.out.println(arrivals.size());
		//				System.out.println(departures.size());

		//Check if remaining departing number of types are equal to remaining arriving types
		int arr = 0;
		int dep = 0;
		for(int x=0;x<arrivals.size();x++){
			arr = arr + arrivals.get(x).getTypes().size();
		}
		for(int x=0;x<departures.size();x++){
			dep = dep + departures.get(x).getTypes().size();
		}
		if(arr!=dep){
			System.out.println("Unfeasible schedule, number of trains does not match.");
		}


		//Sort the arrival and departing compositions on number of types
		sortArrayList(arrivals);
		sortArrayList(departures);

		System.out.println("Arrivals");
		for(int x=0;x<arrivals.size();x++){
			System.out.println(arrivals.get(x).getID());
		}
		System.out.println("Departures");
		for(int x=0;x<departures.size();x++){
			System.out.println(departures.get(x).getID());
		}

		ArrayList<trainType> departurestotal = new ArrayList<trainType>();
		ArrayList<trainType> departuresfirst = new ArrayList<trainType>();
		ArrayList<trainType> departuressecond = new ArrayList<trainType>();
		trainComposition create = new trainComposition(new ArrayList<Train>(), departurestotal, 1, true, 5, true);
		while(!arrivals.isEmpty() || !departures.isEmpty()){
			System.out.println("arrival now: " + arrivals.size());
			System.out.println("departure now: " + departures.size());
			////////////Link largest arrival
			System.out.println("Find arrival link ");
			trainComposition now = arrivals.get(0);//biggest arrival
			//			for (int x= 0;x<departures.size();x++){ //find same start departure composition x
			//				System.out.println("x" + x);
			int x=0;
			while(x<departures.size()){
				System.out.println("x: " + x);
				boolean first = true;
				for (int frst=0;frst<departures.get(x).getTypes().size();frst++){
					if(frst>=now.getTypes().size()){
						first = false;
					}
					if(departures.get(x).getTypes().get(frst)!=now.getTypes().get(frst)){
						first = false; //so if all the same found first linking comp
					}
				}
				if(first == true){
					int y=0;
					//						for(int y=0; y<departures.size();y++){//find the second position
					while(y<departures.size()){
						System.out.println("Y: "+y);
						boolean second = true;
						int countfrom = departures.get(x).getTypes().size();
						for (int scnd=0;scnd<departures.get(y).getTypes().size();scnd++){
							if(countfrom>=now.getTypes().size()){
								second = false;
							}
							if(departures.get(y).getTypes().get(scnd)!=now.getTypes().get(countfrom)){ //second list also right
								//check size
								second = false;
							}
						}
						if(second==true){ //list checks out
							int sizenow = now.getTypes().size();
							int sizenew = departures.get(x).getTypes().size()+departures.get(y).getTypes().size();
							if(sizenow==sizenew){ //create links
								System.out.println("Arrival link found with " + x + "," + y);
								System.out.println(departures.get(x).getID() + " with " + now.getID());
								linking[countlink][0] = departures.get(x).getID();
								linking[countlink][1] = now.getID();
								linking[countlink][2] = departures.get(x).getID();
								linking[countlink][3] = now.getTime();
								linking[countlink][4] = departures.get(x).getTime();
								int arrivaltrack = 0;
								if(now.get906a()){
									arrivaltrack = 906;
								} else {
									arrivaltrack = 104;
								}
								int departuretrack = 0;
								if(departures.get(x).get906a()){
									departuretrack = 906;
								} else {
									departuretrack = 104;
								}
								linking[countlink][5] = arrivaltrack;
								linking[countlink][6] = departuretrack;

								arrivals.remove(0);//remove the assigned links
								departures.remove(x);

								for(int s=0;s<7;s++){
									System.out.print(linking[countlink][s] + "  ");
								}
								System.out.println("Linking added");

								countlink = countlink+1;

								linking[countlink][0] = departures.get(y).getID();
								linking[countlink][1] = now.getID();
								linking[countlink][2] = departures.get(y).getID();
								linking[countlink][3] = now.getTime();
								linking[countlink][4] = departures.get(y).getTime();
								arrivaltrack = 0;
								if(now.get906a()){
									arrivaltrack = 906;
								} else {
									arrivaltrack = 104;
								}
								departuretrack = 0;
								if(departures.get(y).get906a()){
									departuretrack = 906;
								} else {
									departuretrack = 104;
								}
								linking[countlink][5] = arrivaltrack;
								linking[countlink][6] = departuretrack;

								arrivals.remove(0);//remove the assigned links
								departures.remove(y);

								for(int s=0;s<7;s++){
									System.out.print(linking[countlink][s] + "  ");
								}
								System.out.println("Linking added");

								countlink = countlink+1;
								x = 100;//jump out of for loop
								y = 100;
							}
						}
						y = y+1;
					}
				}
				x = x+1;
			}
			////////////Link largest departure
			System.out.println("Find departure link ");
			trainComposition now2 = departures.get(0);//biggest arrival
			int x2=0;
//			for (int x2= 0;x2<arrivals.size();x2++){ //find same start departure
			while(x2<arrivals.size()){
				boolean first2 = true;
				for (int frst2=0;frst2<arrivals.get(x2).getTypes().size();frst2++){
					if(frst2>=now2.getTypes().size()){
						first2 = false;
					}
					if(arrivals.get(x2).getTypes().get(frst2)!=now2.getTypes().get(frst2)){
						first2 = false; //so if all the same found first linking comp
					}
				}
				if(first2==true){
					int y2=0;
//					for(int y2=0; y2<arrivals.size();y2++){//find the second position
					while(y2<arrivals.size()){
						boolean second2 = true;
						int countfrom2 = arrivals.get(x2).getTypes().size();
						for (int scnd2=0;scnd2<arrivals.get(y2).getTypes().size();scnd2++){
							if(countfrom2>=now.getTypes().size()){
								second2 = false;
							}
							if(arrivals.get(y2).getTypes().get(scnd2)!=now2.getTypes().get(countfrom2)){ //second list also right
								//check size
								second2 = false;
							}
						}
						if(second2==true){ //list checks out
							int sizenow2 = now2.getTypes().size();
							int sizenew2 = arrivals.get(x2).getTypes().size()+arrivals.get(y2).getTypes().size();
							if(sizenow2==sizenew2){ //create links
								System.out.println("Departure link found with " + x2 + "," + y2);
								linking[countlink][0] = arrivals.get(x2).getID();
								linking[countlink][1] = arrivals.get(x2).getID();
								linking[countlink][2] = now2.getID();
								linking[countlink][3] = arrivals.get(x2).getTime();
								linking[countlink][4] = now.getTime();
								int arrivaltrack = 0;
								if(arrivals.get(x2).get906a()){
									arrivaltrack = 906;
								} else {
									arrivaltrack = 104;
								}
								int departuretrack = 0;
								if(now2.get906a()){
									departuretrack = 906;
								} else {
									departuretrack = 104;
								}
								linking[countlink][5] = arrivaltrack;
								linking[countlink][6] = departuretrack;

								arrivals.remove(x2);//remove the assigned links
								departures.remove(0);

								for(int s=0;s<7;s++){
									System.out.print(linking[countlink][s] + "  ");
								}
								System.out.println("Linking added");

								countlink = countlink+1;

								linking[countlink][0] = arrivals.get(y2).getID();
								linking[countlink][1] = arrivals.get(y2).getID();
								linking[countlink][2] = now2.getID();
								linking[countlink][3] = arrivals.get(y2).getTime();
								linking[countlink][4] = now.getTime();
								arrivaltrack = 0;
								if(arrivals.get(y2).get906a()){
									arrivaltrack = 906;
								} else {
									arrivaltrack = 104;
								}
								departuretrack = 0;
								if(now2.get906a()){
									departuretrack = 906;
								} else {
									departuretrack = 104;
								}
								linking[countlink][5] = arrivaltrack;
								linking[countlink][6] = departuretrack;

								arrivals.remove(y2);//remove the assigned links
								departures.remove(0);

								for(int s=0;s<7;s++){
									System.out.print(linking[countlink][s] + "  ");
								}
								System.out.println("Linking added");

								countlink = countlink+1;
								
								x2 = Integer.MAX_VALUE;
								y2 = Integer.MAX_VALUE;
							}
						}
						y2 = y2+1;
					}
				}
				x2 = x2+1;
			}
		}
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
