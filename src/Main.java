import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException, IOException {
		// TODO Auto-generated method stub
	initializeData data = new initializeData(); //create the data set
	InitializeShuntingYard yard = new InitializeShuntingYard(); //create the shunting yard
	initializeEventList eventList = new initializeEventList(); //create the eventlist
	
	int[] priorityArrival =  {28, 32, 35, 38, 29, 33, 36, 39, 30, 34, 37, 40, 31};  // 28 t/m 40, track 56 t/m 59
	int[] priorityDeparture = {2, 9, 16, 22, 3, 10, 17, 23, 4, 11, 18, 24, 5, 12, 19, 25, 6, 13, 20, 26, 7, 14, 21, 27, 8, 15};
	int[] priorityType1 = {45, 49, 46, 50, 47, 51, 48, 52}; // Inspection, cleaning and repair
	int[] priorityType2 = {54, 55, 56, 57, 58}; // Wasmachine
	
	
	optimizingModel model = new optimizingModel(data, yard, eventList, priorityArrival, priorityDeparture, priorityType1,priorityType2); //create the model

	yard.tpmbuilder();
int[][] test = yard.returnTPM();
//newdijkstra dijkstra = new newdijkstra(test);
model.optimization(test); //run the model and obtain output


				
			

		

	}
}






