package graph;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

class DisJointSet {

	int[] parent;
	int[] rank;

	DisJointSet(int n) {
		parent = new int[n];
		rank = new int[n];
		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
		}
	}

	public int find(int ele) {
		if (parent[ele] == ele) {
			return ele;
		}
		parent[ele] = find(parent[ele]);
		return parent[ele];
	}

	public boolean union(int u, int v) {

		int u_parent = find(u);
		int v_parent = find(v);

		if (u_parent == v_parent)
			return false;

		if (rank[u_parent] > rank[v_parent]) {
			parent[v_parent] = u_parent;
		} else if (rank[u_parent] < rank[v_parent]) {
			parent[u_parent] = v_parent;
		} else {
			parent[u_parent] = v_parent;
			rank[u_parent]++;
		}
		return true;
	}

}

public class FindCycleInAGraph {
	class iPair {
		int first, second;

		iPair(int first, int second) {
			this.first = first;
			this.second = second;
		}
	}

	public int detectCycle(int V, ArrayList<ArrayList<Integer>> adj) {
		DisJointSet dis = new DisJointSet(V);
		for (int i = 0; i < adj.size(); i++) {
			for (Integer j : adj.get(i)) {
				if (i < j) {
					if (dis.find(i) == dis.find(j)) {
						return 1;
					}
					dis.union(i, j);
				}
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		int src = 0;
		ArrayList<ArrayList<iPair>> adj = new ArrayList<>();

		ArrayList<Integer> ans = new ArrayList<>();

		for (int i = 0; i < adj.size(); i++) {
			ans.add(Integer.MAX_VALUE);
		}

		Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
		pq.add(new int[] { 0, src });
		ans.set(src, 0);
		while (!pq.isEmpty()) {
			int[] curEle = pq.poll();
			int dis = curEle[0];
			int node = curEle[1];

			for (iPair temp : adj.get(node)) {
				int adjNode = temp.first;
				int adjWeight = temp.second;

				if (dis + adjWeight < ans.get(adjNode)) {
					ans.set(adjNode, dis + adjWeight);
					pq.offer(new int[] { ans.get(adjNode), adjNode });
				}
			}
		}

	}

}
