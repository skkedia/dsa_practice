package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class RedundantConnectionII {

	public int[] findRedundantDirectedConnection(int[][] edges) {
		List<List<Integer>> adj = new ArrayList<>();
		for (int i = 0; i <= edges.length; i++) {
			adj.add(new ArrayList<>());
		}
		int[] in = new int[edges.length + 1];
		for (int[] edge : edges) {
			adj.get(edge[0]).add(edge[1]);
			// adj.get(edge[1]).add(edge[0]);
			in[edge[1]]++;
		}

		for (int i = edges.length - 1; i >= 0; i--) {
			adj.get(edges[i][0]).remove(Integer.valueOf(edges[i][1]));
			// adj.get(edges[i][1]).remove(Integer.valueOf(edges[i][0]));
			in[edges[i][1]]--;
			if (bfs(adj, in)) {
				return edges[i];
			}
			in[edges[i][1]]++;
			adj.get(edges[i][0]).add(Integer.valueOf(edges[i][1]));
			// adj.get(edges[i][1]).add(Integer.valueOf(edges[i][0]));
		}
		return new int[] { -1, -1 };
	}

	private boolean bfs(List<List<Integer>> adj, int[] in) {
		Queue<Integer> qu = new LinkedList<>();
		Set<Integer> hs = new HashSet<>();
		for (int i = 1; i < in.length; i++) {
			if (in[i] == 0) {
				qu.offer(i);
				hs.add(i);
			}
		}
		if (qu.size() != 1) {
			return false;
		}

		while (!qu.isEmpty()) {
			int k = qu.poll();
			for (Integer z : adj.get(k)) {
				if (!hs.contains(z)) {
					hs.add(z);
					qu.offer(z);
				}
			}

		}
		return adj.size() - 1 == hs.size();
	}

	public static void main(String[] args) {
		System.out.println(new RedundantConnectionII()
				.findRedundantDirectedConnection(new int[][] { { 2, 1 }, { 3, 1 }, { 4, 2 }, { 1, 4 } }));

	}

}
