import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class InitializeShuntingYard {
	public Track t906a;
	public Track t52;
	public Track t53;
	public Track t54;
	public Track t55;
	public Track t56;
	public Track t57;
	public Track t58;
	public Track t59;
	public Track t64;
	public Track t51b;
	public Track t60;
	public Track t61;
	public Track t62;
	public Track t63;
	public Track t104a;
	
	public InitializeShuntingYard(){
		initializeShuntingYard();
	}

	public void initializeShuntingYard(){
		String csvFile = "C:/Users/silva/OneDrive/Documenten/Seminar/Data/Connections.csv";
		BufferedReader br = null;
		String cvsSplitBy = ";"; 
		String line = "";

		try {
			br = new BufferedReader(new FileReader(csvFile));
			line = br.readLine();
			String [] track = line.split(cvsSplitBy);
			ArrayList<Integer> con = new ArrayList<Integer>();
			for(int i = 1;i < track.length;i++)
			{
				con.add(Integer.parseInt(track[i]));
			}
			this.t906a = new Track(Integer.parseInt(track[0]),false,false,true,con);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
