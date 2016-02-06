import java.util.ArrayList;

public class schedulingCompositions {
	private int[][] linking; //typingID arrivalID departureID arrivalTime departureTime arrivalTrack departureTrack


	public schedulingCompositions(){ //create a schedule

		//for all arriving compositions
		//	if departing compositions contains same trains as arriving compositions
		//		link the compositions
		//	end
		//end

		//Check if remaining departing types are equal to remaining arriving types
		//Sort the arrival and departing compositions on number of trains

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

	public boolean compareCompositions(trainComposition a, trainComposition b){
		ArrayList<trainType> aType= a.getTypes();
		ArrayList<trainType> bType= b.getTypes();
		boolean equal = true; //innocent untill proven otherwise
		for (int i=0; i<aType.size();i++){
			if(!bType.contains(aType.get(i))){ // in a but not in b
				equal = false;
			}
		}
		for (int i=0; i<bType.size();i++){
			if(!aType.contains(bType.get(i))){ // in b but not in a
				equal = false;
			}
		}
		return equal;
	}

	public ArrayList<trainComposition> createList(ArrayList<trainComposition> small, trainComposition big){
		//create a list with all compositions from small that fit in big
		ArrayList<trainType> bigList = big.getTypes();
		for (int i=0;i<small.size();i++){//check all compositions
			ArrayList<trainType> types= small.get(i).getTypes();
			boolean fit=true;
			boolean typesFit = true;
			for(int j=0;j<types.size();j++){
				if(!bigList.contains(types.get(i))){
					typesFit=false; //types all in the big
				}
			}
			if(typesFit){
				for(int shift=0;shift<5;shift++){ //if for any shift all types are the same
					for (int j=0;j<types.size();j++){
						if(!types.get(j).equals(bigList.get(j+shift))){ //same type order somewhere with shift
							fit=false;
						}
					}
				}
			}
			if(fit){
				//add to list
			}
		}

		return small;
	}

	public void fillExcel(){
		//write everyting in right layout for reading the eventlist filling
	}
}
