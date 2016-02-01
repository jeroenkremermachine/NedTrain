import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class dijkstraMovement {

	private int          distances[];
    private Set<Integer> settled;
    private Set<Integer> unsettled;
    private int          number_of_nodes;
    private int          adjacencyMatrix[][];
    public int[][] tpm;
    
    public dijkstraMovement()
    {
        this.number_of_nodes = 65;

        distances = new int[number_of_nodes + 1];
        settled = new HashSet<Integer>();
        unsettled = new HashSet<Integer>();
        adjacencyMatrix = new int[number_of_nodes + 1][number_of_nodes + 1];
    }
	
    public int possibleMovement(int start, int end, ArrayList<Integer> positions, initializeData Data) throws FileNotFoundException, IOException{
    	 int adjacency_matrix[][];
         int number_of_vertices;
         int source = 0, destination = 0;
         Scanner scan = new Scanner(System.in);
         
         //boolean possibleMovement = false;
         int possibleMovement = 0;
         try
         {
            
             number_of_vertices = 65;
             adjacency_matrix = new int[number_of_vertices + 1][number_of_vertices + 1];

            InitializeShuntingYard yard = new InitializeShuntingYard(); //create the shunting yard
         	yard.tpmbuilder();
         	int[][] tp = yard.returnTPM();
         	
         	int[][] tpm = tp;
			for (int i = 1; i<=64;i++)
			{
				if (positions.get(i) !=0)
					for (int p = 0; p<=64; p++) 
					{
						tpm[p][i] = 0;
					}
			}
         	
     		
             for (int i = 1; i <= number_of_vertices; i++)
             {
                 for (int j = 1; j <= number_of_vertices; j++)
                 {
                     adjacency_matrix[i][j] = tpm[i-1][j-1];
                     if (i == j)
                     {
                         adjacency_matrix[i][j] = 0;
                         continue;
                     }
                     if (adjacency_matrix[i][j] == 0)
                     {
                   
                         adjacency_matrix[i][j] = Integer.MAX_VALUE;
                     }
                 }
             }
  
             source = start;
             destination = end;
  
             dijkstraMovement dijkstrasAlgorithm = new dijkstraMovement(
                     );
             dijkstrasAlgorithm.dijkstra_algorithm(adjacency_matrix, source);
  
            //possibleMovement = false;
             possibleMovement = 0;
             for (int i = 1; i <= dijkstrasAlgorithm.distances.length - 1; i++)
             {
             	// System.out.println(dijkstrasAlgorithm.distances[i]);
                 if (i == destination)
                 {
                     System.out.println(source + " to " + i + " is "
                             + dijkstrasAlgorithm.distances[i]);
                     possibleMovement = dijkstrasAlgorithm.distances[i];
                 }
           
                 	
                 
             }
             System.out.println("het is mogelijk om te bewegen:   "+possibleMovement);

         } 
             catch (InputMismatchException inputMismatch)
         {
             System.out.println("Wrong Input Format");
         }
         
         
 		int[][] positionsPerTrack = {
				{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{2, 3, 4, 5, 6, 7, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{9, 10, 11, 12, 13, 14, 15, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{16, 17, 18, 19, 20, 21, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{22, 23, 24, 25, 26, 27, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{28, 29, 30, 31, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{32, 33, 34, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{35, 36, 37, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{38, 39, 40, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{41, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{42, 43, 44, 45, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{46, 47, 48, 49, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{50, 51,52, 53, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{54, 55, 56, 57, 58, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{59, 60, 61, 62, 63, 64, 65, 0, 0, 0, 0, 0, 0, 0, 0, 0},
		};
 /// start find length movingtrain
        int id =  positions.get(start);
        double movingTrainLength = getLength(id, Data);
    	int track = -1;
        for (int i = 0; i<15; i++){
        	for (int j = 0; j<10; j++){
        		if (positionsPerTrack[i][j] == end){
        			track = i;
        		}
        	}
        }
        double currentTrainLength =0;
        for (int i =0 ; i<10; i++){
        	id = positions.get(positionsPerTrack[track][i]);
        	currentTrainLength = currentTrainLength + getLength(id, Data); 
        }
  /// end find length movingtrain
    	
    	return possibleMovement;
    }
    
	 public void dijkstra_algorithm(int adjacency_matrix[][], int source)
	    {
	        int evaluationNode;
	        for (int i = 1; i <= number_of_nodes; i++)
	            for (int j = 1; j <= number_of_nodes; j++)
	                adjacencyMatrix[i][j] = adjacency_matrix[i][j];
	 
	        for (int i = 1; i <= number_of_nodes; i++)
	        {
	            distances[i] = Integer.MAX_VALUE;
	        }
	 
	        unsettled.add(source);
	        distances[source] = 0;
	        while (!unsettled.isEmpty())
	        {
	            evaluationNode = getNodeWithMinimumDistanceFromUnsettled();
	            unsettled.remove(evaluationNode);
	            settled.add(evaluationNode);
	            evaluateNeighbours(evaluationNode);
	        }
	    }
	 
	    private int getNodeWithMinimumDistanceFromUnsettled()
	    {
	        int min;
	        int node = 0;
	 
	        Iterator<Integer> iterator = unsettled.iterator();
	        node = iterator.next();
	        min = distances[node];
	        for (int i = 1; i <= distances.length; i++)
	        {
	            if (unsettled.contains(i))
	            {
	                if (distances[i] <= min)
	                {
	                    min = distances[i];
	                    node = i;
	                }
	            }
	        }
	        return node;
	    }
	 
	    private void evaluateNeighbours(int evaluationNode)
	    {
	        int edgeDistance = -1;
	        int newDistance = -1;
	 
	        for (int destinationNode = 1; destinationNode <= number_of_nodes; destinationNode++)
	        {
	            if (!settled.contains(destinationNode))
	            {
	                if (adjacencyMatrix[evaluationNode][destinationNode] != Integer.MAX_VALUE)
	                {
	                    edgeDistance = adjacencyMatrix[evaluationNode][destinationNode];
	                    newDistance = distances[evaluationNode] + edgeDistance;
	                    if (newDistance < distances[destinationNode])
	                    {
	                        distances[destinationNode] = newDistance;
	                    }
	                    unsettled.add(destinationNode);
	                }
	            }
	        }
	    }
	    
	    public double getTime(int i){
	    	System.out.println("in method" + distances[i]);
	    	return distances[i];
	    }
		public double getLength(int id, initializeData Data){
			String x = Integer.toString(id);
			double length=0;
			if (id != 0){
			if (x.length() == 5){
				ArrayList<trainComposition> comp = Data.getCompositions();
				for (int i = 0; i< comp.size(); i++){
					if (comp.get(i).getID()==id){
						length = comp.get(i).getLength();
					}
				}
			}
			else {
				ArrayList<Train> train = Data.getTrains();
				for (int i = 0; i< train.size(); i++){
					if (train.get(i).getID()==id){
						length = train.get(i).getType().getLength();
					}
				}
			}
			}
			return length;
		}
	 
}
