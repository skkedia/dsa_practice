package slidingwindow;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {

	public int[] maxSlidingWindow(int[] nums, int k) {
		Deque<Integer> q = new LinkedList<>();
		int left = 0;
		int right = 0;
		while (right < nums.length) {
			while (!q.isEmpty() && nums[q.peekLast()] < nums[right]) {
				q.pollLast();
			}
			q.offer(right);

			if (left > q.peek()) {
				q.poll();
			}
			if ((right + 1) >= k) {
				nums[left] = nums[q.peek()];
				left += 1;
			}
			right += 1;
		}

		return Arrays.copyOfRange(nums, 0, nums.length - k + 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
