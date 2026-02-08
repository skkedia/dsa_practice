package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class KSizedSubArrayMaximum {
	public ArrayList<Integer> maxOfSubarrays(int[] arr, int k) {
		// code here
		ArrayList<Integer> al = new ArrayList<>();

		int left = 0;
		int right = Math.min(arr.length, k);
		int n = arr.length;
		Queue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
		Map<Integer, Integer> hm = new HashMap<>();
		for (int i = 0; i < right; i++) {
			pq.offer(arr[i]);
			hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
		}
		al.add(pq.peek());
		while (right < n) {
			int add = arr[right];
			int rem = arr[left];
			pq.offer(arr[right]);
			hm.put(add, hm.getOrDefault(add, 0) + 1);
			hm.put(rem, hm.get(rem) - 1);
			while (!pq.isEmpty() && hm.get(pq.peek()) == 0) {
				pq.poll();
			}
			al.add(pq.peek());
			left++;
			right++;
		}
		return al;
	}

	public static void main(String[] args) {
		System.out.println(new KSizedSubArrayMaximum().maxOfSubarrays(new int[] { 1, 2, 3, 1, 4, 5, 2, 3, 6 }, 3));

	}

}
