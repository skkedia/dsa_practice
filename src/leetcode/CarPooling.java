package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class CarPooling {

	public boolean carPooling(int[][] trips, int capacity) {
		Arrays.sort(trips, (a, b) -> a[1] - b[1]);
		Queue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
		pq.offer(new int[] { trips[0][2], 0 });
		int cur = trips[0][0];
		if (cur > capacity)
			return false;
		for (int i = 1; i < trips.length; i++) {
			while (!pq.isEmpty() && pq.peek()[0] <= trips[i][1]) {
				int[] k = pq.poll();
				cur = cur - trips[k[1]][0];
			}
			if (cur + trips[i][0] <= capacity) {
				pq.offer(new int[] { trips[i][2], i });
				cur = cur + trips[i][0];
			} else {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(new CarPooling().carPooling(new int[][] { { 3, 2, 8 }, { 4, 4, 6 }, { 10, 8, 9 } }, 11));
		System.out.println(new CarPooling().carPooling(new int[][] { { 5, 7, 8 }, { 10, 2, 3 }, { 8, 3, 9 },
				{ 3, 2, 5 }, { 7, 4, 9 }, { 4, 7, 8 }, { 3, 7, 9 }, { 3, 3, 9 } }, 29));
		System.out.println(new CarPooling().carPooling(new int[][] { { 2, 1, 5 }, { 3, 5, 7 } }, 3));
		// System.out.println(new CarPooling().carPooling(new int[][] { { 2, 1, 5 }, {
		// 3, 5, 7 } }, 3));
		System.out.println(new CarPooling()
				.carPooling(new int[][] { { 8, 2, 3 }, { 4, 1, 3 }, { 1, 3, 6 }, { 8, 4, 6 }, { 4, 4, 8 } }, 12));
	}

}
