package leetcode;

public class MinimumPathCostInAGrid {

	public int minPathCost(int[][] grid, int[][] move) {
		int m = grid.length;
		int n = grid[0].length;
		int[][] dp = new int[m][n];

		for (int i = 0; i < n; i++) {
			dp[0][i] = grid[0][i];
		}

		for (int i = 1; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int min = Integer.MAX_VALUE;
				for (int k = 0; k < n; k++) {
					int x = grid[i - 1][k];
					min = Math.min(min, move[x][j] + dp[i - 1][k]);
				}
				dp[i][j] = min + grid[i][j];
			}
		}
		int ans = Integer.MAX_VALUE;
		for (int i : dp[m - 1]) {
			ans = Math.min(i, ans);
		}
		return ans;
	}

	public static void main(String[] args) {
		System.out.println(new MinimumPathCostInAGrid().minPathCost(new int[][] { { 5, 3 }, { 4, 0 }, { 2, 1 } },
				new int[][] { { 9, 8 }, { 1, 5 }, { 10, 12 }, { 18, 6 }, { 2, 4 }, { 14, 3 } }));

	}

}
