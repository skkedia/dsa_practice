package leetcode;

public class CountUnguardedCellsInTheGrid {

	public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
		int ans = 0;

		int[][] grid = new int[m][n];

		for (int[] guard : guards) {
			grid[guard[0]][guard[1]] = 1;
		}

		for (int[] wall : walls) {
			grid[wall[0]][wall[1]] = 2;
		}

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 1) {
					markStuff(grid, i, j);
				}
			}
		}

		for (int[] row : grid) {
			for (int cell : row) {
				if (cell == 0)
					ans++;
			}
		}

		return ans;
	}

	private void markStuff(int[][] grid, int r, int c) {

		// right
		for (int i = c + 1; i < grid[0].length; i++) {
			if (grid[r][i] == 2 || grid[r][i] == 1) {
				break;
			}
			if (grid[r][i] == 0) {
				grid[r][i] = 3;
			}
		}

		// left
		for (int i = c - 1; i >= 0; i--) {
			if (grid[r][i] == 2 || grid[r][i] == 1) {
				break;
			}
			if (grid[r][i] == 0) {
				grid[r][i] = 3;
			}
		}

		// up
		for (int i = r - 1; i >= 0; i--) {
			if (grid[i][c] == 2 || grid[i][c] == 1) {
				break;
			}
			if (grid[i][c] == 0) {
				grid[i][c] = 3;
			}
		}

		// down
		for (int i = r + 1; i < grid.length; i++) {
			if (grid[i][c] == 2 || grid[i][c] == 1) {
				break;
			}
			if (grid[i][c] == 0) {
				grid[i][c] = 3;
			}
		}

	}

	public static void main(String[] args) {

	}

}
