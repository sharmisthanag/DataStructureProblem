
public class NQueenProblemSolve {

	public static void main(String[] args) {
		int numberOfQueen=4;
		int[][] board=new int[numberOfQueen][numberOfQueen];
		if(findSol(board,numberOfQueen,0)==true){
			printBoard(board);
		}
		else{
			System.out.println("Sol doesn't exist");
		}
	}	
	private static void printBoard(int[][] board) {
		for (int i = 0; i < board.length; i++){
			for (int j = 0; j < board.length; j++)
				System.out.print(" " + board[i][j]+ " ");
			System.out.println();
		}
	}
	private static boolean findSol(int[][] board, int numberOfQueen, int row) {
		if(row>=numberOfQueen){
			return true;
		}
		for(int col=0;col<numberOfQueen;col++){
			if(checkSafe(board,row,col) == true){
				board[row][col]=1;
				if(findSol(board, numberOfQueen, row+1) ==true){
					return true;
				}
				board[row][col]=0;
			}
			
		}
		
		return false;
	}
	private static boolean checkSafe(int[][] board, int row, int col) {
		if(row==0 && col==0)return true;
		
		for(int i=0;i<board.length;i++){
			if(board[row][i]==1 || board[i][col]==1)return false;
		}
		
		int sum=row+col;int diff=row-col;
		for(int i=0;i<row;i++){
			for(int j=0;j<board.length;j++){
				if((i+j)==sum && board[i][j]==1)return false;
				else if((i-j)==diff && board[i][j]==1)return false;
			}
		}
		return true;
	}

}
