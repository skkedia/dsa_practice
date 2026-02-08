package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumKnightMoves {

	public int minKnightMoves(int x, int y) {
		if (x == 0 && y == 0)
			return 0;
		int[][] dirs = new int[][] { { 1, 2 }, { 2, 1 }, { 2, -1 }, { 1, -2 }, { -1, -2 }, { -2, -1 }, { -2, 1 },
				{ -1, 2 } };
		Queue<int[]> qu = new LinkedList<>();
		boolean[][] vis = new boolean[607][607];
		qu.offer(new int[] { 0, 0 });
		int steps = 0;

		while (!qu.isEmpty()) {
			steps = steps + 1;
			int size = qu.size();
			for (int i = 0; i < size; i++) {
				int[] cur = qu.poll();
				for (int[] dir : dirs) {
					int nx = cur[0] + dir[0];
					int ny = cur[1] + dir[1];
					if (nx == x && ny == y) {
						return steps;
					}
					if (!vis[nx + 302][ny + 302]) {
						vis[nx + 302][ny + 302] = true;
						qu.offer(new int[] { nx, ny });
					}
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {

	}

}
