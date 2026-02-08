package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PacificAtlanticWaterFlow {
	public List<List<Integer>> pacificAtlantic(int[][] heights) {
		if (heights.length == 0 || heights[0].length == 0) {
			return new ArrayList<>();
		}
		List<List<Integer>> ans = new ArrayList<>();
		for (int i = 0; i < heights.length; i++) {
			for (int j = 0; j < heights[i].length; j++) {
				if (canFlowIntoPacificOcean(i, j, heights) && canFlowIntoAtlanticOcean(i, j, heights)) {
					List<Integer> temp = new ArrayList<>();
					temp.add(i);
					temp.add(j);
					ans.add(temp);
				}
			}
		}
		return ans;
	}

	private boolean canFlowIntoPacificOcean(int i, int j, int[][] heights) {
		Queue<int[]> qu = new LinkedList<>();
		qu.offer(new int[] { i, j });
		int m = heights.length;
		int n = heights[0].length;
		boolean[][] vis = new boolean[m][n];
		vis[i][j] = true;

		int[][] dirs = new int[][] { { -1, 0 }, { 0, -1 } };
		while (!qu.isEmpty()) {
			int[] cur = qu.poll();
			if (cur[0] == 0 || cur[1] == 0) {
				return true;
			}
			for (int[] dir : dirs) {
				int x = dir[0] + cur[0];
				int y = dir[1] + cur[1];
				if (x >= 0 && x < m && y >= 0 && y < n && vis[x][y] == false
						&& heights[x][y] <= heights[cur[0]][cur[1]]) {
					qu.offer(new int[] { x, y });
					vis[x][y] = true;
				}
			}
		}
		return false;
	}

	private boolean canFlowIntoAtlanticOcean(int i, int j, int[][] heights) {
		Queue<int[]> qu = new LinkedList<>();
		qu.offer(new int[] { i, j });
		int m = heights.length;
		int n = heights[0].length;
		boolean[][] vis = new boolean[m][n];
		vis[i][j] = true;

		int[][] dirs = new int[][] { { 1, 0 }, { 0, 1 } };
		while (!qu.isEmpty()) {
			int[] cur = qu.poll();
			if (cur[0] == m - 1 || cur[1] == n - 1) {
				return true;
			}
			for (int[] dir : dirs) {
				int x = dir[0] + cur[0];
				int y = dir[1] + cur[1];
				if (x >= 0 && x < m && y >= 0 && y < n && vis[x][y] == false
						&& heights[x][y] <= heights[cur[0]][cur[1]]) {
					qu.offer(new int[] { x, y });
					vis[x][y] = true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(
				new PacificAtlanticWaterFlow().pacificAtlantic(new int[][] { { 1, 2, 3 }, { 8, 9, 4 }, { 7, 6, 5 } }));

		System.out.println(new PacificAtlanticWaterFlow().pacificAtlantic(new int[][] { { 1, 2, 2, 3, 5 },
				{ 3, 2, 3, 4, 4 }, { 2, 4, 5, 3, 1 }, { 6, 7, 1, 4, 5 }, { 5, 1, 1, 2, 4 } }));
	}
	// [[0, 2], [1, 0], [1, 1], [1, 2], [2, 0], [2, 2]]

}
