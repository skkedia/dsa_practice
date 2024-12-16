package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NumberOfProvinces {

	private int count = 0;

	public int findCircleNum(int[][] isConnected) {
		boolean[] visited = new boolean[isConnected.length];
		count = 0;
		for (int i = 0; i < isConnected.length; i++) {
			for (int j = 0; j < isConnected[i].length; j++) {
				if (isConnected[i][j] == 1 && !visited[i]) {
					count++;
					bfs(isConnected, visited, i);
					dfs(isConnected, visited, i);
				}
			}
		}
		return count;
	}

	private void dfs(int[][] isConnected, boolean[] visited, int i) {
		if (visited[i])
			return;
		visited[i] = true;
		for (int k = 0; k < isConnected[i].length; k++) {
			if (!visited[k] && isConnected[i][k] == 1) {
				dfs(isConnected, visited, k);
			}
		}
		// visited[i] = true;
	}

	private void bfs(int[][] isConnected, boolean[] visited, int i) {
		Queue<Integer> qu = new LinkedList<>();
		qu.offer(i);
		visited[i] = true;
		while (!qu.isEmpty()) {
			int u = qu.poll();
			for (int k = 0; k < isConnected[u].length; k++) {
				if (!visited[k] && isConnected[u][k] == 1) {
					visited[k] = true;
					qu.offer(k);
				}
			}
		}
	}

	public static void main(String[] args) {
		List<List<String>> accounts = new ArrayList<>();
		Collections.sort(accounts, (a, b) -> a.get(0).compareTo(b.get(0)));
	}

}
