package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class IsgraphBiPartite {

	public boolean isBipartite(int[][] graph) {
		int[] color = new int[graph.length];
		Arrays.fill(color, -1);

		// BFS
		for (int i = 0; i < graph.length; i++) {
			if (color[i] == -1 && !bfs(i, graph, color)) {
				return false;
			}
		}

		// DFS

		for (int i = 0; i < graph.length; i++) {
			if (color[i] == -1) {
				Stack<Integer> stk = new Stack<>();
				stk.push(i);
				color[i] = 0;
				while (!stk.isEmpty()) {
					int z = stk.pop();
					for (int n : graph[z]) {
						if (color[n] == -1) {
							stk.push(n);
							color[n] = 1 - color[z];
						} else if (color[n] == color[z]) {
							return false;
						}
					}
				}
			}
		}

		return true;
	}

	private boolean bfs(int node, int[][] graph, int[] color) {
		Queue<Integer> qu = new LinkedList<>();
		color[node] = 0;
		qu.offer(node);
		while (!qu.isEmpty()) {
			int n = qu.poll();
			for (int i = 0; i < graph[n].length; i++) {
				if (color[graph[n][i]] == -1) {
					color[graph[n][i]] = 1 - color[n];
					qu.add(graph[n][i]);
				} else {
					if (color[graph[n][i]] == color[n]) {
						return false;
					}
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {

	}

}
