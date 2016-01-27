import java.util.ArrayList;

public class trainComposition {
	private ArrayList<Train> trains = new ArrayList<Train>();
	private ArrayList<trainType> types = new ArrayList<trainType>();
	private int ID;
	private boolean arrival;
	private int time;

	public trainComposition(ArrayList trains, ArrayList types, int ID, boolean arrival, int time){
		this.trains = trains;
		this.ID = ID;
		this.arrival = arrival;
		this.time = time;
		this.types = types;
	}
	
	public boolean getArrival(){
		return arrival;
	}
	
	public int getTime(){
		return time;
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
	
	public ArrayList<Train> getTrains(){
		return trains;
	}
	
	public ArrayList<trainType> getTypes(){
		return types;
	}
}
