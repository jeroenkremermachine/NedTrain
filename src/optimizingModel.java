import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class optimizingModel {
	private initializeData Data;
	private InitializeShuntingYard Yard;
	private initializeEventList List;
	public int timeMovement;
	public boolean movement;
	public int movementTime;
	public int[] priorityArrivalarea;
	public int[] priorityArrivaltrack;
	public int[] priorityType1;
	public int[] priorityType2;
	public int[] priorityType3;
	public int[] priorityType4;


	public optimizingModel(initializeData Data, InitializeShuntingYard Yard, initializeEventList eventlist, int[] priorityArrivaltrack, int[]priorityArrivalarea, int[] priorityType1, int[]  priorityType2, int[] priorityType3, int[] priorityType4){


		
		this.Data = Data;
		this.Yard = Yard;
		this.List = eventlist;
		this.priorityArrivalarea = priorityArrivalarea;
		this.priorityArrivaltrack = priorityArrivaltrack; 
		this.priorityType1 = priorityType1;
		this.priorityType2 = priorityType2;
		this.priorityType3 = priorityType3;
		this.priorityType4 = priorityType4;
	}

	public void  optimization(int[][] tpm) throws FileNotFoundException, IOException{
		//This should all be implemented in the data set, and the shunting yard
		ArrayList<Integer> positions = new ArrayList<Integer>(); // Alle posities leeg
		dijkstraMovement move = new dijkstraMovement();
		for (int i = 0; i<=66; i++){
			positions.add(i, 0);
		}
		fillInitialActivitylist(); //create lines for all arriving traincompositions

		int minuut = 0; 
		movement = false;


		// daadwerklijke optimization programma
		// eventlist updates e.d. met als input welke beweging moet plaats vinden, en return is of deze beweging kan of niet + beweginstijd.


		while (minuut <= 500)
		{	
			


			int[][] a = List.getArrivallist();
			int[] arrivalMin = getMin(a, 0);
			int[][] d = List.getDeparturelist();
			int[] departureMin = getMin(d, 0);
			int end = List.endmovement;//create set methods
			int[][] activitylist = List.getActivitylist();
			int[] activityMin = getMin(activitylist, 0);

			
//			if (minuut == 28
//					){
//
//				for (int i = 0; i< 10; i++){
//					for (int j=0; j< 8; j++){
//						System.out.print("   "+activitylist[i][j]);
//					}
//					System.out.println();
//				}
//			}
//			if (minuut == 430
//					){
//
//				for (int i = 0; i< 10; i++){
//					for (int j=0; j< 8; j++){
//						System.out.print("   "+activitylist[i][j]);
//					}
//					System.out.println();
//				}
//			}

			if(arrivalMin[1]<=minuut){
				//do arrival
				positions.set(0, List.getArrivallist()[arrivalMin[0]][1]); //put train on position
				List.setArrivallist(Integer.MAX_VALUE, arrivalMin[0]); //set arrival time on inf
			}
			if(departureMin[1]==minuut){ // check if positie is gevuld EN meerdere posities mogelijk, voor meerdere treinen op departure track
				//do departure
				int departurePosition = getIndex(positions, List.getDeparturelist()[departureMin[0]][1]); //find leaving train
				positions.set(departurePosition, 0); //remove leaving train
				List.setDeparturelist(Integer.MAX_VALUE, departureMin[0]); // set departure time on inf
			}
			if(end==minuut){
				movement=false; //endmovement aanpassen
				List.setEndmovement(Integer.MAX_VALUE);
				
			}

			if (activityMin[1] == minuut){ // nog checken: meerdere events op dezelfde minuut klaar?
				List.setActivitylist(activityMin[0], 1, Integer.MAX_VALUE);
				List.setActivitylist(activityMin[0], 3, 0);

			}

	
			printIteration(positions, minuut);
			
			


			if (movement == false){
				//Check arrival track, niet elke trein komt op hetzelfde spoor aan
				if(positions.get(0)!=0){ 
//					System.out.println("remove from arrival");
					int endPosition = -1;
					for (int i=0;i<priorityArrivalarea.length;i++){
						movementTime = move.possibleMovement(1, priorityArrivalarea[i], positions, Data, Yard);
						if(movementTime!=0 && movementTime<100){
							
							endPosition = priorityArrivalarea[i];
							int id = positions.get(0);
							positions.set(endPosition, id);
							positions.set(0, 0);
							timeMovement = minuut + movementTime;
							movement = true;
							List.setEndmovement(timeMovement);
							setMovementList(id);
							StartEvent(id, 0, timeMovement);
							break;
						}

					}
				}


				// bij beide onderstaande methodes, moeten we gaan bedenken waar naar toe de beweging gaat. Mogelijk conflict met de movementlist als je een keuze maakt;			
				//				if (movement == false){
				//					if(positions.get(ONE OF THE EXTERNAL WASHING MACHINES)!=0){ 
				//						int endPosition = -1;
				//						for (int i=0;i<priorityArrival.length;i++){
				//							movementTime = move.possibleMovement(1, priorityArrival[i], positions, Data, Yard);
				//							if(movementTime!=0){
				//								endPosition = priorityArrival[i];
				//								int id = positions.get(0);
				//								positions.set(endPosition, id);
				//								positions.set(1, 0);
				//								timeMovement = minuut + movementTime;
				//								movement = true;
				//								List.setEndmovement(timeMovement);
				//								break;
				//							}
				//					}
				//				}
				//					
				//					
				//					if (movement == false){
				//						if(positions.get(ONE OF THE INTERNAL WASHING MACHINES)!=0){ 
				//							int endPosition = -1;
				//							for (int i=0;i<priorityArrival.length;i++){
				//								movementTime = move.possibleMovement(1, priorityArrival[i], positions, Data, Yard);
				//								if(movementTime!=0){
				//									endPosition = priorityArrival[i];
				//									int id = positions.get(0);
				//									positions.set(endPosition, id);
				//									positions.set(1, 0);
				//									timeMovement = minuut + movementTime;
				//									movement = true;
				//									List.setEndmovement(timeMovement);
				//									break;
				//								}
				//movementlijst eruit halen want move hoeft niet meer
				//						}
				//					}

				
		
				if (movement == false){
					
					int[][] m = List.getMovementlist(); 
					int[] movementMin = getPossibleMin(m,0); //check index -1
					if(movementMin[0] !=-1){
						int movementType = m[movementMin[0]][1];
						int movementTrainID = m[movementMin[0]][2];
						int currentPosition = getIndex(positions, movementTrainID);
						int endPosition = -1;



						if(movementType ==1){  // internal cleaning

							for (int i=0;i<priorityType1.length;i++){
								movementTime = move.possibleMovement(1, priorityType1[i], positions, Data, Yard);
								if(movementTime!=0 && movementTime<100){
									
									endPosition = priorityType1[i];
									int id = movementTrainID;
									positions.set(endPosition, id);
									positions.set(currentPosition, 0);
									timeMovement = minuut + movementTime;
									movement = true;
									List.setEndmovement(timeMovement);
									StartEvent(id, 1, timeMovement);
									break;
								}
							}
						}
						else if(movementType ==2){ // external cleaning
							for (int i=0;i<priorityType2.length;i++){
								movementTime = move.possibleMovement(1, priorityType2[i], positions, Data, Yard);
								if(movementTime!=0 && movementTime<100){
									endPosition = priorityType2[i];
									int id = movementTrainID;
									positions.set(endPosition, id);
									positions.set(currentPosition, 0);
									timeMovement = minuut + movementTime;
									movement = true;
									List.setEndmovement(timeMovement);
									StartEvent(id, 3, timeMovement);
									break;
								}
							}
						} 


						else if(movementType ==3){ //move to depart area
							for (int i=0;i<priorityType3.length;i++){
								movementTime = move.possibleMovement(1, priorityType3[i], positions, Data, Yard);
								if(movementTime!=0 && movementTime<100){
									endPosition = priorityType3[i];
									int id = movementTrainID;
									positions.set(endPosition, id);
									positions.set(currentPosition, 0);
									timeMovement = minuut + movementTime;
									movement = true;
									List.setEndmovement(timeMovement);
									StartEvent(id, 3, timeMovement);
									break;
								}
							}
						} 


						else if(movementType ==4){	
							for (int i=0;i<priorityType4.length;i++){
								movementTime = move.possibleMovement(1, priorityType4[i], positions, Data, Yard);
								if(movementTime!=0 && movementTime<100){
									endPosition = priorityType4[i];
									int id = movementTrainID;
									positions.set(endPosition, id);
									positions.set(currentPosition, 0);
									timeMovement = minuut + movementTime;
									movement = true;
									List.setEndmovement(timeMovement);
									break;
								}
							}
						}
					}
				}	

			} //if movement is false
			minuut++;
		}//while

	}


	// SKIP EVENT IF: TYPE 4 event - (eventime + minuut) < 0




	public int[] getMin(int[] x){
		int minvalue = Integer.MAX_VALUE;
		int index = -1;
		for (int i=0;i<x.length;i++){
			if(x[i]<=minvalue){
				index = i;
				minvalue = x[i];
			}
		}
		int[] y = {index, minvalue};
		return y;
	}

	public int[] getMin(int[][] x, int z){
		int minvalue = Integer.MAX_VALUE;
		int index = -1;
		for (int i=0;i<x.length;i++){
			if(x[i][z]<=minvalue){
				index = i;
				minvalue = x[i][z];
			}
		}
		int[] y = {index, minvalue};
		return y;
	}

	public int[] getPossibleMin(int[][] x, int z){ //movementlist erin [time type id]
		int minvalue = Integer.MAX_VALUE;
		int index = 0;
		int found =0;
		int possible = -1;

		while(found==0){
			for (int j=0;j<x.length;j++){
				if(x[j][z]<=minvalue){
					index = j;
					minvalue = x[j][z];
				}
			}
			int id = x[index][2];
			for(int i=0;i<50;i++){
				if(List.getActivitylist()[i][1]==id){
					if(List.getActivitylist()[i][2]==0){ //activity check
//						System.out.println("index" + List.getActivitylist()[i][2]);
						found = 1;
						possible = id;
					} else {
						x[index][z] = Integer.MAX_VALUE;
						minvalue = Integer.MAX_VALUE;
					}
					
				}
			}
			if(minvalue>100000){
				found=1;
				index = -1;
			}
		}
		int[] y = {index, possible};
		return y;
	}

	public int getIndex(ArrayList<Integer> x, int ID){ //getposition
		int index = -1;
		for (int i=0;i<x.size();i++){
			if(x.get(i)==ID){
				index = i;
			}
		}
		return index;
	}

	public double getLength(int id){
		String x = Integer.toString(id);
		double length=0;
		if (x.length() == 5){
			ArrayList<trainComposition> comp = Data.getCompositions();
			for (int i = 0; i< comp.size(); i++){
				if (comp.get(i).getID()==id){
					length = comp.get(i).getLength();
				}
			}
		}
		else {
			ArrayList<Train> train = Data.getTrains();
			for (int i = 0; i< train.size(); i++){
				if (train.get(i).getID()==id){
					length = train.get(i).getType().getLength();
				}
			}
		}

		return length;
	}

	public int getBooleans(int id, int bool){ //inspect, repair, clean, wash
		int time = 0;
		//		if (x.length() == 5){
		ArrayList<trainComposition> comp = Data.getCompositions();
		for (int i = 0; i< comp.size(); i++){
			if (comp.get(i).getID()==id){
				for (int j=0; j<comp.get(i).getTrains().size();j++){
					if(bool == 1){
						if(comp.get(i).getTrains().get(j).getInspect()==true){
							time = time + (int) comp.get(i).getTrains().get(j).getType().getInspectiontime();
						}
					} else if(bool == 2){
						if(comp.get(i).getTrains().get(j).getRepair()==true){
							time = time + (int) comp.get(i).getTrains().get(j).getType().getRepairtime();
						}
					} else if(bool == 3){
						if(comp.get(i).getTrains().get(j).getClean()==true){
							time = time + (int) comp.get(i).getTrains().get(j).getType().getCleaningtime();
						}
					} else if(bool == 4){
						if(comp.get(i).getTrains().get(j).getWash()==true){
							time = time + (int) comp.get(i).getTrains().get(j).getType().getWashingtime();
						}
					}
				}
			}
		}
		return time;
	}

	public double getDepartureTime(int id){ //inspect, repair, clean, wash
		String x = Integer.toString(id);
		double time=0;
		//ArrayList<trainComposition> comp = Data.getCompositions();
		int[][] list = List.getDeparturelist();
		for (int i = 0; i< 50; i++){
			if (list[i][1]==id){
				time = list[i][0];
			}
		}		
		return time;
	}

	public void setMovementList(int id){ // vult de movementmatrix met uiterlijke tijden voor het rijden naar area's. 

		// per train ID moeten we de volgende dingen uit gaan lezen: 
		double departureTime = getDepartureTime(id);
		int washExtern = getBooleans(id, 4);
		int washIntern = getBooleans(id, 3);
		int inspection = getBooleans(id, 1);
		int repair = getBooleans(id, 2);
		double movementtime = 2;
		double type1Event = Integer.MAX_VALUE; // type 4: To depart track (Every train)
		double type2Event = Integer.MAX_VALUE; // type 3: to depart area (every train. some trains get repaired there)
		double type3Event = Integer.MAX_VALUE; // type 2; to external cleaning area (some trains)
		double type4Event = Integer.MAX_VALUE; // type 1: to internal cleaning area (some trains)

		int location = -1;
		for(int i=0; i<1000;i++){
			if(List.getMovementlist()[i][2]==0){
				location = i;
				break;
			}
		}	 
		// SET TYPE 4 EVENT (MOVING TO THE DEPART TRACK)	
		type4Event = departureTime - movementtime;  //create event time
		List.setMovementlist((int) type4Event, id, 4, location); //fill list	
		location++;
		// --------------------------------------------------------------------------------------------------		 
		//SET TYPE 3 TO BE THE ULTIMATE_START_REPAIR_EVENT	
		type3Event = type4Event - repair - movementtime;
		List.setMovementlist((int) type3Event,  id,  3, location);
		location++;
		// --------------------------------------------------------------------------------------------------				 
		// SET TYPE 2 TO BE THE TIME THAT YOU HAVE TO GO TO THE CLEANING EXTERN AREA		 
		if(washExtern>0){
			type2Event = type3Event - washExtern - movementtime;
			List.setMovementlist((int) type2Event, id, 2, location);
			location++;
		}
		// --------------------------------------------------------------------------------------------------		
		//SET TYPE 1 TO BE THE TIME THAT YOU HAVE TO GO TTHE CLEANING INTERN AREA	
		if(washExtern>0){
			type1Event = type2Event - washIntern - movementtime;
		} else {
			type1Event = type3Event - washIntern - movementtime;
		}
		List.setMovementlist((int) type1Event, id, 1, location);

		// -------------------------------------------------------------------------------------------------- 
		// Only start an event if type4 - eventtime > 0. (so there is always time to travel to the departure track). 
		// THE REAL start event is making sure that the train cannot move, and that the train makes an end event after which it can move. 
	}


	public void StartEvent(int id, int type, int arrival){ // vult de eventlist met events (ANDERS DAN DE MOVEMENTLIST!)  
		//
		//	 // IF A TRAIN ARRIVES, OR IF A END MOVEMENT EVENT OCCURS, WE WILL CALL THIS METHOD. PER TRAIN ID SHOULD EXIST A EVENT MATRIX:
		//	 // matrix:  TIME(1) -- ID(2) -- CURRENT event(3) -- WASHEXTERN(4) -- WASHINTERN(5) --- INSPECTION(6) -- REPAIR(7) -- event counter(8)
		int washExtern = getBooleans(id, 4);
		int washIntern = getBooleans(id, 3);
		int inspection = getBooleans(id, 1);
		int repair = getBooleans(id, 2);

		int location = -1;
		for(int i=0; i<50;i++){
			if(List.getActivitylist()[i][1]==id){
				location = i;
			}
		}

		
		if(type ==1){ //internal
			if(List.getActivitylist()[location][4]==1){ //needs cleaning
				List.setActivitylist(location, 1, arrival+washIntern);
				List.setActivitylist(location, 3, 1);
				List.setActivitylist(location, 5, 0);
				List.setActivitylist(location, 8, List.getActivitylist()[location][7]+1);
			}
		} else if(type ==2){ //external
			if(List.getActivitylist()[location][3]==1){ //needs washing
				List.setActivitylist(location, 1, arrival+washExtern);
				List.setActivitylist(location, 3, 1);
				List.setActivitylist(location, 4, 0);
				List.setActivitylist(location, 8, List.getActivitylist()[location][7]+1);
			}
		} else if(type ==3){ //repair
			if(List.getActivitylist()[location][6]==1){ //needs washing
				List.setActivitylist(location, 1, arrival+repair);
				List.setActivitylist(location, 3, 1);
				List.setActivitylist(location, 7, 0);
				List.setActivitylist(location, 8, List.getActivitylist()[location][7]+1);
			}
		} else if(type ==0){ //repair
			if(List.getActivitylist()[location][5]==1){ //inspection
				List.setActivitylist(location, 1, arrival+inspection);
				List.setActivitylist(location, 3, 1); 
				List.setActivitylist(location, 6, 0);
				List.setActivitylist(location, 8, List.getActivitylist()[location][7]+1);
			}
		} 
	}

	public void fillInitialActivitylist(){
		//	 // IF A TRAIN ARRIVES, OR IF A END MOVEMENT EVENT OCCURS, WE WILL CALL THIS METHOD. PER TRAIN ID SHOULD EXIST A EVENT MATRIX:
		//	 // matrix:  TIME(1) -- ID(2) -- CURRENT event(3) -- WASHEXTERN(4) -- WASHINTERN(5) --- INSPECTION(6) -- REPAIR(7) -- event counter(8)
		for(int i=0;i<50;i++){
			int id = List.getArrivallist()[i][1];

			if(id!=0){
				int boolwashex=0;
				int boolwashin=0;
				int boolins=0;
				int boolrep=0;
				int washExtern = getBooleans(id, 4);
				if(washExtern>0){boolwashex = 1;}
				int washIntern = getBooleans(id, 3);
				if(washIntern>0){boolwashin = 1;}
				int inspection = getBooleans(id, 1);
				if(inspection>0){boolins = 1;}
				int repair = getBooleans(id, 2);
				if(repair>0){boolrep = 1;}

				List.setActivitylist(i, 1, Integer.MAX_VALUE);
				List.setActivitylist(i, 2, id);
				List.setActivitylist(i,4, boolwashex);
				List.setActivitylist(i,5, boolwashin);
				List.setActivitylist(i,6, boolins);
				List.setActivitylist(i,7, boolrep);
			}
		}
	}



	public void printIteration(ArrayList<Integer> p, int minuut){
		System.out.print("Minuut: " + minuut + "  ");
		for (int i=0;i<p.size();i++){
			System.out.print(p.get(i) + " ");
		}
		System.out.println("");
	}
}

