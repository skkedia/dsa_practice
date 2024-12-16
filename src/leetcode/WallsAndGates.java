package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGates {

	public void wallsAndGates(int[][] rooms) {
		Queue<int[]> gates = new LinkedList<>();
		for (int i = 0; i < rooms.length; i++) {
			for (int j = 0; j < rooms[i].length; j++) {
				if (rooms[i][j] == 0)
					gates.offer(new int[] { i, j });
			}
		}

		int[][] dirs = new int[][] { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

		while (!gates.isEmpty()) {
			int[] gate = gates.poll();
			Queue<int[]> points = new LinkedList<>();
			boolean[][] vis = new boolean[rooms.length][rooms[0].length];

			for (int[] dir : dirs) {
				if (isValid(dir, gate, rooms)) {
					points.offer(new int[] { gate[0] + dir[0], gate[1] + dir[1] });
				}
			}
			int dist = 1;
			while (!points.isEmpty()) {
				int size = points.size();
				for (int i = 0; i < size; i++) {
					int[] empty = points.poll();
					int x = empty[0];
					int y = empty[1];
					rooms[x][y] = Math.min(dist, rooms[x][y]);
					vis[x][y] = true;
					for (int[] dir : dirs) {
						if (isValid(dir, empty, rooms) && !vis[x + dir[0]][y + dir[1]]) {
							points.offer(new int[] { x + dir[0], y + dir[1] });
						}
					}
				}
				dist++;
			}
			for (int[] room : rooms) {
				System.out.println(Arrays.toString(room));
			}
			System.out.println("new gate");
			System.out.println();
		}
	}

	private boolean isValid(int[] dir, int[] cur, int[][] rooms) {
		int x = dir[0] + cur[0];
		int y = dir[1] + cur[1];
		if (x >= 0 && y >= 0 && x < rooms.length && y < rooms[0].length && rooms[x][y] != 0 && rooms[x][y] != -1) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		new WallsAndGates().wallsAndGates(
				new int[][] { { 2147483647, -1, 0, 2147483647 }, { 2147483647, 2147483647, 2147483647, -1 },
						{ 2147483647, -1, 2147483647, -1 }, { 0, -1, 2147483647, 2147483647 } });
	}

}
