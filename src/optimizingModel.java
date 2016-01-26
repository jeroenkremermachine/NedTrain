import java.util.ArrayList;

public class optimizingModel {
	private initializeData Data;
	private InitializeShuntingYard Yard;
	
	public optimizingModel(initializeData Data, InitializeShuntingYard Yard){
		this.Data = Data;
		this.Yard = Yard;
	}

	public boolean optimization(){
		//This should all be implemented in the data set, and the shunting yard
		trainType typeX = new trainType(50, 5, 15, 5, 5);
		Train myTrain = new Train(313, typeX, true, true, true, true, true, 4);
		ArrayList<Integer> positions = new ArrayList<Integer>();
		positions.add(0, 0);
		positions.add(1, 0);
		positions.add(2, 0);
		positions.add(3, 0);
		positions.add(4, 0); 
		ArrayList<Integer> washpositions = new ArrayList<Integer>();
		washpositions.add(2);
		ArrayList<Integer> repairpositions = new ArrayList<Integer>();
		repairpositions.add(3);
		int[][] tpm = {
				{1, 0, 1, 1, 0},
				{0, 1, 1, 0, 0},
				{1, 1, 1, 0, 1},
				{1, 0, 0, 1, 1},
				{0, 0, 1, 1, 1},
		};


		int minuut = 0; 

		while ( minuut <= 20)
		{
			boolean movement = false;
			int timeMovement = 0;


			// check of er arrival plaats vind
			if (minuut == myTrain.getarrivalminute()) 
			{
				positions.set(0, myTrain.getID());				
			}

			int start = 0; 
			int end = 2;
			//Run dijkstra hier!!!

			if (positions.get(start) != 0) 
			{
				System.out.println("We gaan verplaatsen!! the old position vector was:   "+ positions);
				shuntingMovements move = new shuntingMovements(myTrain.getID(), start,end, tpm, washpositions, repairpositions, positions);
				movement = move.getpossibleMove();
				positions = move.getPositions();
				timeMovement = move.getTimeMove();
			}

			if (movement == true) 
			{
				System.out.println("startminuut van verplaatsing:   "+ minuut);
				System.out.println("is it possible to move:   "+ movement);
				//		System.out.println("did the train arrive on a washing position:   "+ move.getWashed());
				System.out.println("the new position vector is:   "+ positions);
				minuut = minuut + timeMovement;
			}
			else 
			{	
				System.out.println("in deze minuut heeft geen verplaatsing plaats gevonden:  "+ minuut);
				minuut++;

			}


		}
		return true;
	}

	
	
}

