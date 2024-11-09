package leetcode;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinimumNumberOfRefuelingStops {

	public int minRefuelStops(int target, int startFuel, int[][] stations) {
		int ans = 0;
		Queue<Integer> qu = new PriorityQueue<>(Collections.reverseOrder());
		int prevloc = 0;

		for (int[] station : stations) {
			int loc = station[0];
			int fuel = station[1];
			startFuel = startFuel - (loc - prevloc);
			while (!qu.isEmpty() && startFuel < 0) {
				startFuel = startFuel + qu.poll();
				ans++;
			}
			if (startFuel < 0) {
				return -1;
			}
			qu.add(fuel);
			prevloc = loc;
		}
		startFuel = startFuel - (target - prevloc);
		while (!qu.isEmpty() && startFuel < 0) {
			startFuel = startFuel + qu.poll();
			ans++;
		}
		if (startFuel < 0) {
			return -1;
		}

		return ans;
	}

	public static void main(String[] args) {
		System.out.println(new MinimumNumberOfRefuelingStops().minRefuelStops(100, 10,
				new int[][] { { 10, 60 }, { 20, 30 }, { 30, 30 }, { 60, 40 } }));
	}

}
