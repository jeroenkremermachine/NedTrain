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
	// WEG TOCH? public Track t64;
	public Track t51b;
	public Track t60;
	public Track t61;
	public Track t62;
	public Track t63;
	public Track t104a;
	public int[][] travelMatrix;
	public int[][] tpm;

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
//			this.t64 = new Track(Integer.parseInt(track[0]),false,false,false,con,inTrainTrack);
//
//			line = br.readLine();
//			track = line.split(cvsSplitBy);
//			for(int i = 1;i < track.length;i++)
//			{
//				con[i-1]=Integer.parseInt(track[i]);
//				travelMatrix[counter][i-1] = Integer.parseInt(track[i]);
//			}
//
//			counter++; 
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

		this.tpm = new int [65][65];
		for (int i = 0; i<=64;i++){
			for (int j=0; j<= 64; j++){
				tpm[i][j] = 0;
			}
		}

		for (int i = 0; i<=14;i++){
			for (int j=0; j<= 14; j++){

				if (travelMatrix[i][j] == 1){

					firstPosition = positionsPerTrack[i][1];
					secondPosition = positionsPerTrack[j][1];
					tpm[firstPosition][secondPosition] = 1;

				}
				if (travelMatrix[i][j] == 2){

					firstPosition = positionsPerTrack[i][1];
					int maxvalue = 0;
					for (int p=0;p<=14;p++){
						if (positionsPerTrack[j][p] > maxvalue){
							maxvalue = positionsPerTrack[j][p];
						}
					}
					secondPosition = maxvalue;

					tpm[firstPosition][secondPosition-1] = 1;						

				}
				if (travelMatrix[i][j] == 3){


					int maxvalue = 0;
					for (int p=0;p<=14;p++){
						if (positionsPerTrack[i][p] > maxvalue){
							maxvalue = positionsPerTrack[i][p];
						}
					}
					firstPosition = maxvalue;
					secondPosition = positionsPerTrack[j][1];
					tpm[firstPosition-1][secondPosition] = 1;	

				}
				if (travelMatrix[i][j] == 4){

					int maxvalue = 0;
					firstPosition = positionsPerTrack[j][1];
					for (int p=0;p<=14;p++){
						if (positionsPerTrack[i][p] > maxvalue){
							maxvalue = positionsPerTrack[i][p];
						}
					}

					maxvalue = 0;
					for (int p=0;p<=14;p++){
						if (positionsPerTrack[j][p] > maxvalue){
							maxvalue = positionsPerTrack[j][p];
						}
					}
					secondPosition = maxvalue;
					tpm[firstPosition-1][secondPosition-1] = 1;	
				}
				

			
			}
		}
		
		for (int i = 0; i<=14;i++){
			for (int j=0; j<= 10; j++){
				if (positionsPerTrack[i][j] == positionsPerTrack[i][j+1]-1) {
					tpm[positionsPerTrack[i][j]-1][positionsPerTrack[i][j+1]-1] = 1; 
					tpm[positionsPerTrack[i][j+1]-1][positionsPerTrack[i][j]-1] = 1; 
			}
		}
		}

		
//		for (int k =0; k<= 64; k++){
//			for (int l = 0; l<= 64; l++){
//				System.out.print(tpm[k][l]+" ");
//			}
//			System.out.println(" ");
//		}



	}
	public  int[][] returnTPM(){
		return tpm;
	}
	

}







