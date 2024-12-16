package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MeetingsRoomsII {

	public int minMeetingRooms(int[][] intervals) {
		Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
		Queue<Integer> pq = new PriorityQueue<>();
		pq.offer(intervals[0][1]);

		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i][0] >= pq.peek()) {
				pq.poll();
			}
			pq.offer(intervals[i][1]);
		}
		return pq.size();
	}

	public static void main(String[] args) {

	}

}
