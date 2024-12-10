package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BombEnemy {

	public int maxKilledEnemies(char[][] grid) {
		Queue<int[]> qu = new LinkedList<>();

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 'E') {
					qu.add(new int[] { i, j });
				}
			}
		}
		int max = 0;
		while (!qu.isEmpty()) {
			int[] co = qu.poll();
			int cur = 0;
			for (int i = co[0]; i < grid.length; i++) {
				if (grid[i][co[1]] == 'E') {
					cur++;
				} else if (grid[i][co[1]] == 'W') {
					break;
				}
			}

			for (int i = co[0]; i >= 0; i--) {
				if (grid[i][co[1]] == 'E') {
					cur++;
				} else if (grid[i][co[1]] == 'W') {
					break;
				}
			}

			for (int i = co[1]; i < grid[0].length; i++) {
				if (grid[co[0]][i] == 'E') {
					cur++;
				} else if (grid[co[0]][i] == 'W') {
					break;
				}
			}

			for (int i = co[1]; i >= 0; i--) {
				if (grid[co[0]][i] == 'E') {
					cur++;
				} else if (grid[co[0]][i] == 'W') {
					break;
				}
			}

			max = Math.max(max, cur);
		}
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int countCompleteComponents(int n, int[][] edges) {

		List<List<Integer>> adjList = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			adjList.add(new ArrayList<>());
		}

		for (int[] edge : edges) {
			adjList.get(edge[0]).add(edge[1]);
			adjList.get(edge[1]).add(edge[0]);
		}

		boolean[] visited = new boolean[n];
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				count++;
				bfs(adjList, i, visited);
			}
		}
		return count;
	}

	private void bfs(List<List<Integer>> adj, int i, boolean[] visited) {
		visited[i] = true;
		for (int node : adj.get(i)) {
			visited[node] = true;
		}
	}

}
