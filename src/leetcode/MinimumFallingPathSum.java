package leetcode;

public class MinimumFallingPathSum {

	public int minFallingPathSum(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		int[][] dp = new int[m][n];
		for (int i = 0; i < n; i++) {
			dp[0][i] = matrix[0][i];
		}

		for (int i = 1; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (j == 0) {
					dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j], dp[i - 1][j + 1]);
				} else if (j == n - 1) {
					dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j - 1], dp[i - 1][j]);
				} else {
					dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j + 1]));
				}
			}
		}
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			ans = Math.min(ans, dp[m - 1][i]);
		}
		return ans;

	}

	public static void main(String[] args) {

	}

}
