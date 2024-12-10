package leetcode;

public class IslandPerimeter {

	public int islandPerimeter(int[][] grid) {
		int ans = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 1) {
					ans += 4;
					if (i > 0 && grid[i - 1][j] == 1) {
						ans = ans - 2;
					} else if (j > 0 && grid[i][j - 1] == 1) {
						ans = ans - 2;
					}
				}
			}
		}
		return ans;
	}

	public static void main(String[] args) {

	}

}
