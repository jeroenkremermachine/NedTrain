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
	
	public trainComposition c1;
	public trainComposition c2;
	public trainComposition c3;
	public trainComposition c4;
	public trainComposition c5;
	public trainComposition c6;
	public trainComposition c7;
	public trainComposition c8;
	public trainComposition c9;
	public trainComposition c10;
	public trainComposition c11;
	public trainComposition c12;
	public trainComposition c13;
	public trainComposition c14;
	public trainComposition c15;
	public trainComposition c16;
	public trainComposition c17;
	public trainComposition c18;
	public trainComposition c19;
	public trainComposition c20;
	public trainComposition c21;
	public trainComposition c22;
	public trainComposition c23;
	public trainComposition c24;
	public trainComposition c25;
	public trainComposition c26;
	public trainComposition c27;
	public trainComposition c28;
	public trainComposition c29;
	public trainComposition c30;
	public trainComposition c31;
	public trainComposition c32;
	public trainComposition c33;
	public trainComposition c34;
	public trainComposition c35;
	public trainComposition c36;
	public trainComposition c37;
	public trainComposition c38;
	public trainComposition c39;
	public trainComposition c40;



	public initializeData(){
		initializeCompositions();
		initializeTypes();
	}
	
	public void initializeCompositions(){
		String csvFile = "KleineBinckhorstTimes.csv";
		BufferedReader br = null;
		String csvFile2 = "KleineBinckhorstCompositions.csv";
		BufferedReader br2 = null;
		String cvsSplitBy = ";"; 
		String line = "";
		String line2 = "";
		
		try {
			br = new BufferedReader(new FileReader(csvFile));
			line = br.readLine(); //english line
			line = br.readLine(); //dutch line
			
			br2 = new BufferedReader(new FileReader(csvFile2));
			line = br2.readLine(); //english line
			line = br2.readLine(); //dutch line
			
			// First composition ========================================================
			line = br.readLine();
			line2 = br2.readLine();
			String[] data = line.split(cvsSplitBy);
			String[] data2 = line2.split(cvsSplitBy);
			
			ArrayList<Train> trains1 = new ArrayList<Train>();
			ArrayList<trainType> types1 = new ArrayList<trainType>();
			boolean interchangable = true;
			boolean inspect= true;
			boolean repair= true;
			boolean clean= true;
			boolean wash= true;
			
			boolean arr = data[1].equals("A");
			if(arr=true){
			Train f1 = new Train(1, SLT4, interchangable, inspect, repair, clean, wash, Integer.parseInt(data[2]));
			trains1.add(f1);
			}
			this.c1 = new trainComposition(trains1, types1, Integer.parseInt(data[0]), arr, Integer.parseInt(data[2]));
			types1.add(SLT4);
			
			// Second composition ========================================================
			line = br.readLine();
			line2 = br2.readLine();
			data = line.split(cvsSplitBy);
			data2 = line2.split(cvsSplitBy);
			
			ArrayList<Train> trains2 = new ArrayList<Train>();
			ArrayList<trainType> types2 = new ArrayList<trainType>();
			
			arr = data[1].equals("A");
			if(arr=true){
			Train f2 = new Train(2, VIRM4, interchangable, inspect, repair, clean, wash, Integer.parseInt(data[2]));
			trains2.add(f2);
			Train f3 = new Train(3, VIRM6, interchangable, inspect, repair, clean, wash, Integer.parseInt(data[2]));
			trains2.add(f3);
			}
			this.c2 = new trainComposition(trains2, types2, Integer.parseInt(data[0]), arr, Integer.parseInt(data[2]));
			types2.add(VIRM4);
			types2.add(VIRM6);
			
			// Third composition ========================================================
			line = br.readLine();
			line2 = br2.readLine();
			data = line.split(cvsSplitBy);
			data2 = line2.split(cvsSplitBy);
			
			ArrayList<Train> trains3 = new ArrayList<Train>();
			ArrayList<trainType> types3 = new ArrayList<trainType>();
			
			arr = data[1].equals("A");
			if(arr=true){
			Train f4 = new Train(4, SLT4, interchangable, inspect, repair, clean, wash, Integer.parseInt(data[2]));
			trains3.add(f4);
			}
			this.c3 = new trainComposition(trains3, types3, Integer.parseInt(data[0]), arr, Integer.parseInt(data[2]));
			types3.add(VIRM4);
			types3.add(VIRM6);
			
			// Fourth composition ========================================================
			line = br.readLine();
			line2 = br2.readLine();
			data = line.split(cvsSplitBy);
			data2 = line2.split(cvsSplitBy);
			
			ArrayList<Train> trains4 = new ArrayList<Train>();
			ArrayList<trainType> types4 = new ArrayList<trainType>();
			
			arr = data[1].equals("A");
			if(arr=true){
			Train f5 = new Train(5, VIRM4, interchangable, inspect, repair, clean, wash, Integer.parseInt(data[2]));
			trains4.add(f5);
			}
			this.c4 = new trainComposition(trains4, types4, Integer.parseInt(data[0]), arr, Integer.parseInt(data[2]));
			types4.add(VIRM4);
			
			// Fifth composition ========================================================
			line = br.readLine();
			line2 = br2.readLine();
			data = line.split(cvsSplitBy);
			data2 = line2.split(cvsSplitBy);
			
			ArrayList<Train> trains5 = new ArrayList<Train>();
			ArrayList<trainType> types5 = new ArrayList<trainType>();
			
			arr = data[1].equals("A");
			if(arr=true){
			Train f6 = new Train(6, VIRM6, interchangable, inspect, repair, clean, wash, Integer.parseInt(data[2]));
			trains5.add(f6);
			}
			this.c5 = new trainComposition(trains5, types5, Integer.parseInt(data[0]), arr, Integer.parseInt(data[2]));
			types5.add(VIRM6);
			
			// Sixth composition ========================================================
			line = br.readLine();
			line2 = br2.readLine();
			data = line.split(cvsSplitBy);
			data2 = line2.split(cvsSplitBy);
			
			ArrayList<Train> trains6 = new ArrayList<Train>();
			ArrayList<trainType> types6 = new ArrayList<trainType>();
			
			arr = data[1].equals("A");
			if(arr=true){
			Train f7 = new Train(7, DDZ4, interchangable, inspect, repair, clean, wash, Integer.parseInt(data[2]));
			trains6.add(f7);
			}
			this.c6 = new trainComposition(trains6, types6, Integer.parseInt(data[0]), arr, Integer.parseInt(data[2]));
			types6.add(DDZ4);
			
			// Seventh composition ========================================================
			line = br.readLine();
			line2 = br2.readLine();
			data = line.split(cvsSplitBy);
			data2 = line2.split(cvsSplitBy);
			
			ArrayList<Train> trains7 = new ArrayList<Train>();
			ArrayList<trainType> types7 = new ArrayList<trainType>();
			
			arr = data[1].equals("A");
			if(arr=true){
			Train f8 = new Train(8, VIRM4, interchangable, inspect, repair, clean, wash, Integer.parseInt(data[2]));
			trains7.add(f8);
			}
			this.c7 = new trainComposition(trains7, types7, Integer.parseInt(data[0]), arr, Integer.parseInt(data[2]));
			types7.add(VIRM4);
			
			// Eigth composition ========================================================
			line = br.readLine();
			line2 = br2.readLine();
			data = line.split(cvsSplitBy);
			data2 = line2.split(cvsSplitBy);
			
			ArrayList<Train> trains8 = new ArrayList<Train>();
			ArrayList<trainType> types8 = new ArrayList<trainType>();
			
			arr = data[1].equals("A");
			if(arr=true){
			Train f9 = new Train(9, VIRM4, interchangable, inspect, repair, clean, wash, Integer.parseInt(data[2]));
			trains8.add(f9);
			Train f10 = new Train(10, VIRM4, interchangable, inspect, repair, clean, wash, Integer.parseInt(data[2]));
			trains8.add(f10);
			}
			this.c8 = new trainComposition(trains8, types8, Integer.parseInt(data[0]), arr, Integer.parseInt(data[2]));
			types8.add(VIRM4);
			types8.add(VIRM4);
			
			// Ninth composition ========================================================
			line = br.readLine();
			line2 = br2.readLine();
			data = line.split(cvsSplitBy);
			data2 = line2.split(cvsSplitBy);
			
			ArrayList<Train> trains9 = new ArrayList<Train>();
			ArrayList<trainType> types9 = new ArrayList<trainType>();
			
			arr = data[1].equals("A");
			if(arr=true){
			Train f11 = new Train(11, SLT6, interchangable, inspect, repair, clean, wash, Integer.parseInt(data[2]));
			trains9.add(f11);
			}
			this.c9 = new trainComposition(trains9, types9, Integer.parseInt(data[0]), arr, Integer.parseInt(data[2]));
			types8.add(SLT6);
			
			// Tenth composition ========================================================
			line = br.readLine();
			line2 = br2.readLine();
			data = line.split(cvsSplitBy);
			data2 = line2.split(cvsSplitBy);
			
			ArrayList<Train> trains10 = new ArrayList<Train>();
			ArrayList<trainType> types10 = new ArrayList<trainType>();
			
			arr = data[1].equals("A");
			if(arr=true){
			Train f12 = new Train(12, SLT4, interchangable, inspect, repair, clean, wash, Integer.parseInt(data[2]));
			trains10.add(f12);
			}
			this.c10 = new trainComposition(trains10, types10, Integer.parseInt(data[0]), arr, Integer.parseInt(data[2]));
			types10.add(SLT4);
			
			// Eleventh composition ========================================================
			line = br.readLine();
			line2 = br2.readLine();
			data = line.split(cvsSplitBy);
			data2 = line2.split(cvsSplitBy);
			
			ArrayList<Train> trains11 = new ArrayList<Train>();
			ArrayList<trainType> types11 = new ArrayList<trainType>();
			
			arr = data[1].equals("A");
			if(arr=true){
			Train f13 = new Train(13, VIRM4, interchangable, inspect, repair, clean, wash, Integer.parseInt(data[2]));
			trains11.add(f13);
			}
			this.c11 = new trainComposition(trains11, types11, Integer.parseInt(data[0]), arr, Integer.parseInt(data[2]));
			types11.add(VIRM4);
			
			// Twelfth composition ========================================================
			line = br.readLine();
			line2 = br2.readLine();
			data = line.split(cvsSplitBy);
			data2 = line2.split(cvsSplitBy);
			
			ArrayList<Train> trains12 = new ArrayList<Train>();
			ArrayList<trainType> types12 = new ArrayList<trainType>();
			
			arr = data[1].equals("A");
			if(arr=true){
			Train f14 = new Train(14, SLT6, interchangable, inspect, repair, clean, wash, Integer.parseInt(data[2]));
			trains12.add(f14);
			Train f15 = new Train(15, SLT4, interchangable, inspect, repair, clean, wash, Integer.parseInt(data[2]));
			trains12.add(f15);
			}
			this.c12 = new trainComposition(trains12, types12, Integer.parseInt(data[0]), arr, Integer.parseInt(data[2]));
			types12.add(SLT6);
			types12.add(SLT4);
			
			// Thirteen composition ========================================================
			line = br.readLine();
			line2 = br2.readLine();
			data = line.split(cvsSplitBy);
			data2 = line2.split(cvsSplitBy);
			
			ArrayList<Train> trains13 = new ArrayList<Train>();
			ArrayList<trainType> types13 = new ArrayList<trainType>();
			
			arr = data[1].equals("A");
			if(arr=true){
			Train f16 = new Train(16, VIRM6, interchangable, inspect, repair, clean, wash, Integer.parseInt(data[2]));
			trains13.add(f16);
			}
			this.c13 = new trainComposition(trains13, types13, Integer.parseInt(data[0]), arr, Integer.parseInt(data[2]));
			types13.add(VIRM6);
			
			// 14 composition ========================================================
			line = br.readLine();
			line2 = br2.readLine();
			data = line.split(cvsSplitBy);
			data2 = line2.split(cvsSplitBy);
			
			ArrayList<Train> trains14 = new ArrayList<Train>();
			ArrayList<trainType> types14 = new ArrayList<trainType>();
			
			arr = data[1].equals("A");
			if(arr=true){
			Train f17 = new Train(17, DDZ6, interchangable, inspect, repair, clean, wash, Integer.parseInt(data[2]));
			trains14.add(f17);
			}
			this.c14 = new trainComposition(trains14, types14, Integer.parseInt(data[0]), arr, Integer.parseInt(data[2]));
			types14.add(DDZ6);
			
			// 15 composition ========================================================
			line = br.readLine();
			line2 = br2.readLine();
			data = line.split(cvsSplitBy);
			data2 = line2.split(cvsSplitBy);
			
			ArrayList<Train> trains15 = new ArrayList<Train>();
			ArrayList<trainType> types15 = new ArrayList<trainType>();
			
			arr = data[1].equals("A");
			if(arr=true){
			Train f18 = new Train(18, VIRM4, interchangable, inspect, repair, clean, wash, Integer.parseInt(data[2]));
			trains15.add(f18);
			Train f19 = new Train(19, VIRM6, interchangable, inspect, repair, clean, wash, Integer.parseInt(data[2]));
			trains15.add(f19);
			}
			this.c15 = new trainComposition(trains15, types15, Integer.parseInt(data[0]), arr, Integer.parseInt(data[2]));
			types15.add(DDZ6);
			types15.add(VIRM6);
			

			// 16 composition ========================================================
			line = br.readLine();
			line2 = br2.readLine();
			data = line.split(cvsSplitBy);
			data2 = line2.split(cvsSplitBy);
			
			ArrayList<Train> trains16 = new ArrayList<Train>();
			ArrayList<trainType> types16 = new ArrayList<trainType>();
			
			arr = data[1].equals("A");
			if(arr=true){
			Train f20 = new Train(20, VIRM6, interchangable, inspect, repair, clean, wash, Integer.parseInt(data[2]));
			trains16.add(f20);
			}
			this.c16 = new trainComposition(trains16, types16, Integer.parseInt(data[0]), arr, Integer.parseInt(data[2]));
			types16.add(VIRM6);
			
			// 17 composition ========================================================
			line = br.readLine();
			line2 = br2.readLine();
			data = line.split(cvsSplitBy);
			data2 = line2.split(cvsSplitBy);
			
			ArrayList<Train> trains17 = new ArrayList<Train>();
			ArrayList<trainType> types17 = new ArrayList<trainType>();
			
			arr = data[1].equals("A");
			if(arr=true){
			Train f21 = new Train(21, VIRM6, interchangable, inspect, repair, clean, wash, Integer.parseInt(data[2]));
			trains17.add(f21);
			Train f22 = new Train(22, VIRM4, interchangable, inspect, repair, clean, wash, Integer.parseInt(data[2]));
			trains17.add(f22);
			}
			this.c17 = new trainComposition(trains17, types17, Integer.parseInt(data[0]), arr, Integer.parseInt(data[2]));
			types17.add(VIRM6);
			types17.add(VIRM4);
			
			
			
			// 18 composition ========================================================
			line = br.readLine();
			line2 = br2.readLine();
			data = line.split(cvsSplitBy);
			data2 = line2.split(cvsSplitBy);
			
			ArrayList<Train> trains18 = new ArrayList<Train>();
			ArrayList<trainType> types18 = new ArrayList<trainType>();
			
			arr = data[1].equals("A");
			if(arr=true){
			Train f23 = new Train(23, SLT4, interchangable, inspect, repair, clean, wash, Integer.parseInt(data[2]));
			trains18.add(f23);
			Train f24= new Train(24, SLT4, interchangable, inspect, repair, clean, wash, Integer.parseInt(data[2]));
			trains18.add(f24);
			Train f25 = new Train(25, SLT6, interchangable, inspect, repair, clean, wash, Integer.parseInt(data[2]));
			trains18.add(f25);
			}
			this.c18 = new trainComposition(trains18, types18, Integer.parseInt(data[0]), arr, Integer.parseInt(data[2]));
			types18.add(SLT4);
			types18.add(SLT4);
			types18.add(SLT6);
			
			// 19 composition ========================================================
			line = br.readLine();
			line2 = br2.readLine();
			data = line.split(cvsSplitBy);
			data2 = line2.split(cvsSplitBy);
			
			ArrayList<Train> trains19 = new ArrayList<Train>();
			ArrayList<trainType> types19 = new ArrayList<trainType>();
			
			arr = data[1].equals("A");
			if(arr=true){
			Train f26 = new Train(26, VIRM4, interchangable, inspect, repair, clean, wash, Integer.parseInt(data[2]));
			trains19.add(f26);
			Train f27 = new Train(27, VIRM4, interchangable, inspect, repair, clean, wash, Integer.parseInt(data[2]));
			trains19.add(f27);
			}
			this.c19 = new trainComposition(trains19, types19, Integer.parseInt(data[0]), arr, Integer.parseInt(data[2]));
			types19.add(VIRM4);
			types19.add(VIRM4);
			
			// 20 composition ========================================================
			line = br.readLine();
			line2 = br2.readLine();
			data = line.split(cvsSplitBy);
			data2 = line2.split(cvsSplitBy);
			
			ArrayList<Train> trains20 = new ArrayList<Train>();
			ArrayList<trainType> types20 = new ArrayList<trainType>();
			
			arr = data[1].equals("A");
			if(arr=true){
			Train f28 = new Train(28, VIRM4, interchangable, inspect, repair, clean, wash, Integer.parseInt(data[2]));
			trains20.add(f28);
		
			}
			this.c20 = new trainComposition(trains20, types20, Integer.parseInt(data[0]), arr, Integer.parseInt(data[2]));
			types20.add(VIRM4);
			
			
			// 21 composition ========================================================
			line = br.readLine();
			line2 = br2.readLine();
			data = line.split(cvsSplitBy);
			data2 = line2.split(cvsSplitBy);
			
			ArrayList<Train> trains21 = new ArrayList<Train>();
			ArrayList<trainType> types21 = new ArrayList<trainType>();
			
			arr = data[1].equals("A");
			if(arr=true){
			Train f29 = new Train(29, SLT6, interchangable, inspect, repair, clean, wash, Integer.parseInt(data[2]));
			trains21.add(f29);
			Train f30 = new Train(30, SLT4, interchangable, inspect, repair, clean, wash, Integer.parseInt(data[2]));
			trains21.add(f30);
			Train f31 = new Train(31, SLT4, interchangable, inspect, repair, clean, wash, Integer.parseInt(data[2]));
			trains21.add(f31);
		
			}
			this.c21 = new trainComposition(trains21, types21, Integer.parseInt(data[0]), arr, Integer.parseInt(data[2]));
			types21.add(SLT6);
			types21.add(SLT4);
			types21.add(SLT4);
			
			
			// 22 composition ========================================================
			line = br.readLine();
			line2 = br2.readLine();
			data = line.split(cvsSplitBy);
			data2 = line2.split(cvsSplitBy);
			
			ArrayList<Train> trains22 = new ArrayList<Train>();
			ArrayList<trainType> types22 = new ArrayList<trainType>();
			
			arr = data[1].equals("A");
			if(arr=true){
			Train f32 = new Train(32, VIRM4, interchangable, inspect, repair, clean, wash, Integer.parseInt(data[2]));
			trains22.add(f32);
	
			}
			this.c22 = new trainComposition(trains22, types22, Integer.parseInt(data[0]), arr, Integer.parseInt(data[2]));
			types22.add(VIRM4);
	
			// 23 composition ========================================================
			line = br.readLine();
			line2 = br2.readLine();
			data = line.split(cvsSplitBy);
			data2 = line2.split(cvsSplitBy);
			
			ArrayList<Train> trains23 = new ArrayList<Train>();
			ArrayList<trainType> types23 = new ArrayList<trainType>();
			
			arr = data[1].equals("A");
			if(arr=true){
			Train f33 = new Train(33, DDZ4, interchangable, inspect, repair, clean, wash, Integer.parseInt(data[2]));
			trains23.add(f33);
	
			}
			this.c23 = new trainComposition(trains23, types23, Integer.parseInt(data[0]), arr, Integer.parseInt(data[2]));
			types23.add(DDZ4);
			
			// 24 composition ========================================================
			line = br.readLine();
			line2 = br2.readLine();
			data = line.split(cvsSplitBy);
			data2 = line2.split(cvsSplitBy);
			
			ArrayList<Train> trains24 = new ArrayList<Train>();
			ArrayList<trainType> types24 = new ArrayList<trainType>();
			
			arr = data[1].equals("A");
			if(arr=true){
			Train f33 = new Train(33, VIRM4, interchangable, inspect, repair, clean, wash, Integer.parseInt(data[2]));
			trains24.add(f33);
	
			}
			this.c24 = new trainComposition(trains24, types24, Integer.parseInt(data[0]), arr, Integer.parseInt(data[2]));
			types24.add(VIRM4);
			
			// 25 composition ========================================================
			line = br.readLine();
			line2 = br2.readLine();
			data = line.split(cvsSplitBy);
			data2 = line2.split(cvsSplitBy);
			
			ArrayList<Train> trains25 = new ArrayList<Train>();
			ArrayList<trainType> types25 = new ArrayList<trainType>();
			
			arr = data[1].equals("A");
			if(arr=true){
			Train f35 = new Train(35, VIRM4, interchangable, inspect, repair, clean, wash, Integer.parseInt(data[2]));
			trains25.add(f35);
			Train f36 = new Train(36, VIRM4, interchangable, inspect, repair, clean, wash, Integer.parseInt(data[2]));
			trains25.add(f36);
	
			}
			this.c25 = new trainComposition(trains25, types25, Integer.parseInt(data[0]), arr, Integer.parseInt(data[2]));
			types25.add(VIRM4);
			types25.add(VIRM4);
			
			// 26 composition ========================================================
			line = br.readLine();
			line2 = br2.readLine();
			data = line.split(cvsSplitBy);
			data2 = line2.split(cvsSplitBy);
			
			ArrayList<Train> trains26 = new ArrayList<Train>();
			ArrayList<trainType> types26 = new ArrayList<trainType>();
			
			arr = data[1].equals("A");
			if(arr=true){
			Train f37 = new Train(37, SLT6, interchangable, inspect, repair, clean, wash, Integer.parseInt(data[2]));
			trains26.add(f37);
	
			}
			this.c26 = new trainComposition(trains26, types26, Integer.parseInt(data[0]), arr, Integer.parseInt(data[2]));
			types26.add(SLT6);
			
			// 27 composition ========================================================
			line = br.readLine();
			line2 = br2.readLine();
			data = line.split(cvsSplitBy);
			data2 = line2.split(cvsSplitBy);
			
			ArrayList<Train> trains27 = new ArrayList<Train>();
			ArrayList<trainType> types27 = new ArrayList<trainType>();
			
			arr = data[1].equals("A");
			if(arr=true){
			Train f38 = new Train(38, SLT4, interchangable, inspect, repair, clean, wash, Integer.parseInt(data[2]));
			trains27.add(f38);
	
			}
			this.c27 = new trainComposition(trains27, types27, Integer.parseInt(data[0]), arr, Integer.parseInt(data[2]));
			types27.add(SLT4);
			
			// 28 composition ========================================================
			line = br.readLine();
			line2 = br2.readLine();
			data = line.split(cvsSplitBy);
			data2 = line2.split(cvsSplitBy);
			
			ArrayList<Train> trains28 = new ArrayList<Train>();
			ArrayList<trainType> types28 = new ArrayList<trainType>();
			
			arr = data[1].equals("A");
			if(arr=true){
			Train f39 = new Train(39, VIRM4, interchangable, inspect, repair, clean, wash, Integer.parseInt(data[2]));
			trains28.add(f39);
	
			}
			this.c28 = new trainComposition(trains28, types28, Integer.parseInt(data[0]), arr, Integer.parseInt(data[2]));
			types28.add(VIRM4);
	
			// 29 composition ========================================================
			line = br.readLine();
			line2 = br2.readLine();
			data = line.split(cvsSplitBy);
			data2 = line2.split(cvsSplitBy);
			
			ArrayList<Train> trains29 = new ArrayList<Train>();
			ArrayList<trainType> types29 = new ArrayList<trainType>();
			
			arr = data[1].equals("A");
			if(arr=true){
			Train f40 = new Train(40, SLT6, interchangable, inspect, repair, clean, wash, Integer.parseInt(data[2]));
			trains29.add(f40);
			Train f41 = new Train(41, SLT4, interchangable, inspect, repair, clean, wash, Integer.parseInt(data[2]));
			trains29.add(f41);
			}
			this.c29 = new trainComposition(trains29, types29, Integer.parseInt(data[0]), arr, Integer.parseInt(data[2]));
			types29.add(SLT6);
			types29.add(SLT4);
			
			// 30 composition ========================================================
			line = br.readLine();
			line2 = br2.readLine();
			data = line.split(cvsSplitBy);
			data2 = line2.split(cvsSplitBy);
			
			ArrayList<Train> trains30 = new ArrayList<Train>();
			ArrayList<trainType> types30 = new ArrayList<trainType>();
			
			arr = data[1].equals("A");
			if(arr=true){
			Train f42 = new Train(42, VIRM6, interchangable, inspect, repair, clean, wash, Integer.parseInt(data[2]));
			trains30.add(f42);
	
			}
			this.c30 = new trainComposition(trains30, types30, Integer.parseInt(data[0]), arr, Integer.parseInt(data[2]));
			types30.add(VIRM6);
			
			// 31 composition ========================================================
			line = br.readLine();
			line2 = br2.readLine();
			data = line.split(cvsSplitBy);
			data2 = line2.split(cvsSplitBy);
			
			ArrayList<Train> trains31 = new ArrayList<Train>();
			ArrayList<trainType> types31 = new ArrayList<trainType>();
			
			arr = data[1].equals("A");
			if(arr=true){
			Train f43 = new Train(43, DDZ6, interchangable, inspect, repair, clean, wash, Integer.parseInt(data[2]));
			trains31.add(f43);
	
			}
			this.c31 = new trainComposition(trains31, types31, Integer.parseInt(data[0]), arr, Integer.parseInt(data[2]));
			types31.add(DDZ6);
			
			// 32 composition ========================================================
			line = br.readLine();
			line2 = br2.readLine();
			data = line.split(cvsSplitBy);
			data2 = line2.split(cvsSplitBy);
			
			ArrayList<Train> trains32 = new ArrayList<Train>();
			ArrayList<trainType> types32 = new ArrayList<trainType>();
			
			arr = data[1].equals("A");
			if(arr=true){
			Train f44 = new Train(44, VIRM4, interchangable, inspect, repair, clean, wash, Integer.parseInt(data[2]));
			trains32.add(f44);
			Train f45 = new Train(45, VIRM6, interchangable, inspect, repair, clean, wash, Integer.parseInt(data[2]));
			trains32.add(f45);
	
			}
			this.c32 = new trainComposition(trains32, types32, Integer.parseInt(data[0]), arr, Integer.parseInt(data[2]));
			types32.add(VIRM4);
			types32.add(VIRM6);

			// 33 composition ========================================================
			line = br.readLine();
			line2 = br2.readLine();
			data = line.split(cvsSplitBy);
			data2 = line2.split(cvsSplitBy);
			
			ArrayList<Train> trains33 = new ArrayList<Train>();
			ArrayList<trainType> types33 = new ArrayList<trainType>();
			
			arr = data[1].equals("A");
			if(arr=true){
			Train f46 = new Train(46, VIRM6, interchangable, inspect, repair, clean, wash, Integer.parseInt(data[2]));
			trains33.add(f46);
	
			}
			this.c33 = new trainComposition(trains33, types33, Integer.parseInt(data[0]), arr, Integer.parseInt(data[2]));
			types33.add(VIRM6);
			
			// 34 composition ========================================================
			line = br.readLine();
			line2 = br2.readLine();
			data = line.split(cvsSplitBy);
			data2 = line2.split(cvsSplitBy);
			
			ArrayList<Train> trains34 = new ArrayList<Train>();
			ArrayList<trainType> types34 = new ArrayList<trainType>();
			
			arr = data[1].equals("A");
			if(arr=true){
			Train f47 = new Train(47, VIRM6, interchangable, inspect, repair, clean, wash, Integer.parseInt(data[2]));
			trains34.add(f47);
	
			}
			this.c34 = new trainComposition(trains34, types34, Integer.parseInt(data[0]), arr, Integer.parseInt(data[2]));
			types34.add(VIRM6);
			
			// 35 composition ========================================================
			line = br.readLine();
			line2 = br2.readLine();
			data = line.split(cvsSplitBy);
			data2 = line2.split(cvsSplitBy);
			
			ArrayList<Train> trains35 = new ArrayList<Train>();
			ArrayList<trainType> types35 = new ArrayList<trainType>();
			
			arr = data[1].equals("A");
			if(arr=true){
			Train f48 = new Train(48, VIRM4, interchangable, inspect, repair, clean, wash, Integer.parseInt(data[2]));
			trains35.add(f48);
	
			}
			this.c35 = new trainComposition(trains35, types35, Integer.parseInt(data[0]), arr, Integer.parseInt(data[2]));
			types35.add(VIRM4);
			
			// 36 composition ========================================================
			line = br.readLine();
			line2 = br2.readLine();
			data = line.split(cvsSplitBy);
			data2 = line2.split(cvsSplitBy);
			
			ArrayList<Train> trains36 = new ArrayList<Train>();
			ArrayList<trainType> types36 = new ArrayList<trainType>();
			
			arr = data[1].equals("A");
			if(arr=true){
			Train f49 = new Train(49, SLT4, interchangable, inspect, repair, clean, wash, Integer.parseInt(data[2]));
			trains36.add(f49);
			Train f50 = new Train(50, SLT4, interchangable, inspect, repair, clean, wash, Integer.parseInt(data[2]));
			trains36.add(f50);
	
			}
			this.c36 = new trainComposition(trains36, types36, Integer.parseInt(data[0]), arr, Integer.parseInt(data[2]));
			types36.add(SLT4);
			types36.add(SLT4);
			
			// 37 composition ========================================================
			line = br.readLine();
			line2 = br2.readLine();
			data = line.split(cvsSplitBy);
			data2 = line2.split(cvsSplitBy);
			
			ArrayList<Train> trains37 = new ArrayList<Train>();
			ArrayList<trainType> types37 = new ArrayList<trainType>();
			
			arr = data[1].equals("A");
			if(arr=true){
			Train f51 = new Train(51, SLT6, interchangable, inspect, repair, clean, wash, Integer.parseInt(data[2]));
			trains37.add(f51);
	
			}
			this.c37 = new trainComposition(trains37, types37, Integer.parseInt(data[0]), arr, Integer.parseInt(data[2]));
			types37.add(SLT6);
			
			// 38 composition ========================================================
			line = br.readLine();
			line2 = br2.readLine();
			data = line.split(cvsSplitBy);
			data2 = line2.split(cvsSplitBy);
			
			ArrayList<Train> trains38 = new ArrayList<Train>();
			ArrayList<trainType> types38 = new ArrayList<trainType>();
			
			arr = data[1].equals("A");
			if(arr=true){
			Train f52 = new Train(52, VIRM4, interchangable, inspect, repair, clean, wash, Integer.parseInt(data[2]));
			trains38.add(f52);
			Train f53 = new Train(53, VIRM4, interchangable, inspect, repair, clean, wash, Integer.parseInt(data[2]));
			trains38.add(f53);
			Train f54 = new Train(54, VIRM4, interchangable, inspect, repair, clean, wash, Integer.parseInt(data[2]));
			trains38.add(f54);
			}
			this.c38 = new trainComposition(trains38, types38, Integer.parseInt(data[0]), arr, Integer.parseInt(data[2]));
			types38.add(VIRM4);
			types38.add(VIRM4);
			types38.add(VIRM4);
			
			// 39 composition ========================================================
			line = br.readLine();
			line2 = br2.readLine();
			data = line.split(cvsSplitBy);
			data2 = line2.split(cvsSplitBy);
			
			ArrayList<Train> trains39 = new ArrayList<Train>();
			ArrayList<trainType> types39 = new ArrayList<trainType>();
			
			arr = data[1].equals("A");
			if(arr=true){
			Train f55 = new Train(55, SLT6, interchangable, inspect, repair, clean, wash, Integer.parseInt(data[2]));
			trains39.add(f55);
			Train f56 = new Train(56, SLT4, interchangable, inspect, repair, clean, wash, Integer.parseInt(data[2]));
			trains39.add(f56);
			Train f57 = new Train(57, SLT4, interchangable, inspect, repair, clean, wash, Integer.parseInt(data[2]));
			trains39.add(f57);
			}
			this.c39 = new trainComposition(trains39, types39, Integer.parseInt(data[0]), arr, Integer.parseInt(data[2]));
			types39.add(SLT6);
			types39.add(SLT4);
			types39.add(SLT4);
			
			// 40 composition ========================================================
			line = br.readLine();
			line2 = br2.readLine();
			data = line.split(cvsSplitBy);
			data2 = line2.split(cvsSplitBy);
			
			ArrayList<Train> trains40 = new ArrayList<Train>();
			ArrayList<trainType> types40 = new ArrayList<trainType>();
			
			arr = data[1].equals("A");
			if(arr=true){
			Train f58 = new Train(58, VIRM4, interchangable, inspect, repair, clean, wash, Integer.parseInt(data[2]));
			trains40.add(f58);
			}
			this.c40 = new trainComposition(trains40, types40, Integer.parseInt(data[0]), arr, Integer.parseInt(data[2]));
			types40.add(VIRM4);
			
			
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
	
	public void initializeTypes(){	
		trainType VIRM4 = new trainType(109, 0, 0, 0, 0);
		trainType VIRM6 = new trainType(162, 0, 0, 0, 0);
		trainType DDZ4 = new trainType(101, 0, 0, 0, 0);
		trainType DDZ6 = new trainType(154, 0, 0, 0, 0);
		trainType SLT4 = new trainType(70, 0, 0, 0, 0);
		trainType SLT6 = new trainType(101, 0, 0, 0, 0);
		
//		String csvFile = "C:/Users/piepj_000/OneDrive/Documenten/Econometrie/Master/Seminar/Data/KleineBinckhorstTypes.csv";
//		BufferedReader br = null;
//		String cvsSplitBy = ";"; 
//		String line = "";
//
//		try {
//			br = new BufferedReader(new FileReader(csvFile));
//			//If dynamic names possible use while loop
//			//		while ((line = br.readLine()) != null) {
//			//			count = count +1;
//			//			String[] type = line.split(cvsSplitBy);
//			//			if(count>2){
//			//			
//			//			//String name = type[0].concat(type[1]);
//			//			trainType names.get(1) = new trainType(Integer.parseInt(type[5]), 0, 0, 0, 0);	
//			//			System.out.println("type:" + type[0] );
//			//			System.out.println("carriages: " + type[1]);
//			//			System.out.println("length: " + type[5]);
//			//			}
//			//			System.out.println("tester: " + VIRM4.getLength());
//			//		}
//			line = br.readLine();
//			String[] type = line.split(cvsSplitBy); //dutch line
//			line = br.readLine();
//			type = line.split(cvsSplitBy); //english line
//			
//			line = br.readLine();
//			type = line.split(cvsSplitBy);
//			this.VIRM4 = new trainType(Integer.parseInt(type[5]), 0, 0, 0, 0);
//
//			line = br.readLine();
//			this.VIRM6 = new trainType(Integer.parseInt(type[5]), 0, 0, 0, 0);
//			
//			line = br.readLine();
//			type = line.split(cvsSplitBy);
//			this.DDZ4 = new trainType(Integer.parseInt(type[5]), 0, 0, 0, 0);
//
//			line = br.readLine();
//			type = line.split(cvsSplitBy);
//			this.DDZ6 = new trainType(Integer.parseInt(type[5]), 0, 0, 0, 0);
//
//			line = br.readLine();
//			type = line.split(cvsSplitBy);
//			this.SLT4 = new trainType(Integer.parseInt(type[5]), 0, 0, 0, 0);
//
//			line = br.readLine();
//			type = line.split(cvsSplitBy);
//			this.SLT6 = new trainType(Integer.parseInt(type[5]), 0, 0, 0, 0);
//
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			if (br != null) {
//				try {
//					br.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//		}
	}
	
}