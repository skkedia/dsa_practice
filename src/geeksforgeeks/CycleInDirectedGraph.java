package geeksforgeeks;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CycleInDirectedGraph {

	public boolean isCyclic(int v, ArrayList<ArrayList<Integer>> adj) {
		boolean[] vis = new boolean[v];
		boolean[] rec = new boolean[v];

		topologicalSort(v, adj);

		for (int i = 0; i < v; i++) {
			if (!vis[i] && dfs(i, vis, rec, adj)) {
				return true;
			}
		}
		return false;
	}

	private boolean topologicalSort(int v, ArrayList<ArrayList<Integer>> adj) {
		Queue<Integer> qu = new LinkedList<>();

		int[] indegree = new int[v];

		for (int i = 0; i < adj.size(); i++) {
			for (Integer u : adj.get(i)) {
				indegree[u]++;
			}
		}

		int count = 0;
		for (int i = 0; i < v; i++) {
			if (indegree[i] == 0) {
				qu.offer(i);
				count++;
			}
		}
		while (!qu.isEmpty()) {
			int k = qu.poll();
			for (int n : adj.get(k)) {
				indegree[n]--;
				if (indegree[n] == 0) {
					qu.offer(n);
					count++;
				}
			}
		}
		return !(count == v);
	}

	private boolean dfs(int i, boolean[] vis, boolean[] rec, ArrayList<ArrayList<Integer>> adj) {
		vis[i] = true;
		rec[i] = true;
		for (int j : adj.get(i)) {
			if (!vis[j] && dfs(j, vis, rec, adj)) {
				return true;
			} else if (rec[j]) {
				return true;
			}
		}
		rec[i] = false;
		return false;
	}

	public static void main(String[] args) {

	}

}
