package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MaximumNumberOfWeeksForWhichYouCanWork {

	public long numberOfWeeks(int[] milestones) {
		if (milestones.length == 1) {
			return 1;
		}
		Queue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
		for (Integer mileStone : milestones) {
			pq.offer(mileStone);
		}
		long totalWeeks = 0l;
		while (!pq.isEmpty()) {
			long cycle = 2l;
			List<Integer> store = new ArrayList<>();
			long cnt = 0l;
			while (cycle > 0 && !pq.isEmpty()) {
				int cur = pq.poll();
				if (cur > 1) {
					store.add(cur - 1);
				}
				cnt++;
				cycle--;
			}
			if (pq.isEmpty()) {
				return totalWeeks + cnt + 1;
			}
			for (Integer cur : store) {
				pq.offer(cur);
			}
			totalWeeks += 2l;
		}
		return totalWeeks;
	}

	public static void main(String[] args) {
		System.out.println(new MaximumNumberOfWeeksForWhichYouCanWork().numberOfWeeks(new int[] { 10 }));
		System.out.println(new MaximumNumberOfWeeksForWhichYouCanWork().numberOfWeeks(new int[] { 5, 2, 1 }));
	}

}
