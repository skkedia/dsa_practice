package leetcode;

public class UniquePathsII {

	public int uniquePathsWithObstacles(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int[][] dp = new int[m][n];

		for (int i = 0; i < n; i++) {
			if (grid[0][i] == 1)
				break;
			dp[0][i] = 1;
		}

		for (int i = 0; i < m; i++) {
			if (grid[i][0] == 1)
				break;
			dp[i][0] = 1;
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (grid[i][j] == 1) {
					continue;
				}
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		}
		return dp[m - 1][n - 1];
	}

	public static void main(String[] args) {
		System.out.println(
				new UniquePathsII().uniquePathsWithObstacles(new int[][] { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } }));

	}

}
