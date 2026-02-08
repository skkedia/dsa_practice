package leetcode;

public class DesignTicTacToe {

	class TicTacToe {
		int[][] board;

		public TicTacToe(int n) {
			board = new int[n][n];
		}

		public int move(int row, int col, int player) {
			board[row][col] = player;
			boolean flag = true;
			for (int i = 0; i < board.length; i++) {
				if (board[row][i] != player) {
					flag = false;
					break;
				}
			}
			if (flag)
				return player;
			flag = true;
			for (int i = 0; i < board.length; i++) {
				if (board[i][col] != player) {
					flag = false;
					break;
				}
			}

			if (flag)
				return player;

			if (row == col) {
				flag = true;
				for (int i = 0; i < board.length; i++) {
					if (board[i][i] != player) {
						flag = false;
						break;
					}
				}
			}

			if (flag)
				return player;

			if (col == board.length - row - 1) {
				flag = true;
				for (int i = 0; i < board.length; i++) {
					if (board[i][board.length - i - 1] != player) {
						flag = false;
						break;
					}
				}
			}
			if (flag)
				return player;
			return 0;

		}
	}

	public static void main(String[] args) {
		TicTacToe ticTacToe = new DesignTicTacToe().new TicTacToe(3);
		ticTacToe.move(0, 0, 1); // return 0 (no one wins)
		ticTacToe.move(0, 2, 2); // return 0 (no one wins)
		ticTacToe.move(2, 2, 1); // return 0 (no one wins)
		ticTacToe.move(1, 1, 2); // return 0 (no one wins)
		ticTacToe.move(2, 0, 1); // return 0 (no one wins)
		ticTacToe.move(1, 0, 2); // return 0 (no one wins)
		ticTacToe.move(2, 1, 1); // return 1 (player 1 wins)
	}

}
