package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class CountTheNumberOfCompleteComponents {

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
			if (!visited[i] && bfs(adjList, i, visited)) {
				count++;
			}
		}
		return count - 1;
	}

	private boolean bfs(List<List<Integer>> adj, int i, boolean[] visited) {
		Set<Integer> hs = new HashSet<>();
		Queue<Integer> qu = new LinkedList<>();
		qu.add(i);
		hs.add(i);
		while (!qu.isEmpty()) {
			int k = qu.poll();
			visited[k] = true;
			for (int j : adj.get(k)) {
				if (!visited[j]) {
					hs.add(j);
					qu.add(j);
				}
			}
		}

		for (Integer n : hs) {
			if (hs.size() - 1 != adj.get(n).size()) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(new CountTheNumberOfCompleteComponents().countCompleteComponents(4,
				new int[][] { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } }));
		System.out.println(new CountTheNumberOfCompleteComponents().countCompleteComponents(6,
				new int[][] { { 0, 1 }, { 0, 2 }, { 1, 2 }, { 3, 4 } }));

	}

}
