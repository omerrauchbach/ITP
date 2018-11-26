
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
		int manhattan = 0;

		TilePuzzle tile = ((TilePuzzle)problemState.getProblem()) ;
		int[][] tileArray = tile._tilePuzzle;
		int number = 1;
		for(int row=0 ; row< tileArray.length ; ++row){
			for(int col =0 ; col < tileArray[0].length ; ++col ){

				if( tileArray[row][col]!= 0&&number != tileArray[row][col]) {
					manhattan = manhattan+Math.abs(row-getRaw(tileArray.length, tileArray[row][col]))+ Math.abs(col-getCol(tileArray.length, tileArray[row][col])) ;
				}
				number++;
			}

		}

		int H= linerCol(tileArray)+linerRow(tileArray);
		return (manhattan+H);
	}



	private int getRaw(int n , int tileValue){
		return (tileValue-1)/n ;
	}

	private int getCol(int n , int tileValue){
		return (tileValue-1)%n ;
	}

	private int linerRow(int[][] arrayTile){

		int n = arrayTile.length;
		int res =0;
		for (int row = 0; row <n; row++){
			int max = -1;
			for (int col = 0;  col < row; col++){
				int tileValue = arrayTile[row][col];
				if (tileValue != 0 && getRaw(n ,tileValue) == row){
					if (tileValue > max){
						max = tileValue;
					}else {
						res += 2;
					}
				}

			}

		}

		return res;
	}

	private int linerCol(int[][] arrayTile){

		int n = arrayTile.length;
		int res =0;
		for (int col = 0; col <n; col++){
			int max = -1;
			for (int row = 0;  row < col; row++){
				int tileValue = arrayTile[row][col];
				if (tileValue != 0 && getCol(n ,tileValue) == row){
					if (tileValue > max){
						max = tileValue;
					}else {
						res += 2;
					}
				}

			}

		}

		return res;
	}


	
}
