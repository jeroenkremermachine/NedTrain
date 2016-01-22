import java.util.ArrayList;

public class trainComposition {
	private ArrayList<Train> trains = new ArrayList<Train>();
	private int ID;

	public trainComposition(ArrayList trains, int ID){
		this.trains = trains;
		this.ID = ID;
	}
	
	public int getID(){
		return ID;
	}
	
	public int getNumber(){
		return trains.size();
	}
	
	public double getLength(){
		double length = 0;
		for (int i=0; i<trains.size() ;i++){
			length = length + trains.get(i).getType().getLength();
		}
		return length;
	}
	
	public void addTrain(Train x){
		trains.add(x);
	}
	
	public void removeTrain(Train x){
		trains.remove(x);
	}
}
