
public class NQueen {
	/**
	 * @param board : 2d matrix
	 * @param dimensionOfMatrix
	 */
	void printBoard(int board[][], int dimensionOfMatrix ){ 
		//print board which is has queens
		for (int i = 0; i < dimensionOfMatrix; i++){ 
			for (int j = 0; j < dimensionOfMatrix; j++){ 
				System.out.print(" " + board[i][j] + " "); 
			}
			System.out.println(); 
		} 
	} 

	/**
	 * @param board : matrix
	 * @param row : current row of matrix at which we are looking to place a queen
	 * @param col : current column of matrix at which we are looking to place a queen
	 * @param dimension Of Matrix
	 * @return boolean : true if it is valid else false
	 */
	boolean  isValidToPlaceQueen(int board[][], int row, int col,int dimensionOfMatrix){ 
		int i, j; 
		for (i = row-1; i >= 0; i--){ 
			if (board[i][col] == 1){ 
				// If queen exist in upper row
				return false;    
			}
		}
		for (i = row, j = col; i >= 0 && j >= 0; i--, j--){ 
			if (board[i][j] == 1){ 
				//if queen exist in upper left diagonal
				return false;   
			}
		}

		for (i = row, j = col; i >= 0 && j < dimensionOfMatrix; i--, j++){ 
			if (board[i][j] == 1){ 
				//if queen exist in upper right diagonal
				return false;   
			}
		}
		return true; 
	}

	/**
	 * @param board
	 * @param startRow row at which we need to place a queen
	 * @param dimensionOfMatrix
	 * @return true if solution exist else false
	 */
	boolean nQueen(int[][] board,int startRow,int dimensionOfMatrix){
		// if all rows are filled with queens then solution exist 
		if (startRow >= dimensionOfMatrix){     
			printBoard(board,dimensionOfMatrix);
			return true;
		}
		for (int i = 0; i < dimensionOfMatrix; i++){ 
			// check if valid then place queen
			if (isValidToPlaceQueen(board,startRow,i,dimensionOfMatrix)){ 
				board[startRow][i] = 1; 
				//recursive call with next row as starting row
				if (nQueen(board, startRow + 1, dimensionOfMatrix)){
					return true; 
				}
				// backtrack
				board[startRow][i] = 0; 
			} 
		} 
		return false;
	}
}
