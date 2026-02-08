package leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthNearestObstacleQueries {
	public int[] resultsArray(int[][] queries, int k) {
		Queue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
		int len = queries.length;
		int[] res = new int[len];
		for (int i = 0; i < len; i++) {
			pq.offer(Math.abs(queries[i][0]) + Math.abs(queries[i][1]));
			if (pq.size() > k) {
				pq.poll();
			}
			res[i] = pq.size() < k ? -1 : pq.peek();
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(new KthNearestObstacleQueries()
				.resultsArray(new int[][] { { 1, 2 }, { 3, 4 }, { 2, 3 }, { -3, 0 } }, 2));

		Queue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
		for (int i = 0; i < 10; i++) {
			pq.offer(i);
			if (pq.size() > 4)
				System.out.println(pq.poll());
		}
	}

}
