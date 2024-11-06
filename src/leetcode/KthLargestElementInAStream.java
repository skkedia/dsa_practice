package leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

class KthLargest {

	Queue<Integer> pq = new PriorityQueue<>();
	int k;

	public KthLargest(int k, int[] nums) {
		this.k = k;
		for (Integer i : nums) {
			pq.add(i);
			if (pq.size() > k) {
				pq.poll();
			}
		}
	}

	public int add(int val) {
		pq.add(val);
		if (pq.size() > k) {
			pq.poll();
		}
		return pq.peek();
	}
}
