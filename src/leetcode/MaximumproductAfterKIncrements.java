package leetcode;

import java.util.PriorityQueue;

public class MaximumproductAfterKIncrements {

	public int maximumProduct(int[] nums, int k) {
		PriorityQueue<Integer> sorted = new PriorityQueue<>();
		for (int i : nums) {
			sorted.add(i);
		}

		while (k > 0) {
			sorted.add(1 + sorted.poll());
			k--;
		}
		long product = 1;
		while (!sorted.isEmpty() && product > 0) {
			product = (product * sorted.poll()) % 1_000_000_007;
		}
		return (int) product;
	}

	public static void main(String[] args) {
	}

}
