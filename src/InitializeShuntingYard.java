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
		ArrayList<Train> inTrainTrack = new ArrayList<Train>(); // initial empty LrrayList for all tracks
		try {
			br = new BufferedReader(new FileReader(csvFile));
			line = br.readLine();
			String [] track = line.split(cvsSplitBy);
			Integer[] con = new Integer[track.length - 1];
			for(int i = 1;i < track.length;i++)
			{
				con[i-1]=Integer.parseInt(track[i]);
			}
			this.t906a = new Track(Integer.parseInt(track[0]),false,false,true,con,inTrainTrack);

			line = br.readLine();
			track = line.split(cvsSplitBy);
			for(int i = 1;i < track.length;i++)
			{
				con[i-1]=Integer.parseInt(track[i]);
			}
			this.t52 = new Track(Integer.parseInt(track[0]),false,false,false,con,inTrainTrack);

			line = br.readLine();
			track = line.split(cvsSplitBy);
			for(int i = 1;i < track.length;i++)
			{
				con[i-1]=Integer.parseInt(track[i]);
			}
			this.t53 = new Track(Integer.parseInt(track[0]),false,false,false,con,inTrainTrack);

			line = br.readLine();
			track = line.split(cvsSplitBy);
			for(int i = 1;i < track.length;i++)
			{
				con[i-1]=Integer.parseInt(track[i]);
			}
			this.t54 = new Track(Integer.parseInt(track[0]),false,false,false,con,inTrainTrack);

			line = br.readLine();
			track = line.split(cvsSplitBy);
			for(int i = 1;i < track.length;i++)
			{
				con[i-1]=Integer.parseInt(track[i]);
			}
			this.t55 = new Track(Integer.parseInt(track[0]),false,false,false,con,inTrainTrack);

			line = br.readLine();
			track = line.split(cvsSplitBy);
			for(int i = 1;i < track.length;i++)
			{
				con[i-1]=Integer.parseInt(track[i]);
			}
			this.t56 = new Track(Integer.parseInt(track[0]),false,false,false,con,inTrainTrack);

			line = br.readLine();
			track = line.split(cvsSplitBy);
			for(int i = 1;i < track.length;i++)
			{
				con[i-1]=Integer.parseInt(track[i]);
			}
			this.t57 = new Track(Integer.parseInt(track[0]),false,false,false,con,inTrainTrack);

			line = br.readLine();
			track = line.split(cvsSplitBy);
			for(int i = 1;i < track.length;i++)
			{
				con[i-1]=Integer.parseInt(track[i]);
			}
			this.t58 = new Track(Integer.parseInt(track[0]),false,false,false,con,inTrainTrack);

			line = br.readLine();
			track = line.split(cvsSplitBy);
			for(int i = 1;i < track.length;i++)
			{
				con[i-1]=Integer.parseInt(track[i]);
			}
			this.t59 = new Track(Integer.parseInt(track[0]),false,false,false,con,inTrainTrack);

			line = br.readLine();
			track = line.split(cvsSplitBy);
			for(int i = 1;i < track.length;i++)
			{
				con[i-1]=Integer.parseInt(track[i]);
			}
			this.t64 = new Track(Integer.parseInt(track[0]),false,false,false,con,inTrainTrack);

			line = br.readLine();
			track = line.split(cvsSplitBy);
			for(int i = 1;i < track.length;i++)
			{
				con[i-1]=Integer.parseInt(track[i]);
			}
			this.t51b = new Track(Integer.parseInt(track[0]),false,false,false,con,inTrainTrack);

			line = br.readLine();
			track = line.split(cvsSplitBy);
			for(int i = 1;i < track.length;i++)
			{
				con[i-1]=Integer.parseInt(track[i]);
			}
			this.t60 = new Track(Integer.parseInt(track[0]),false,false,false,con,inTrainTrack);

			line = br.readLine();
			track = line.split(cvsSplitBy);
			for(int i = 1;i < track.length;i++)
			{
				con[i-1]=Integer.parseInt(track[i]);
			}
			this.t61 = new Track(Integer.parseInt(track[0]),false,true,false,con,inTrainTrack);

			line = br.readLine();
			track = line.split(cvsSplitBy);
			for(int i = 1;i < track.length;i++)
			{
				con[i-1]=Integer.parseInt(track[i]);
			}
			this.t62 = new Track(Integer.parseInt(track[0]),false,true,false,con,inTrainTrack);

			line = br.readLine();
			track = line.split(cvsSplitBy);
			for(int i = 1;i < track.length;i++)
			{
				con[i-1]=Integer.parseInt(track[i]);
			}
			this.t63 = new Track(Integer.parseInt(track[0]),true,false,false,con,inTrainTrack);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
