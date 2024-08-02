package leetcode;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FindRelativeRanks {

	public String[] findRelativeRanks(int[] score) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		Map<Integer, Integer> hm = new HashMap<>();
		for (int i = 0; i < score.length; i++) {
			pq.add(score[i]);
			hm.put(score[i], i);
		}
		String[] ans = new String[score.length];
		int i = 0;
		while (!pq.isEmpty()) {
			int x = pq.poll();
			int y = hm.get(x);
			if (i == 0) {
				ans[y] = "Gold Medal";
			} else if (i == 1) {
				ans[y] = "Silver Medal";
			} else if (i == 2) {
				ans[y] = "Bronze Medal";
			} else {
				ans[y] = "" + (i + 1);
			}
			i++;
		}
		return ans;
	}

	public static void main(String[] args) {
		new FindRelativeRanks().findRelativeRanks(new int[] { 10, 3, 8, 9, 4 });
	}

}
