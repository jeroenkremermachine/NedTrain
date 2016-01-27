import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

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
	public int[][] travelMatrix;

	public InitializeShuntingYard() throws FileNotFoundException, IOException{
		initializeShuntingYard();
	}

	public void initializeShuntingYard() throws FileNotFoundException, IOException{

		FileReader fr = new FileReader("Connections.csv");
		BufferedReader br = new BufferedReader(fr);
		String cvsSplitBy = ";"; 
		String line = "";
		ArrayList<Train> inTrainTrack = new ArrayList<Train>(); // initial empty LrrayList for all tracks
		this.travelMatrix = new int[16][16];
		int counter = 0;
		try {

			line = br.readLine();
			String[] track = line.split(cvsSplitBy);
			Integer[] con = new Integer[track.length - 1];
			for(int i = 1;i < track.length;i++)
			{
				con[i-1]=Integer.parseInt(track[i]);
				travelMatrix[counter][i-1] = Integer.parseInt(track[i]);
			}

			counter++; 


			this.t906a = new Track(Integer.parseInt(track[0]),false,false,true,con,inTrainTrack);

			line = br.readLine();
			track = line.split(cvsSplitBy);
			for(int i = 1;i < track.length;i++)
			{
				con[i-1]=Integer.parseInt(track[i]);
				travelMatrix[counter][i-1] = Integer.parseInt(track[i]);
			}

			counter++; 
			this.t52 = new Track(Integer.parseInt(track[0]),false,false,false,con,inTrainTrack);

			line = br.readLine();
			track = line.split(cvsSplitBy);
			for(int i = 1;i < track.length;i++)
			{
				con[i-1]=Integer.parseInt(track[i]);
				travelMatrix[counter][i-1] = Integer.parseInt(track[i]);
			}

			counter++; 
			this.t53 = new Track(Integer.parseInt(track[0]),false,false,false,con,inTrainTrack);

			line = br.readLine();
			track = line.split(cvsSplitBy);
			for(int i = 1;i < track.length;i++)
			{
				con[i-1]=Integer.parseInt(track[i]);
				travelMatrix[counter][i-1] = Integer.parseInt(track[i]);
			}

			counter++; 
			this.t54 = new Track(Integer.parseInt(track[0]),false,false,false,con,inTrainTrack);

			line = br.readLine();
			track = line.split(cvsSplitBy);
			for(int i = 1;i < track.length;i++)
			{
				con[i-1]=Integer.parseInt(track[i]);
				travelMatrix[counter][i-1] = Integer.parseInt(track[i]);
			}

			counter++; 
			this.t55 = new Track(Integer.parseInt(track[0]),false,false,false,con,inTrainTrack);

			line = br.readLine();
			track = line.split(cvsSplitBy);
			for(int i = 1;i < track.length;i++)
			{
				con[i-1]=Integer.parseInt(track[i]);
				travelMatrix[counter][i-1] = Integer.parseInt(track[i]);
			}

			counter++; 
			this.t56 = new Track(Integer.parseInt(track[0]),false,false,false,con,inTrainTrack);

			line = br.readLine();
			track = line.split(cvsSplitBy);
			for(int i = 1;i < track.length;i++)
			{
				con[i-1]=Integer.parseInt(track[i]);
				travelMatrix[counter][i-1] = Integer.parseInt(track[i]);
			}

			counter++; 
			this.t57 = new Track(Integer.parseInt(track[0]),false,false,false,con,inTrainTrack);

			line = br.readLine();
			track = line.split(cvsSplitBy);
			for(int i = 1;i < track.length;i++)
			{
				con[i-1]=Integer.parseInt(track[i]);
				travelMatrix[counter][i-1] = Integer.parseInt(track[i]);
			}

			counter++; 
			this.t58 = new Track(Integer.parseInt(track[0]),false,false,false,con,inTrainTrack);

			line = br.readLine();
			track = line.split(cvsSplitBy);
			for(int i = 1;i < track.length;i++)
			{
				con[i-1]=Integer.parseInt(track[i]);
				travelMatrix[counter][i-1] = Integer.parseInt(track[i]);
			}

			counter++; 
			this.t59 = new Track(Integer.parseInt(track[0]),false,false,false,con,inTrainTrack);

			line = br.readLine();
			track = line.split(cvsSplitBy);
			for(int i = 1;i < track.length;i++)
			{
				con[i-1]=Integer.parseInt(track[i]);
				travelMatrix[counter][i-1] = Integer.parseInt(track[i]);
			}

			counter++; 
			this.t64 = new Track(Integer.parseInt(track[0]),false,false,false,con,inTrainTrack);

			line = br.readLine();
			track = line.split(cvsSplitBy);
			for(int i = 1;i < track.length;i++)
			{
				con[i-1]=Integer.parseInt(track[i]);
				travelMatrix[counter][i-1] = Integer.parseInt(track[i]);
			}

			counter++; 
			this.t51b = new Track(Integer.parseInt(track[0]),false,false,false,con,inTrainTrack);

			line = br.readLine();
			track = line.split(cvsSplitBy);
			for(int i = 1;i < track.length;i++)
			{
				con[i-1]=Integer.parseInt(track[i]);
				travelMatrix[counter][i-1] = Integer.parseInt(track[i]);
			}

			counter++; 
			this.t60 = new Track(Integer.parseInt(track[0]),false,false,false,con,inTrainTrack);

			line = br.readLine();
			track = line.split(cvsSplitBy);
			for(int i = 1;i < track.length;i++)
			{
				con[i-1]=Integer.parseInt(track[i]);
				travelMatrix[counter][i-1] = Integer.parseInt(track[i]);
			}

			counter++; 
			this.t61 = new Track(Integer.parseInt(track[0]),false,true,false,con,inTrainTrack);

			line = br.readLine();
			track = line.split(cvsSplitBy);
			for(int i = 1;i < track.length;i++)
			{
				con[i-1]=Integer.parseInt(track[i]);
				travelMatrix[counter][i-1] = Integer.parseInt(track[i]);
			}

			counter++; 
			this.t62 = new Track(Integer.parseInt(track[0]),false,true,false,con,inTrainTrack);

			line = br.readLine();
			track = line.split(cvsSplitBy);
			for(int i = 1;i < track.length;i++)
			{
				con[i-1]=Integer.parseInt(track[i]);
				travelMatrix[counter][i-1] = Integer.parseInt(track[i]);
			}
			counter++; 

			this.t63 = new Track(Integer.parseInt(track[0]),true,false,false,con,inTrainTrack);

		} 

		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 



	}

	public void tpmbuilder(){
		// initialiseer tpm in een matrix met nullen

		int firstPosition = 0;
		int secondPosition =0;
		int[][] positions = {
				{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{2, 3, 4, 5, 6, 7, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{9, 10, 11, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{12, 13, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{14, 15, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{16, 17, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{18, 19, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{20, 21, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{22, 23, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{24, 25, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{26, 27, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{28, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{29, 30, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{31, 32, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{33, 34, 35, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{36, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},

		};

		int [][] tpm = new int [36][36];
		for (int i = 0; i<=35;i++){
			for (int j=0; j<= 35; j++){
				tpm[i][j] = 0;
			}
		}

		for (int i = 0; i<=15;i++){
			for (int j=0; j<= 15; j++){

				if (travelMatrix[i][j] == 1){

					firstPosition = positions[i][1];
					secondPosition = positions[j][1];
					tpm[firstPosition][secondPosition] = 1;

				}
				if (travelMatrix[i][j] == 2){

					firstPosition = positions[i][1];
					int maxvalue = 0;
					for (int p=0;p<=15;p++){
						if (positions[j][p] > maxvalue){
							maxvalue = positions[j][p];
						}
					}
					secondPosition = maxvalue;

					tpm[firstPosition][secondPosition-1] = 1;						

				}
				if (travelMatrix[i][j] == 3){


					int maxvalue = 0;
					for (int p=0;p<=15;p++){
						if (positions[i][p] > maxvalue){
							maxvalue = positions[i][p];
						}
					}
					firstPosition = maxvalue;
					secondPosition = positions[j][1];
					tpm[firstPosition-1][secondPosition] = 1;	

				}
				if (travelMatrix[i][j] == 4){

					int maxvalue = 0;
					firstPosition = positions[j][1];
					for (int p=0;p<=15;p++){
						if (positions[i][p] > maxvalue){
							maxvalue = positions[i][p];
						}
					}

					maxvalue = 0;
					for (int p=0;p<=15;p++){
						if (positions[j][p] > maxvalue){
							maxvalue = positions[j][p];
						}
					}
					secondPosition = maxvalue;
					tpm[firstPosition-1][secondPosition-1] = 1;	
				}
				

			
			}
		}
		
		for (int i = 0; i<=15;i++){
			for (int j=0; j<= 10; j++){
				if (positions[i][j] == positions[i][j+1]-1) {
					tpm[positions[i][j]-1][positions[i][j+1]-1] = 1; 
					tpm[positions[i][j+1]-1][positions[i][j]-1] = 1; 
			}
		}
		}

		
		for (int k =0; k<= 35; k++){
			for (int l = 0; l<= 35; l++){
				System.out.print(tpm[k][l]+" ");
			}
			System.out.println(" ");
		}




	}
}







