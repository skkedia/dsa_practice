package graph;

import java.util.ArrayList;

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

	}

}
