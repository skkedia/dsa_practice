package leetcode;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class MaximumScoreAfterApplyingKOperations {

	public long maxKelements(int[] nums, int k) {
		long ans = 0l;

		Queue<Double> pq = new PriorityQueue<>(Collections.reverseOrder());
		for (int i : nums) {
			pq.offer((double) i);
		}
		while (k > 0) {
			ans += pq.peek();
			pq.offer((double) Math.ceil(pq.poll() / 3));
			k--;
		}
		return ans;
	}

	public static void main(String[] args) {
		// System.out.println(new
		// MaximumScoreAfterApplyingKOperations().maxKelements(new int[] { 10, 10, 10,
		// 10, 10 }, 5));
		System.out.println(new MaximumScoreAfterApplyingKOperations().maxKelements(new int[] { 1, 10, 3, 3, 3 }, 3));

	}

}
