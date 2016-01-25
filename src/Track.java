import java.util.ArrayList;

public class Track {
	public double trackLength;
	public boolean washTrack;
	public boolean platformTrack;
	public ArrayList<Train> trainTrack;
	public double idleSpace;


	public Track(double trackLength, boolean washTrack, boolean platformTrack,ArrayList<Train> trainTrack){
		this.trackLength=trackLength;
		this.washTrack=washTrack;
		this.platformTrack=platformTrack;
		this.trainTrack=trainTrack; 
	}

	
	public double getLength(){
		return trackLength;
	}
	
	public boolean getWash(){
		return washTrack;
	}
	
	public boolean getPlatform(){
		return platformTrack;
	}
	
	public ArrayList<Train> getTrains(){
		return trainTrack;
	}
	
	public int getNumberOfTrains(){
		return trainTrack.size();
	}
	public double getIdle(){
		idleSpace=0;
	for (int i=0;i<trainTrack.size();i++){
		idleSpace = idleSpace + trainTrack.get(i).getType().getLength();
	}
	return idleSpace;
	}
	

}
