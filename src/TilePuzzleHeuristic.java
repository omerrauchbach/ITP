
public class TilePuzzleHeuristic implements IHeuristic
{
	private int[][] four = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,0}} ;
	private int[][] three = {{1,2,3},{4,5,6} ,{7,8,0}} ;
	@Override
	public double getHeuristic
	(
		IProblemState problemState
	) 
	{
		if(problemState.isGoalState())
			return 0;
		int H ;
		int out = 0;
		int manhattan = 0;

		TilePuzzle tile = ((TilePuzzle)problemState.getProblem()) ;
		int[][] tileArray = tile._tilePuzzle;
		int number = 1;
		for(int row=0 ; row< tileArray.length ; ++row){
			for(int col =0 ; col < tileArray[0].length ; ++col ){

				if( tileArray[row][col]!= 0&&number != tileArray[row][col]) {
					out++;
					int[] finalTile =  gettile( tileArray.length , tileArray[row][col]);
					manhattan = manhattan+  Math.abs(row-getRaw(tileArray.length, tileArray[row][col]))+ Math.abs(col-getCol(tileArray.length, tileArray[row][col])) ;
				}
				number++;
			}

		}
		H = manhattan/out;
		return H;
	}

	private int[] gettile(int n , int tileValue){
		int[] res = new int[2] ;
		if(n==4){
			for(int i =0 ;i< n ; ++i)
				for(int j =0 ; j<n ; ++j){
				if(four[i][j] == tileValue)
					res[0] = i ;
					res[1] = j ;
				}
		}else{
			for(int i =0 ;i< n ; ++i)
				for(int j =0 ; j<n ; ++j){
					if(three[i][j] == tileValue)
						res[0] = i ;
						res[1] = j ;
				}


		}

		return res;
	}

	private int getRaw(int n , int tileValue){
		return (tileValue-1)/n ;
	}

	private int getCol(int n , int tileValue){
		return (tileValue-1)%n ;
	}
/*
	private int manhattan(int[][] tileArray , int row , int col , int number){

		int rowNumber =-1 ;
		int colNumber = -1 ;
		int tmpNumber = number;
		while(tmpNumber>=0){
			rowNumber++;
			tmpNumber = tmpNumber - tileArray.length;

		}
		 tmpNumber = number;
		while(tmpNumber>=0){
			colNumber++;
			tmpNumber = tmpNumber - tileArray[0].length;

		}
		//colNumber = number%tileArray[0].length -1 ;

		int manhattanRes = Math.abs(row-rowNumber)+ Math.abs(col-colNumber);
		return manhattanRes;

	}
	*/
	
}
