package leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementInTheArray {

	public int findKthLargest(int[] nums, int k) {
		Queue<Integer> pq = new PriorityQueue<>();
		for (Integer i : nums) {
			pq.add(i);
			if (pq.size() > k) {
				pq.poll();
			}
		}
		return pq.peek();
	}

}
