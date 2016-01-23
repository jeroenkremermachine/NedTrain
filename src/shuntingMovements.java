import java.util.ArrayList;

public class shuntingMovements {



		private boolean possibleMove = true;
		private boolean wash = false;
		private boolean repair = false;
		private ArrayList<Integer> positions;




		public shuntingMovements(int start, int end, int[][] tp, ArrayList<Integer> wp, ArrayList<Integer> rp, ArrayList<Integer> positions) 
		{

			this.positions = positions;
			
			// first, adjust tpm to cancel out filled tracks

			int[][] newtp = tp;
			for (int i = 0; i<=4;i++)
			{
				if (positions.get(i) ==1)
					for (int p = 0; p<=4; p++) 
					{
						newtp[p][i] = 0;
					}
			}

			
			// check if desired movement is possible

			if (newtp[start][end] == 0 )
			{possibleMove = false ;}
			else 
			{
				positions.set(start, 0);
				positions.set(end, 1);
			}  

			if (possibleMove == true && wp.get(0) == end)
			{ wash = true ;

			}

		}


		public boolean getpossibleMove() {	
			return possibleMove ; 
		} 

		public boolean getWashed() {
			return wash ; 
		} 

		public ArrayList<Integer> getPositions() {
			return positions;
		}


	}




















    
	
	
	


