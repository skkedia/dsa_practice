package geeksforgeeks;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CycleInUnDirectedGraph {

	public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
		boolean[] vis = new boolean[adj.size()];

		for (int i = 0; i < adj.size(); i++) {
			if (!vis[i] && bfs(i, vis, adj)) {
				return true;
			}
		}

		for (int i = 0; i < adj.size(); i++) {
			if (!vis[i] && dfs(i, vis, adj, -1)) {
				return true;
			}
		}
		return false;

	}

	private boolean bfs(int i, boolean[] vis, ArrayList<ArrayList<Integer>> adj) {
		Queue<Pair> qu = new LinkedList<>();
		qu.add(new Pair(i, -1));
		vis[i] = true;
		while (!qu.isEmpty()) {
			Pair poll = qu.poll();
			int x = poll.x;
			int y = poll.y;

			for (int k : adj.get(x)) {
				if (!vis[k]) {
					vis[k] = true;
					qu.add(new Pair(k, x));
				} else if (y != k) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean dfs(int i, boolean[] vis, ArrayList<ArrayList<Integer>> adj, int j) {
		vis[i] = true;

		for (int a : adj.get(i)) {
			if (!vis[a] && dfs(a, vis, adj, i)) {
				return true;
			} else if (j != a) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {

	}

}
