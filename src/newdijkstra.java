import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
 
public class newdijkstra
{
    private int          distances[];
    private Set<Integer> settled;
    private Set<Integer> unsettled;
    private int          number_of_nodes;
    private int          adjacencyMatrix[][];
    public int[][] tpm;
 
    
    
    public newdijkstra()
    {
        this.number_of_nodes = 65;

        distances = new int[number_of_nodes + 1];
        settled = new HashSet<Integer>();
        unsettled = new HashSet<Integer>();
        adjacencyMatrix = new int[number_of_nodes + 1][number_of_nodes + 1];
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
 
    
    /// main method 
    public static void main(String... arg) throws FileNotFoundException, IOException
    {
        int adjacency_matrix[][];
        int number_of_vertices;
        int source = 0, destination = 0;
        Scanner scan = new Scanner(System.in);
        try
        {
           
            number_of_vertices = 65;
            adjacency_matrix = new int[number_of_vertices + 1][number_of_vertices + 1];
            
//            for (int i = 1; i <= number_of_vertices+1; i++)
//            {
//                for (int j = 1; j <= number_of_vertices+1; j++)
//                {
//            System.out.print(adjacency_matrix[i-1][j-1]);
////            
//                }
//                System.out.println("");}
//            System.out.println(number_of_vertices);
            
//    		HOE DIT EFFICIENTER MAKEN??


            InitializeShuntingYard yard = new InitializeShuntingYard(); //create the shunting yard
        	yard.tpmbuilder();
        	int[][] tpm = yard.returnTPM();
        	
    		
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
 
            source = 1;
            destination = 900;
 
            newdijkstra dijkstrasAlgorithm = new newdijkstra(
                    );
            dijkstrasAlgorithm.dijkstra_algorithm(adjacency_matrix, source);
 
           boolean possibleMovement = false;
            for (int i = 1; i <= dijkstrasAlgorithm.distances.length - 1; i++)
            {
            	// System.out.println(dijkstrasAlgorithm.distances[i]);
                if (i == destination)
                {
                    System.out.println(source + " to " + i + " is "
                            + dijkstrasAlgorithm.distances[i]);
                    possibleMovement = true;
                }
          
                	
                
            }
            System.out.println("het is mogelijk om te bewegen:   "+possibleMovement);

        } 
            catch (InputMismatchException inputMismatch)
        {
            System.out.println("Wrong Input Format");
        }
        
    }
}