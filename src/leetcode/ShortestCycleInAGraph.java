package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class ShortestCycleInAGraph {

	class Node {
		int node;
		int parent;

		public Node(int node, int parent) {
			this.node = node;
			this.parent = parent;
		}
	}

	private int bfs(int node, ArrayList<ArrayList<Integer>> graph, int n) {
		int[] distance = new int[n];
		Arrays.fill(distance, -1);
		Queue<Node> queue = new LinkedList<>();
		distance[node] = 0;
		queue.add(new Node(node, -1));

		int minCycleLength = Integer.MAX_VALUE;

		while (!queue.isEmpty()) {
			Node current = queue.poll();

			for (int neighbor : graph.get(current.node)) {
				if (distance[neighbor] == -1) {
					distance[neighbor] = distance[current.node] + 1;
					queue.add(new Node(neighbor, current.node));
				} else if (neighbor != current.parent) {
					minCycleLength = Math.min(minCycleLength, distance[neighbor] + distance[current.node] + 1);
				}
			}
		}
		return minCycleLength;
	}

	public int findShortestCycle(int n, int[][] edges) {

		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
		}

		for (int[] edge : edges) {
			int u = edge[0];
			int v = edge[1];
			graph.get(u).add(v);
			graph.get(v).add(u);
		}

		int minDistance = Integer.MAX_VALUE;

		for (int i = 0; i < n; i++) {
			minDistance = Math.min(minDistance, bfs(i, graph, n));
		}

		return (minDistance == Integer.MAX_VALUE) ? -1 : minDistance;
	}

	public static void main(String[] args) {
		Queue<Integer> qu = new PriorityQueue<>((a, b) -> a - b);

		for (int i = 0; i < 10; i++) {
			qu.offer(i);
		}

		while (!qu.isEmpty()) {
			System.out.println(qu.poll());
		}

	}

	static int dist(int[] a, int[] b) {
		long x = (a[0] - 0) * (a[0] - 0);
		long y = (a[1] - 0) * (a[1] - 0);
		long d = x + y;
		long x1 = (b[0] - 0) * (b[0] - 0);
		long y1 = (b[1] - 0) * (b[1] - 0);
		long d1 = x1 + y1;

		return Long.compare(d, d1);

	}

}
