package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

	public int orangesRotting(int[][] grid) {
		if (grid == null || grid.length == 0) {
			return 0;
		}
		int countOfFreshOranges = 0;
		Queue<int[]> qu = new LinkedList<>();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 2) {
					qu.add(new int[] { i, j });
				} else if (grid[i][j] == 1) {
					countOfFreshOranges++;
				}
			}
		}

		if (countOfFreshOranges == 0) {
			return 0;
		}
		int timeElapsed = 0;
		int[][] dirs = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
		while (!qu.isEmpty()) {
			timeElapsed++;
			for (int i = 0; i < qu.size(); i++) {
				int[] point = qu.poll();
				for (int[] dir : dirs) {
					int x = point[0] + dir[0];
					int y = point[1] + dir[1];
					if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && grid[x][y] == 1) {
						grid[x][y] = 2;
						qu.add(new int[] { x, y });
						countOfFreshOranges--;
					}
				}
			}
		}
		return countOfFreshOranges == 0 ? timeElapsed - 1 : -1;
	}

	public static void main(String[] args) {
		System.out.println(new RottingOranges().orangesRotting(new int[][] { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } }));
	}

}
