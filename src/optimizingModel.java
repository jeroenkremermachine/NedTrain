import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class optimizingModel {
	private initializeData Data;
	private InitializeShuntingYard Yard;
	public int timeMovement;
	public boolean movement;
	public double movementTime;

	public optimizingModel(initializeData Data, InitializeShuntingYard Yard){
		this.Data = Data;
		this.Yard = Yard;
	}

	public void  optimization(int[][] tpm) throws FileNotFoundException, IOException{
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

				
			System.out.println("We gaan verplaatsen!! the old position vector was:   "+ positions);
			dijkstraMovement move = new dijkstraMovement();
			movementTime = move.possibleMovement(3, 7, positions);
			double timeMovement = 0;
			if (movementTime!=0){
				System.out.println("true");
				positions.set(3, 0);
				positions.set(7, myTrain.getID());
				timeMovement = movementTime;
				movement = true;
			}
			System.out.println("startminuut van verplaatsing:   "+ minuut);
			System.out.println("the new position vector is:   "+ positions);
			System.out.println("movement possible?   "+ movementTime);
			
			// We krijgen uit de shuntingmovements door of deze beweging mogelijk is, zoniet: Probeer volgende beweging
			}	
			minuut++;
		}
	
	}

}

