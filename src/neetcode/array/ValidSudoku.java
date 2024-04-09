package array;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

	public boolean isValidSudoku(char[][] board) {
		Set<String> hs = new HashSet<>();

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] != '.') {
					if (!hs.add(board[i][j] + "in row" + i) || !hs.add(board[i][j] + "in col" + j)
							|| !hs.add(board[i][j] + "in block" + i / 3 + "-" + j / 3)) {
						return false;
					}
				}
			}
		}
		return true;
	}
}
