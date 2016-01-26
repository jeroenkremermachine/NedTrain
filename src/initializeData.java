import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class initializeData {
	public trainType VIRM4;
	public trainType VIRM6;
	public trainType DDZ4;
	public trainType DDZ6;
	public trainType SLT4;
	public trainType SLT6;


	public initializeData(){
		initializeTrains();
		initializeCompositions();
		initializeTypes();
	}
	
	public void initializeTrains(){
		
	}
	
	public void initializeCompositions(){
		
	}
	
	public void initializeTypes(){	
		String csvFile = "C:/Users/piepj_000/OneDrive/Documenten/Econometrie/Master/Seminar/Data/KleineBinckhorstTypes.csv";
		BufferedReader br = null;
		String cvsSplitBy = ";"; 
		String line = "";

		try {
			br = new BufferedReader(new FileReader(csvFile));
			//If dynamic names possible use while loop
			//		while ((line = br.readLine()) != null) {
			//			count = count +1;
			//			String[] type = line.split(cvsSplitBy);
			//			if(count>2){
			//			
			//			//String name = type[0].concat(type[1]);
			//			trainType names.get(1) = new trainType(Integer.parseInt(type[5]), 0, 0, 0, 0);	
			//			System.out.println("type:" + type[0] );
			//			System.out.println("carriages: " + type[1]);
			//			System.out.println("length: " + type[5]);
			//			}
			//			System.out.println("tester: " + VIRM4.getLength());
			//		}
			line = br.readLine();
			String[] type = line.split(cvsSplitBy); //dutch line
			line = br.readLine();
			type = line.split(cvsSplitBy); //english line
			
			line = br.readLine();
			type = line.split(cvsSplitBy);
			this.VIRM4 = new trainType(Integer.parseInt(type[5]), 0, 0, 0, 0);

			line = br.readLine();
			this.VIRM6 = new trainType(Integer.parseInt(type[5]), 0, 0, 0, 0);
			
			line = br.readLine();
			type = line.split(cvsSplitBy);
			this.DDZ4 = new trainType(Integer.parseInt(type[5]), 0, 0, 0, 0);

			line = br.readLine();
			type = line.split(cvsSplitBy);
			this.DDZ6 = new trainType(Integer.parseInt(type[5]), 0, 0, 0, 0);

			line = br.readLine();
			type = line.split(cvsSplitBy);
			this.SLT4 = new trainType(Integer.parseInt(type[5]), 0, 0, 0, 0);

			line = br.readLine();
			type = line.split(cvsSplitBy);
			this.SLT6 = new trainType(Integer.parseInt(type[5]), 0, 0, 0, 0);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}