package leetcode;

public class MaximumAmountOfMoneyRobotCanEarn {

	public int maximumAmount(int[][] coins) {

		int m = coins.length;
		int n = coins[0].length;

		// DP table: dp[i][j][k] -> max profit at (i, j) with k neutralizations
		int[][][] dp = new int[m][n][3];

		// Initialize the DP table
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < 3; k++) {
					dp[i][j][k] = Integer.MIN_VALUE;
				}
			}
		}

		// Base case: starting point
		dp[0][0][0] = coins[0][0] >= 0 ? coins[0][0] : 0;
		if (coins[0][0] < 0) {
			dp[0][0][1] = 0; // Neutralize the robber
		}

		// Fill the DP table
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < 3; k++) {
					if (dp[i][j][k] == Integer.MIN_VALUE)
						continue;

					// Move down
					if (i + 1 < m) {
						int value = coins[i + 1][j];
						if (value >= 0) {
							dp[i + 1][j][k] = Math.max(dp[i + 1][j][k], dp[i][j][k] + value);
						} else {
							dp[i + 1][j][k] = Math.max(dp[i + 1][j][k], dp[i][j][k] + value);
							if (k + 1 < 3) {
								dp[i + 1][j][k + 1] = Math.max(dp[i + 1][j][k + 1], dp[i][j][k]);
							}
						}
					}

					// Move right
					if (j + 1 < n) {
						int value = coins[i][j + 1];
						if (value >= 0) {
							dp[i][j + 1][k] = Math.max(dp[i][j + 1][k], dp[i][j][k] + value);
						} else {
							dp[i][j + 1][k] = Math.max(dp[i][j + 1][k], dp[i][j][k] + value);
							if (k + 1 < 3) {
								dp[i][j + 1][k + 1] = Math.max(dp[i][j + 1][k + 1], dp[i][j][k]);
							}
						}
					}
				}
			}
		}

		// Get the result from the bottom-right corner
		return Math.max(dp[m - 1][n - 1][0], Math.max(dp[m - 1][n - 1][1], dp[m - 1][n - 1][2]));

	}

	public static void main(String[] args) {
		int[][] coins = { { -7, 12, 12, 13 }, { -6, 19, 19, -6 }, { 9, -2, -10, 16 }, { -4, 14, -10, -9 } };
		System.out.println(new MaximumAmountOfMoneyRobotCanEarn().maximumAmount(coins));

	}

	static class a {

	}
}
