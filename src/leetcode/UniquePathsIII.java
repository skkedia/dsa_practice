package leetcode;

public class UniquePathsIII {

	private int ans = 0;

	public int uniquePathsIII(int[][] grid) {
		ans = 0;
		int startRow = 0;
		int startCol = 0;
		int cells = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					startRow = i;
					startCol = j;
				}
				if (grid[i][j] >= 0) {
					cells++;
				}
			}
		}
		findAllPaths(grid, startRow, startCol, cells);
		return ans;
	}

	private void findAllPaths(int[][] grid, int curRow, int curCol, int cells) {
		if (grid[curRow][curCol] == 2 && cells == 1) {
			ans = ans + 1;
			return;
		}
		int temp = grid[curRow][curCol];
		grid[curRow][curCol] = -2;
		cells = cells - 1;
		int[][] dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
		for (int[] dir : dirs) {
			int nRow = curRow + dir[0];
			int nCol = curCol + dir[1];
			if (nRow < 0 || nRow >= grid.length || nCol < 0 || nCol >= grid[0].length || grid[nRow][nCol] < 0) {
				continue;
			}
			findAllPaths(grid, nRow, nCol, cells);
		}
		grid[curRow][curCol] = temp;
	}

	public static void main(String[] args) {

	}

}
