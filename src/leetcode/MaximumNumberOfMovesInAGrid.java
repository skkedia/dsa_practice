package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumNumberOfMovesInAGrid {

	public int maxMoves(int[][] grid) {
		if (grid == null || grid.length == 0)
			return -1;
		int max = Integer.MIN_VALUE;
		Queue<int[]> qu = new LinkedList<>();
		boolean[][] visited = new boolean[grid.length][grid[0].length];
		for (int i = 0; i < grid.length; i++) {
			visited[i][0] = true;
			qu.add(new int[] { i, 0, 0 });
		}
		int[][] dirs = new int[][] { { -1, 1 }, { 0, 1 }, { 1, 1 } };

		while (!qu.isEmpty()) {
			int size = qu.size();
			while (size > 0) {
				int[] meta = qu.poll();
				max = Math.max(max, meta[2]);
				for (int[] dir : dirs) {
					int x = meta[0] + dir[0];
					int y = meta[1] + dir[1];
					if (x > -1 && y > -1 && x < grid.length && y < grid[0].length && grid[x][y] > grid[meta[0]][meta[1]]
							&& visited[x][y] == false) {
						visited[x][y] = true;
						qu.offer(new int[] { x, y, meta[2] + 1 });
					}
				}
				size--;
			}
		}
		return max;
	}

	public static void main(String[] args) {

	}

}
