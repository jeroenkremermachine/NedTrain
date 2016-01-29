import java.util.ArrayList;
import java.util.Arrays;

public class initializeEventList {
	public int[] arrivallist;
	public int[] departurelist;
	public int[][] movementlist;
	public int endmovement;
	
	public initializeEventList(){
		initializeArrivallist();
		initializeDeparturelist();
		initializeMovementlist();
		this.endmovement=0;
	}	

	public  void initializeArrivallist() {
	
		  int [] arrivallist = new int [50];
		  Arrays.fill(arrivallist, Integer.MAX_VALUE);
		  // nog vullen met informatie uit de data arrivals
	}
	
	public  void initializeDeparturelist() {
		
		  int [] departurelist = new int [50];
		  Arrays.fill(departurelist, Integer.MAX_VALUE);
		// nog vullen met informatie uit de data departures
	}
	
	public  void initializeMovementlist() {
		
		  int [][] movementlist = new int [1000][3]; //tijden types trainID
		  Arrays.fill(movementlist, Integer.MAX_VALUE);		
		
	}
	

	
}
