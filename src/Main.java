import java.util.ArrayList;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		trainType typeX = new trainType(50, 5, 15, 5, 5);
		Train myTrain = new Train(313, typeX, true, true, true, true, true, 4);

		System.out.println(myTrain.getID());
		System.out.println(myTrain.getWash());
		System.out.println(myTrain.getarrivalminute());
		myTrain.setWash(false);
		
		System.out.println(myTrain.getWash());
		System.out.println(myTrain.getType().getLength());
		System.out.println("hello");
	
		
		// Train movement initialisation 
		ArrayList<Integer> washpositions = new ArrayList<Integer>();
		washpositions.add(2);
		ArrayList<Integer> repairpositions = new ArrayList<Integer>();
		repairpositions.add(3);
		ArrayList<Integer> positions = new ArrayList<Integer>();
		positions.add(0, 0);
		positions.add(1, 0);
		positions.add(2, 0);
		positions.add(3, 0);
		positions.add(4, 0); 

		int[][] tpm = {
				{1, 0, 1, 1, 0},
				{0, 1, 1, 0, 0},
				{1, 1, 1, 0, 1},
				{1, 0, 0, 1, 1},
				{0, 0, 1, 1, 1},
		};

		
		
		// New train arrival, train goes to position 2 after it arrived


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
		
		}
		}
	





