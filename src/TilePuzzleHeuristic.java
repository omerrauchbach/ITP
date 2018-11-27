
public class TilePuzzleHeuristic implements IHeuristic
{
	@Override
	public double getHeuristic
	(
		IProblemState problemState
	)
	{
		if(problemState.isGoalState())
			return 0;
		int manhattan = 0;
		int[][] tileArray = ((TilePuzzleState)problemState)._tilePuzzle;
		int N = tileArray.length;
		int H ;
		int number = 1;
		for(int row=0 ; row< N ; ++row){
			for(int col =0 ; col < N ; ++col ){
				int value = tileArray[row][col] ;
				if( value!= 0&&number != value) {
					manhattan = manhattan+value*(Math.abs(row-getRaw(N, value))+ Math.abs(col-getCol(N,value))) ;
				}
				else if(value==0){
					manhattan = manhattan+Math.abs(row-N-1)+ Math.abs(col-N-1);
				}
			}
		}

		H= 3*(linerCol(tileArray)+linerRow(tileArray));
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
		for (int row = 0; row < n; row++){
			int max = -1;
			for (int col= 0;  col < n; col++){
				int value = arrayTile[row][col];
				if (value != 0 && getRaw(n,value) == row){
					if (value > max) {
						max=value;
					} else {
						res+=value;
					}
				}

			}

		}
		return res;
	}

	private int linerCol(int[][] arrayTile){
		int n = arrayTile.length;
		int res =0;
		for (int col = 0; col < n; col++){
			int max = -1;
			for (int row= 0; row< n; row++){
				int value = arrayTile[row][col];
				if (value != 0 && getCol(n,value) == col){
					if (value > max) {
						max = value;
					} else {
						res += value;
					}
				}

			}

		}
		return res;
	}



}
