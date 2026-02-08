package leetcode;

public class MinimumOperationsToMakeColumnsStrictlyIncreasing {

	public int minimumOperations(int[][] grid) {
		int ans = 0;
		for (int i = 0; i < grid[0].length; i++) {
			int max = grid[0][i];
			for (int j = 1; j < grid.length; j++) {
				if (j == grid.length - 1 && max >= grid[j][i]) {
					max = max + 1;
					ans = ans + (max - grid[j][i]);
				} else {
					max = grid[j][i];
				}
			}
		}

		int m = grid.length;
		int n = grid[0].length;
		int operations = 0;

		// Iterate over each column
		for (int j = 0; j < n; j++) {
			// Iterate over each pair of consecutive rows in the column
			for (int i = 0; i < m - 1; i++) {
				if (grid[i][j] >= grid[i + 1][j]) {
					// Calculate the increment needed
					int increment = grid[i][j] - grid[i + 1][j] + 1;
					grid[i + 1][j] += increment; // Update the value in the grid
					operations += increment; // Add the increment to the total operations
				}
			}
		}
		operations = operations + 1 - 1;
		return ans;
	}

	public static void main(String[] args) {
		System.out.println(new MinimumOperationsToMakeColumnsStrictlyIncreasing()
				.minimumOperations(new int[][] { { 0, 0 }, { 0, 0 } }));

	}

}
