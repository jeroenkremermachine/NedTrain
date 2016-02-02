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
	public int[] priorityArrival;
	public int[] priorityDeparture;
	public int[] priorityType1;
	public int[] priorityType2;

	public optimizingModel(initializeData Data, InitializeShuntingYard Yard, initializeEventList eventlist, int[]priorityArrival, int[] priorityDeparture, int[] priorityType1, int[]  priorityType2){
		this.Data = Data;
		this.Yard = Yard;
		this.List = eventlist;
		this.priorityArrival = priorityArrival;
		this.priorityDeparture = priorityDeparture; 
		this.priorityType1 = priorityType1;
		this.priorityType2 =  priorityType2;
	}

	public void  optimization(int[][] tpm) throws FileNotFoundException, IOException{
		//This should all be implemented in the data set, and the shunting yard
		ArrayList<Integer> positions = new ArrayList<Integer>(); // Alle posities leeg
		dijkstraMovement move = new dijkstraMovement();
		for (int i = 0; i<=63; i++){
			positions.add(i, 0);
		}

		int minuut = 0; 
		movement = false;
		
		
		// daadwerklijke optimization programma
		// eventlist updates e.d. met als input welke beweging moet plaats vinden, en return is of deze beweging kan of niet + beweginstijd.

		while ( minuut <= 20)
		{	
			int[][] a = List.getArrivallist();
			int[] arrivalMin = getMin(a, 0);
			int[][] d = List.getDeparturelist();
			int[] departureMin = getMin(d, 0);
			int end = List.endmovement;//create set methods
//			int[][] eventlist = List.getEventlist();
//			int[] eventmin = getMin(eventlist, 0);

			if(arrivalMin[1]==minuut){
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

			// if (eventmin = minuut){ // nog checken: meerdere events op dezelfde minuut klaar?
				// zorg dat in eventmatrix de tweede kolom op false komt te staan, de trein heeft geen event meer.
			// }


			if (movement == false){
				//Check arrival track, niet elke trein komt op hetzelfde spoor aan
				if(positions.get(0)!=0){ 
					int endPosition = -1;
					for (int i=0;i<priorityArrival.length;i++){
						movementTime = move.possibleMovement(1, priorityArrival[i], positions, Data, Yard);
						if(movementTime!=0){
							endPosition = priorityArrival[i];
							int id = positions.get(0);
							positions.set(endPosition, id);
							positions.set(1, 0);
							timeMovement = minuut + movementTime;
							movement = true;
							List.setEndmovement(timeMovement);
							break;
						}
						
					// build movement list (see movement method)
					// check for inspection (see eventmatrix method)
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
//						}
//					}

			if (movement == false){
				// nog inbouwen dat als de gewenst vroegste move op de movementlist niet mogelijk is omdat een event uitgevoerd wordt, of hij geblokkeerd wordt, dat de volgende gepakt wordt.
				int[][] m = List.getMovementlist(); 
				int[] movementMin = getMin(m,0); // more than 1 movement as minimum? no problem? 
				int movementType = m[movementMin[0]][1];
				int movementTrainID = m[movementMin[0]][2];
				int currentPosition = getIndex(positions, movementTrainID);
				int endPosition = -1;
			
				if(movementType ==1){
					for (int i=0;i<priorityType1.length;i++){
						movementTime = move.possibleMovement(1, priorityType1[i], positions, Data, Yard);
						if(movementTime!=0){
							endPosition = priorityType1[i];
							int id = positions.get(0);
							positions.set(endPosition, id);
							positions.set(1, 0);
							timeMovement = minuut + movementTime;
							movement = true;
							List.setEndmovement(timeMovement);
							// eventMatrix method uitvoeren
							break;
						}
					}
				}
				 else if(movementType ==2){
						for (int i=0;i<priorityType2.length;i++){
							movementTime = move.possibleMovement(1, priorityType2[i], positions, Data, Yard);
							if(movementTime!=0){
								endPosition = priorityType2[i];
								int id = positions.get(0);
								positions.set(endPosition, id);
								positions.set(1, 0);
								timeMovement = minuut + movementTime;
								movement = true;
								List.setEndmovement(timeMovement);
								// eventMatrix method uitvoeren
								break;
							}
						}
					} 
				// Check volgorde in wasmachine, evt kan de verste nooit weg nu. 
	
				else if(movementType ==3){
					for (int i=0;i<priorityDeparture.length;i++){
						movementTime = move.possibleMovement(1, priorityDeparture[i], positions, Data, Yard);
						if(movementTime!=0){
							endPosition = priorityDeparture[i];
							int id = positions.get(0);
							positions.set(endPosition, id);
							positions.set(1, 0);
							timeMovement = minuut + movementTime;
							movement = true;
							List.setEndmovement(timeMovement);
							// eventMatrix method uitvoeren
							break;
						}
					}
				} 

				
				else if(movementType ==4)
				{	
					// moet naar zijn eindspoor toe
				}
			}	
			minuut++;
			}
		}

	}

	
	// Het moet mogelijk zijn om een event te skippen in het geval er geen tijd meer voor is. 
	// SKIP EVENT IF: TYPE 4 event - (eventime + minuut) < 0
	// bouw dit in de eventmatrix method.
	
	
	// methodes
	
	
	
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

	public int getIndex(ArrayList<Integer> x, int ID){
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

// public int getLastMoveTime(int id){ // vult de movementmatrix met uiterlijke tijden voor het rijden naar area's. 
//
//		 // per train ID moeten we de volgende dingen uit gaan lezen: 
//	
//	 	 // departureTime;
//		 boolean washExtern = true;
//		 boolean washIntern = true;
//		 boolean inspection = true;
//		 boolean repair = true;
		 
		 // type 4: To depart track (Every train)
		 // type 3: to depart area (every train. some trains get repaired there)
		 // type 2; to external cleaning area (some trains)
		 // type 1: to internal cleaning area (some trains)
		 
		 
// SET TYPE 4 EVENT (MOVING TO THE DEPART TRACK)
		 // get departure time:		
		 // type4Event = departure time - movementtime to depart track
		 // fill movement list met type 5 event. 	
	 
// --------------------------------------------------------------------------------------------------		 
// IF BOOLEAN REPAIR = TRUE: SET TYPE 3 TO BE THE ULTIMATE_START_REPAIR_EVENT	
		 // get type 4 event time: 
		 // type 3 event  = type4 event - repairtime - movementtime to repair/depart area		
		 
// IF BOOLEAN REPAIR = FALSE: SET TYPE 3 TO BE THE TIME THAT YOU HAVE TO GO TO DEPART AREA
		 // get type 4 event time: 
		 // type 3 event  = type4 event - movementtime to repair/depart area	 
		 
// --------------------------------------------------------------------------------------------------				 
// IF BOOLEAN CLEANINGEXTERN = TRUE: SET TYPE 2 TO BE THE TIME THAT YOU HAVE TO GO TO THE CLEANING EXTERN AREA		 
		 // get type 3 event time
		 // type 2 event: Type 3 event - washing extern time - movement to extern wash area 

// --------------------------------------------------------------------------------------------------		
// IF BOOLEAN CLEANINGINTERN = TRUE: SET TYPE 1 TO BE THE TIME THAT YOU HAVE TO GO TTHE CLEANING INTERN AREA	
		 // IF BOOLEAN CLEANING EXTERN = TRUE: 
		 // type1 move =  type 2 - interncleaning time - movement time to internal cleaning platform
		 
		 // IF BOOLEAN CLEANING INTERN = FALSE:
		 // type1 move =  Type 3 - interncleaning event - movement time to internal cleaning platofrm

// --------------------------------------------------------------------------------------------------

		 
		 // all types events go to the movement list, they consist of the ultimate time the train has to move
		 // all other events go to an event list, they correspond to an event is taking place. If an event is taking place it cannot move, AT START TIME MAKE END TIME. 
		 // Only start an event if type5 - eventtime > 0 . (so there is always time to travel to the departure track). 
		 // THE REAL start event is making sure that the train cannot move, and that the train makes an end event after which it can move. 

	 
// return lastMoveTime;
// 
// }
// 
// public int StartEvent(int id){ // vult de eventlist met events (ANDERS DAN DE MOVEMENTLIST!)  
//
//	 // IF A TRAIN ARRIVES, OR IF A END MOVEMENT EVENT OCCURS, WE WILL CALL THIS METHOD. PER TRAIN ID SHOULD EXIST A EVENT MATRIX:
//	 // matrix:  ID -- CURRENT event -- WASHEXTERN -- WASHINTERN --- INSPECTION -- REPAIR -- event counter
//	 
//	 // get current train position
//	 // depending on position check which boolean should be true
//	 // if it's false, no action should be taken
//	 // if it's true, make it false and make current event true
//	 // eventcounter +1. 
//	 // set end event time
//	 
//	 // VOORDEEL: train cannot move if it's busy with an event
//	 // VOORDEEL: aan het eind check je het aantal events op true, en de counter om het aantal geslaagde events te bepalen. 
//
//return lastMoveTime;
//
//}
}

