import java.util.ArrayList;
import java.util.Arrays;

public class initializeEventList {
	public int[][] arrivallist;
	public int[][] departurelist;
	public int[][] movementlist;
	public int endmovement;
	
	
	public initializeEventList(){
		
		this.arrivallist = initializeArrivallist();
		this.departurelist = initializeDeparturelist();
		this.movementlist = initializeMovementlist();
		this.endmovement=0;
		
	}	

	public  int[][] initializeArrivallist() {

		int[][] arrivallist = new int [50][2]; //tijden trainID

		for (int j=0; j<50; j++){
			arrivallist[j][0] = Integer.MAX_VALUE;		
		}
		return arrivallist;
	}

	public  int[][] initializeDeparturelist() {

		int [][] departurelist = new int [50][2]; //tijden trainID
		for (int j=0; j<50; j++){
			departurelist[j][0] = Integer.MAX_VALUE;		
		}
		return departurelist;

	}

	public  int[][] initializeMovementlist() {

		int [][] movementlist = new int [1000][3]; //tijden types trainID
		for (int j=0; j<1000; j++){
			movementlist[j][0] = Integer.MAX_VALUE;		
		}
		return movementlist;
	}

	
	public void setArrivallist(int time, int location){
		this.arrivallist[location][0] = time;
	}
	
	public void setDeparturelist(int time, int location){
		this.departurelist[location][0] = time;
	}
	
	public void setMovementlist(int time, int type, int location){
		this.movementlist[location][0] = time;
		this.movementlist[location][1] = type;
	}
	
	public void setEndmovement(int time){
		this.endmovement = time;
	}
	
	public int[][] getArrivallist(){
		return arrivallist;
	}
	
	public int[][] getDeparturelist(){
		return departurelist;
	}
	
	public int[][] getMovementlist(){
		return movementlist;
	}
}
