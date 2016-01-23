import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		trainType typeX = new trainType(50, 5, 15, 5, 5);
		Train myTrain = new Train(313, typeX, true, true, true, true, true);

		System.out.println(myTrain.getID());
		System.out.println(myTrain.getWash());
		
		myTrain.setWash(false);
		
		System.out.println(myTrain.getWash());
		System.out.println(myTrain.getType().getLength());
		System.out.println("hello");
	
		
		// Train movement initialisation 
		ArrayList<Integer> washpositions = new ArrayList<Integer>();
		washpositions.add(4);
		ArrayList<Integer> repairpositions = new ArrayList<Integer>();
		repairpositions.add(3);
		ArrayList<Integer> positions = new ArrayList<Integer>();
		positions.add(0, 0);
		positions.add(1, 0);
		positions.add(2, 1);
		positions.add(3, 1);
		positions.add(4, 0);

		int[][] tpm = {
				{1, 0, 1, 1, 0},
				{0, 1, 1, 0, 0},
				{1, 1, 1, 0, 1},
				{1, 0, 0, 1, 1},
				{0, 0, 1, 1, 1},
		};

		// Gewenste beweging
		int start = 3;
		int end = 4;

		// resultaten
		System.out.println("the old position vector was:   "+ positions);
		shuntingMovements move = new shuntingMovements(start,end, tpm, washpositions, repairpositions, positions);
		System.out.println("is it possible to move:   "+ move.getpossibleMove());
		System.out.println("did the train arrive on a washing position:   "+ move.getWashed());
		System.out.println("the new position vector is:   "+move.getPositions());


}
}


