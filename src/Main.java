

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
	}

}
