package geeksforgeeks;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class TopologicalSorting {
	public static void main(String[] args) {
		System.out.println(new TopologicalSortingUsingDFS().topologicalSort(null));
	}
}

class TopologicalSortingUsingDFS {

	protected List<Integer> topologicalSort(List<List<Integer>> adj) {
		List<Integer> ans = new ArrayList<>();
		boolean[] visited = new boolean[adj.size()];

		Stack<Integer> stk = new Stack<>();

		for (int i = 0; i < adj.size(); i++) {
			topoLogicalSortUsingDFS(adj, visited, stk, i);
		}

		while (!stk.isEmpty()) {
			ans.add(stk.pop());
		}

		return ans;
	}

	private void topoLogicalSortUsingDFS(List<List<Integer>> adj, boolean[] visited, Stack<Integer> stk, int source) {
		visited[source] = true;

		for (Integer v : adj.get(source)) {
			if (!visited[v]) {
				topoLogicalSortUsingDFS(adj, visited, stk, v);
			}
		}

		stk.push(source);
	}
}

// Kahn's algorithm
class TopolocialSortingUsingBFS {

	/**
	 * 
	 * 1) create a in-degree array
	 * 
	 * 2) if the in-degree of a node is 0 then its a starting point, push it into a
	 * queue
	 * 
	 * 3) iterate over the queue and visit all node from it and decrease the
	 * in-degree for those nodes
	 * 
	 * @param adj
	 * @return
	 */

	protected List<Integer> topologicalSort(List<List<Integer>> adj) {
		List<Integer> ans = new ArrayList<>();

		Queue<Integer> qu = new LinkedList<>();
		int[] indegree = new int[adj.size()];

		for (int i = 0; i < adj.size(); i++) {
			for (int j : adj.get(i)) {
				indegree[j]++;
			}
		}

		for (int i = 0; i < adj.size(); i++) {
			if (indegree[i] == 0) {
				qu.offer(i);
			}
		}

		while (!qu.isEmpty()) {
			int v = qu.poll();
			ans.add(v);
			for (Integer u : adj.get(v)) {
				indegree[u]--;
				if (indegree[u] == 0) {
					qu.offer(u);
				}
			}
		}
		return ans;
	}

}
