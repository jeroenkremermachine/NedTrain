import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException, IOException {
		// TODO Auto-generated method stub
		
		int counterdeparture = 0;
		int countervolledigfeasible = 0;
		int countervolledigfeasiblehelemaal = 0;

		int nriterations = 100;
		for (int i = 0; i < nriterations ; i++){
		initializeData data = new initializeData(); //create the data set
		InitializeShuntingYard yard = new InitializeShuntingYard(); //create the shunting yard
		initializeEventList eventList = new initializeEventList(); //create the eventlist

		int[] priorityArrivaltrack = {1, 2, 3, 4}; 
		int[] priorityArrival =  {31, 35, 38, 32, 36, 39, 33, 37, 40};  
		int[] priorityType1 = {48, 52, 49, 53, 50, 54, 51, 55}; // Internal
		int[] priorityType2 = {56, 57, 58, 59, 60}; // External
		int[] priorityType3 = {11, 5, 18, 12, 24,19, 30, 25, 34, 31, 11, 18, 24, 30, 10,  17, 23, 29, 9, 16, 22, 28, 8, 15, 21, 27, 7, 14, 20, 26, 6, 13, 19, 25,5, 12}; // depart
		int[] priorityType4 = {4, 3, 2, 1}; //departing track
		int[] priorityType4extra = {61, 62}; // other departing track
		double [] results = new double [2];
		optimizingModel2 model = new optimizingModel2(data, yard, eventList, priorityArrivaltrack,  priorityArrival, priorityType1, priorityType2, priorityType3, priorityType4, priorityType4extra); //create the model
		
		
		yard.tpmbuilder();
		int[][] test = yard.returnTPM();
		results = model.optimization(test); //run the model and obtain output
		int run = i+1;
		System.out.println("Run " + run);
		System.out.println("Right track departures:  " + results[1]);
		System.out.println("Completed activities:  " + results[0]);
		if(results[1] > 21.5)
		{counterdeparture = counterdeparture +1;}
		if(results[0] > 0.97)
		{countervolledigfeasible = countervolledigfeasible +1;}
	
		if(results[0] > 0.97 && results[1] > 21.5){
			countervolledigfeasiblehelemaal = countervolledigfeasiblehelemaal +1;
		}
		}
		
		System.out.println();
		System.out.println("Right track departures:   " + counterdeparture + " out of " + nriterations + "(" + 100*counterdeparture/nriterations + "%)");
		System.out.println("Completed activities:   " + countervolledigfeasible + " out of " + nriterations + "(" + 100*countervolledigfeasible/nriterations + "%)");
		System.out.println("Feasible run:   " + countervolledigfeasiblehelemaal + " out of "+ nriterations + "(" + 100*countervolledigfeasiblehelemaal/nriterations + "%)");
		
		
		
// 34,25, 19, 26, 11, 18, 24, 30, 10,  17, 23, 29, 9, 16, 22, 28, 8, 15, 21, 27, 7, 14, 20, 26, 6, 13, 19, 25,5, 12
		//	int[][] positionsPerTrack = {
		//			{1, 2, 3, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},//t906a vrijhouden / aankomst+depart area
		//			{5, 6, 7, 8, 9, 10, 11, 0, 0, 0, 0, 0, 0, 0, 0, 0},//t52 depart area
		//			{12, 13, 14, 15, 16, 17, 18, 0, 0, 0, 0, 0, 0, 0, 0, 0},//53 depart area
		//			{19, 20, 21, 22, 23, 24, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},//54 depart area
		//			{25, 26, 27, 28, 29, 30, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},//t55 depart area
		//			{31, 32, 33, 34, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //t56 arrival area
		//			{35, 36, 37, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //t57 arrival area
		//			{38, 39, 40, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},//t58 arrival area
		//			{41, 42, 43, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //t59 arrival area
		//			{ 44,45, 46, 47, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},//t60 vrijhouden
		//			{48, 49, 50,51, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //t61 intern wassen
		//			{52, 53, 54, 55, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //t62 intern wassen
		//			{56, 57, 58, 59, 60, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //t63 extern wassen
		//			{61, 62, 63, 64, 65, 66, 67, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //t104 vrijhouden
		//	};




	}

	public static void printIteration(ArrayList<Integer> p){
		for (int i=0;i<p.size();i++){
			System.out.print(p.get(i) + " ");
		}
		System.out.println("");
	}
}






