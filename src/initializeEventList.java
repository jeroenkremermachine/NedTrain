import java.util.ArrayList;
import java.util.Arrays;

public class initializeEventList {
	
	public initializeEventList(){
		
		initializeArrivallist();
		initializeDeparturelist();
		initializeMovementlist();
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
		
		  int [] movementlist = new int [1000];
		  Arrays.fill(movementlist, Integer.MAX_VALUE);		
		
	}
	

	
}
