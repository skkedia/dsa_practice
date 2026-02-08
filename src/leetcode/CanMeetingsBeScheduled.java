package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class CanMeetingsBeScheduled {

	// Given n meeting rooms and timestamps, find out whether all meetings could
	// occur or not

	private boolean canMeetingBeScheduled(int noOfMeetingRooms, int[][] timeStamps) {
		Arrays.sort(timeStamps, (a, b) -> a[0] - b[0]);

		Queue<int[]> meetings = new PriorityQueue<>((a, b) -> b[1] - a[1]);

		for (int i = 0; i < timeStamps.length; i++) {
			if (meetings.isEmpty() || meetings.peek()[1] > timeStamps[i][0]) {
				meetings.offer(timeStamps[i]);
			} else {
				while (!meetings.isEmpty() && meetings.peek()[1] <= timeStamps[i][0]) {
					meetings.poll();
				}
				meetings.offer(timeStamps[i]);
			}
			if (meetings.size() > noOfMeetingRooms) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int[][] timeStamps = new int[][] { { 1, 2 }, { 1, 2 }, { 3, 4 }, { 2, 3 } };
		int noOfMeetingRooms = 2;

		System.out.println(new CanMeetingsBeScheduled().canMeetingBeScheduled(noOfMeetingRooms, timeStamps));

	}

}
