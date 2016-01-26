import java.util.ArrayList;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	initializeData data = new initializeData(); //create the data set
	InitializeShuntingYard yard = new InitializeShuntingYard(); //create the shunting yard
	
	optimizingModel model = new optimizingModel(data, yard); //create the model
	model.optimization(); //run the model and obtain output
		


		

	}
}






