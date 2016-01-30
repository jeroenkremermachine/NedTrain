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

	public optimizingModel(initializeData Data, InitializeShuntingYard Yard, initializeEventList eventlist){
		this.Data = Data;
		this.Yard = Yard;
		this.List = eventlist;
	}

	public void  optimization(int[][] tpm) throws FileNotFoundException, IOException{
		//This should all be implemented in the data set, and the shunting yard
		ArrayList<Integer> positions = new ArrayList<Integer>(); // Alle posities leeg
		dijkstraMovement move = new dijkstraMovement();
		for (int i = 0; i<=64; i++){
			positions.add(i, 0);
		}

		int minuut = 0; 
		movement = false;

		// daadwerklijke optimization programma
		// eventlist updates e.d. met als input welke beweging moet plaats vinden, en return is of deze beweging kan of niet + beweginstijd.

		// test om te kijken wat er mis ging, maar de arrivallist is leeg volgens deze printer, terwijl die wel vol is in de eventlist method.
		int[] a = List.arrivallist;
		for (int i = 0; i<a.length ; i++){
		System.out.println(a[i]);
		}
		while ( minuut <= 20)
		{	
		//	int[] a = List.arrivallist; //puur voor aanmaken en verwijderen van treinen
			int[] arrivalMin = getMin(a);
			int[] d = List.departurelist;
			int[] departureMin = getMin(d);
			int end = List.endmovement;//create set methods

			if(arrivalMin[1]==minuut){
				//do arrival
			}
			if(departureMin[1]==minuut){
				//do departure
			}
			if(end==minuut){
				movement=false; //endmovement aanpassen
			}

			//asap weg van arrival spoor als arrival track bezet

			//if arrival set arriving train on position 1 -> create trainevents({inpection, clean, repair}->behandel, wash, departarea ,depart)

			//if departure remove departing train from position x

			if (movement == false){
				//Check arrival track
				if(positions.get(0)!=0){ // a train is on the track
					//move train to arrival tracks
				}
			}

			if (movement == false){
				// check of er bewegingsverzoek op de eventlist staat, bijvoorbeeld nu: 
				int[][] m = List.movementlist;
				int[] movementMin = getMin(m,0); //what type of movement on which train
				int movementType = List.movementlist[movementMin[0]][1];
				int movementTrainID = List.movementlist[movementMin[0]][2];
				//find current position of train
				int currentPosition = getIndex(positions, movementTrainID);
				int endPositions[] = {-1, -1};
				int endPosition = -1;
				if(movementType ==1){
					//do traincity
				} else if(movementType ==2){
					//do wash
				} else if(movementType ==3){
					//do departure
				} else if(movementType ==4){

				}

				int timeMovement = 0; //later set eventlist endmovement method
				//priority of emptying washing machine en platforms (zelfde als beweging naar beginspoor)
				if(endPositions[0]!=-1){
					for (int i=0;i<endPositions.length;i++){
						movementTime = move.possibleMovement(currentPosition, endPositions[i], positions);
						if(movementTime!=0){
							endPosition = endPositions[i];
							positions.set(currentPosition, 0);
							positions.set(endPosition, movementTrainID);
							timeMovement = movementTime;
							movement = true;
							//set end movement
							break;
						}
					}
				}

				// if not possible do something else

			}	
			minuut++;
		}

	}

	public int[] getMin(int[] x){
		int minvalue = Integer.MAX_VALUE;
		int index = -1;
		for (int i=0;i<x.length;i++){
			if(x[i]<minvalue){
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
			if(x[i][z]<minvalue){
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

}

