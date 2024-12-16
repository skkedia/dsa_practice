package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class MaxAreaOfIsland {

	public int maxAreaOfIsland(int[][] grid) {
		int max = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 1) {
					max = Math.max(max, bfs(i, j, grid));
				}
			}
		}
		return max;
	}

	private int bfs(int i, int j, int[][] grid) {
		int area = 1;
		Queue<int[]> qu = new LinkedList<>();
		qu.offer(new int[] { i, j });
		grid[i][j] = 0;
		int[][] dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
		while (!qu.isEmpty()) {
			int[] cur = qu.poll();
			for (int[] dir : dirs) {
				int x = cur[0] + dir[0];
				int y = cur[1] + dir[1];
				if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1) {
					grid[x][y] = 0;
					area++;
					qu.offer(new int[] { x, y });
				}
			}
		}
		return area;
	}

	public static void main(String[] args) {
		System.out.println(new MaxAreaOfIsland().maxAreaOfIsland(
				new int[][] { { 1, 1, 0, 0, 0 }, { 1, 1, 0, 0, 0 }, { 0, 0, 0, 1, 1 }, { 0, 0, 0, 1, 1 } }));
	}

}
