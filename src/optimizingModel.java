import java.util.ArrayList;

public class optimizingModel {
	private initializeData Data;
	private InitializeShuntingYard Yard;
	public int timeMovement;
	public boolean movement;

	public optimizingModel(initializeData Data, InitializeShuntingYard Yard){
		this.Data = Data;
		this.Yard = Yard;
	}

	public void  optimization(int[][] tpm){
		//This should all be implemented in the data set, and the shunting yard
		trainType typeX = new trainType(50, 5, 15, 5, 5);
		Train myTrain = new Train(313, typeX, true, true, true, true, true, 4); // moet uitgelezen worden vanuit data
		ArrayList<Integer> positions = new ArrayList<Integer>(); // moet naar initialize shunting yard
		for (int i = 0; i<=64; i++){
			positions.add(i, 0);
		}
		
		timeMovement = 0;
		int minuut = 0; 
		movement = false;

		// daadwerklijke optimization programma
		// eventlist updates e.d. met als input welke beweging moet plaats vinden, en return is of deze beweging kan of niet + beweginstijd.
	
		while ( minuut <= 20)
		{	
			// arrival of departure checken, deze gaan namelijk ook door als er een movement plaats vind
			// movement ending event: if time is movement ending dan movement = false
			if (movement == false){
			// check of er bewegingsverzoek op de eventlist staat, bijvoorbeeld nu: 
				
			positions.set(3, myTrain.getID()); // voor de test		
			int start = 3; // deze komen uit eventlist
			int end = 40;  // deze komen uit eventlist
				
			System.out.println("We gaan verplaatsen!! the old position vector was:   "+ positions);
			shuntingMovements move = new shuntingMovements(myTrain.getID(), start,end, tpm, positions);
			movement = move.getpossibleMove();
			positions = move.getPositions();
			timeMovement = move.getTimeMove();
			System.out.println("startminuut van verplaatsing:   "+ minuut);
			System.out.println("the new position vector is:   "+ positions);
			System.out.println("movement possible?   "+ movement);
			
			// We krijgen uit de shuntingmovements door of deze beweging mogelijk is, zoniet: Probeer volgende beweging
			}	
			minuut++;
		}
	
	}

}

