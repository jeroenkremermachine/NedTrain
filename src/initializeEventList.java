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
		  
			
			for (int i = 0; i<arrivallist.length ; i++){
			System.out.println(arrivallist[i]);
			}
	}
	
	public  void initializeDeparturelist() {
		
		  int [] departurelist = new int [50];
		  Arrays.fill(departurelist, Integer.MAX_VALUE);
		// nog vullen met informatie uit de data departures
	}
	
	public  void initializeMovementlist() {
		
		  int [][] movementlist = new int [1000][3]; //tijden types trainID
		  for (int i = 0; i<3 ; i++){
			  for (int j=0; j<1000; j++){
		 movementlist[j][i] = Integer.MAX_VALUE;		
			  }
		  }
	}
	

	
}
