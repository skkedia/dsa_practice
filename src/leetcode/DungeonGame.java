package leetcode;

import java.util.Arrays;

public class DungeonGame {

	public int calculateMinimumHP(int[][] dungeon) {
		int m = dungeon.length;
		int n = dungeon[0].length;
		int[][] dp = new int[m][n];
		for (int[] d : dp) {
			Arrays.fill(d, Integer.MAX_VALUE);
		}
		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				int curCell = dungeon[i][j];
				int right = getMin(dungeon, dp, curCell, i, j + 1);
				int down = getMin(dungeon, dp, curCell, i + 1, j);
				int next = Math.min(right, down);
				if (next != Integer.MAX_VALUE) {
					dp[i][j] = next;
				} else {
					dp[i][j] = curCell >= 0 ? 1 : 1 - curCell;
				}
			}
		}
		return dp[0][0];
	}

	private int getMin(int[][] dungeon, int[][] dp, int cur, int nr, int nc) {
		if (nr >= dungeon.length || nc >= dungeon[0].length) {
			return Integer.MAX_VALUE;
		}
		return Math.max(1, dp[nr][nc] - cur);
	}

	public static void main(String[] args) {
		System.out.println(
				new DungeonGame().calculateMinimumHP(new int[][] { { -2, -3, 3 }, { -5, -10, 1 }, { 10, 30, -5 } }));
	}

}
