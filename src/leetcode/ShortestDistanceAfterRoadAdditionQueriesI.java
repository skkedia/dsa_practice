package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestDistanceAfterRoadAdditionQueriesI {

	public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
		int[] ans = new int[queries.length];
		List<List<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			adj.add(new ArrayList<>());
		}

		for (int i = 0; i < n - 1; i++) {
			adj.get(i).add(i + 1);
		}
		Arrays.fill(ans, 1);
		int idx = 0;
		for (int[] query : queries) {
			int u = query[0];
			int v = query[1];
			adj.get(u).add(v);
			int x = bfs(n, adj);
			if (x == 1)
				break;
			ans[idx++] = x;
		}
		return ans;
	}

	private int bfs(int n, List<List<Integer>> adj) {
		Queue<Integer> qu = new LinkedList<>();
		boolean[] vis = new boolean[n];
		qu.add(0);
		vis[0] = true;
		int exp = 0;
		while (!qu.isEmpty()) {
			int siz = qu.size();
			for (int i = 0; i < siz; i++) {

				int nod = qu.poll();

				if (nod == n - 1) {
					return exp;
				}

				for (int nei : adj.get(nod)) {
					if (vis[nei]) {
						continue;
					}
					qu.add(nei);
					vis[nei] = true;
				}
			}
			exp++;
		}
		return -100;
	}

	public static void main(String[] args) {
		System.out.println(new ShortestDistanceAfterRoadAdditionQueriesI().shortestDistanceAfterQueries(5,
				new int[][] { { 2, 4 }, { 0, 2 }, { 0, 4 } }));

	}

}
