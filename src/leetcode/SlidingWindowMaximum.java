package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class SlidingWindowMaximum {
	public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums == null || nums.length == 0 || k == 0) {
			return nums;
		}
		int left = 0;
		int right = Math.min(k, nums.length);
		List<Integer> al = new ArrayList<>();
		Queue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
		Map<Integer, Integer> mp = new HashMap<>();
		for (int i = 0; i < right; i++) {
			pq.add(nums[i]);
			mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);
		}
		al.add(pq.peek());
		while (right < nums.length) {
			int out = nums[left];
			int in = nums[right];
			pq.add(in);
			mp.put(out, mp.get(out) - 1);
			mp.put(in, mp.getOrDefault(in, 0) + 1);
			while (!pq.isEmpty() && mp.get(pq.peek()) == 0) {
				pq.remove();
			}
			al.add(pq.peek());
			left++;
			right++;

		}
		return al.stream().mapToInt(Integer::intValue).toArray();
	}
}
