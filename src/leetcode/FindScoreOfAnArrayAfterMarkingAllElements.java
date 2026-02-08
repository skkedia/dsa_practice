package leetcode;

import java.util.PriorityQueue;

public class FindScoreOfAnArrayAfterMarkingAllElements {

	public long findScore(int[] nums) {
		long ans = 0l;
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
			if (a[0] != b[0]) {
				return a[0] - b[0];
			} else {
				return a[1] - b[1];
			}
		});
		for (int i = 0; i < nums.length; i++) {
			pq.offer(new int[] { nums[i], i });
		}
		boolean[] marked = new boolean[nums.length];
		while (!pq.isEmpty()) {
			int[] k = pq.poll();
			if (marked[k[1]]) {
				continue;
			}
			ans += k[0];
			if (k[1] - 1 >= 0) {
				marked[k[1] - 1] = true;
			}
			if (k[1] + 1 < nums.length)
				marked[k[1] + 1] = true;
		}
		return ans;
	}

	public static void main(String[] args) {

		System.out.println(new FindScoreOfAnArrayAfterMarkingAllElements().findScore(new int[] { 8, 7, 10 }));
	}

}
