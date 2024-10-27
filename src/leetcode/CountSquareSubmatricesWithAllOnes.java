package leetcode;

import java.util.Arrays;

public class CountSquareSubmatricesWithAllOnes {

	/**
	 * 
	 * Top Down Approach
	 * 
	 * @param matrix
	 * @return
	 */
	public int countSquares(int[][] matrix) {
		int ans = 0;
		int[][] dp = new int[matrix.length][matrix[0].length];
		for (int[] d : dp) {
			Arrays.fill(d, -1);
		}
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == 1) {
					ans += dfs(matrix, dp, i, j);
				}
			}
		}
		return ans;
	}

	/**
	 * Top down approach
	 * 
	 * @param matrix
	 * @param dp
	 * @param i
	 * @param j
	 * @return
	 */

	private int dfs(int[][] matrix, int[][] dp, int i, int j) {
		if (i < 0 || j < 0 || j >= matrix[0].length || i >= matrix.length) {
			return 0;
		}
		if (matrix[i][j] == 0)
			return 0;

		if (dp[i][j] != -1)
			return dp[i][j];

		int right = dfs(matrix, dp, i, j + 1);
		int diag = dfs(matrix, dp, i + 1, j + 1);
		int down = dfs(matrix, dp, i + 1, j);
		dp[i][j] = 1 + Math.min(diag, Math.min(down, right));
		return dp[i][j];
	}

	public int countSquaresBU(int[][] matrix) {
		int ans = 0;
		int[][] dp = new int[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = matrix[i][j];
				} else if (matrix[i][j] == 1) {
					dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1]));
				}
				ans += dp[i][j];
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		System.out.println(new CountSquareSubmatricesWithAllOnes()
				.countSquares(new int[][] { { 0, 1, 1, 1 }, { 1, 1, 1, 1 }, { 0, 1, 1, 1 } }));

	}

}
