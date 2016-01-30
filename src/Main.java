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
	optimizingModel model = new optimizingModel(data, yard, eventList); //create the model

	yard.tpmbuilder();
int[][] test = yard.returnTPM();
//newdijkstra dijkstra = new newdijkstra(test);
model.optimization(test); //run the model and obtain output


				
			

		

	}
}






