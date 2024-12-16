package leetcode;

public class BattleshipsInABoard {

	public int countBattleships(char[][] board) {
		int ans = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == 'X') {
					ans++;
					if (i > 0 && board[i - 1][j] == 'X') {
						ans--;
					} else if (j > 0 && board[i][j - 1] == 'X') {
						ans--;
					}
				}
			}
		}
		return ans;
	}

	public static void main(String[] args) {

	}

}
