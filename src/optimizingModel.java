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

		while ( minuut <= 20)
		{	
			int[][] a = List.getArrivallist();
			int[] arrivalMin = getMin(a, 0);
			int[][] d = List.getDeparturelist();
			int[] departureMin = getMin(d, 0);
			int end = List.endmovement;//create set methods

			if(arrivalMin[1]==minuut){
				//do arrival
				positions.set(0, List.arrivallist[arrivalMin[0]][1]); //put train on position
				List.setArrivallist(Integer.MAX_VALUE, arrivalMin[0]); //set arrival time on inf
			}
			if(departureMin[1]==minuut){
				//do departure
				int departurePosition = getIndex(positions, List.departurelist[departureMin[0]][1]); //find leaving train
				positions.set(departurePosition, 0); //remove leaving train
				List.setDeparturelist(Integer.MAX_VALUE, departureMin[0]); // set departure time on inf
			}
			if(end==minuut){
				movement=false; //endmovement aanpassen
				List.setEndmovement(Integer.MAX_VALUE);
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
				int[][] m = List.getMovementlist();
				int[] movementMin = getMin(m,0); //what type of movement on which train
				int movementType = m[movementMin[0]][1];
				int movementTrainID = m[movementMin[0]][2];
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
						movementTime = move.possibleMovement(currentPosition, endPositions[i], positions, Data, Yard);
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


}

