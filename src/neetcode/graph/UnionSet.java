package graph;

import java.util.Arrays;

class DSU {
	int[] rank;
	int[] parent;

	DSU(int n) {
		rank = new int[n];
		parent = new int[n];
		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
		}
	}

	public boolean union(int u, int v) {
		int u_parent = find(u);
		int v_parent = find(v);
		if (u_parent == v_parent) {
			return false;
		}
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

	public int find(int ele) {
		if (ele == parent[ele]) {
			return ele;
		}
		parent[ele] = find(parent[ele]);
		return parent[ele];
	}
}

public class UnionSet {

	public int maxNumEdgesToRemove(int n, int[][] edges) {

		Arrays.sort(edges, (a, b) -> Integer.compare(b[0], a[0]));

		DSU alice = new DSU(n + 1);
		DSU bob = new DSU(n + 1);
		int bob_edges = 0;
		int alice_edges = 0;
		int removed_edges = 0;
		for (int i = 0; i < edges.length; i++) {
			if (edges[i][0] == 3) {
				if (alice.union(edges[i][1], edges[i][2])) {
					bob.union(edges[i][1], edges[i][2]);
					bob_edges++;
					alice_edges++;
				} else {
					removed_edges++;
				}
			} else if (edges[i][0] == 2) {
				if (bob.union(edges[i][1], edges[i][2])) {
					bob_edges++;
				} else {
					removed_edges++;
				}
			} else {
				if (alice.union(edges[i][1], edges[i][2])) {
					alice_edges++;
				} else {
					removed_edges++;
				}
			}
		}

		return (bob_edges == n - 1 && alice_edges == n - 1) ? removed_edges : -1;
	}

	public static void main(String[] args) {
		new UnionSet().maxNumEdgesToRemove(4, new int[][] { { 3, 1, 2 }, { 3, 2, 3 }, { 1, 1, 4 }, { 2, 1, 4 } });

	}

}
