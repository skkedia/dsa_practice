package leetcode;

import java.util.Arrays;

public class MeetingRoomsI {

	public boolean canAttendMeetings(int[][] intervals) {
		Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

		int end = intervals[0][1];

		for (int i = 1; i < intervals.length; i++) {
			if (end > intervals[i][0]) {
				return false;
			}
			end = intervals[i][1];
		}
		return true;
	}

	public static void main(String[] args) {
		new MeetingRoomsI().canAttendMeetings(new int[][] { { 1 }, { 2 } });
	}

}
