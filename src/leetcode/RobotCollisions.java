package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class RobotCollisions {

	public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
		int n = positions.length;
		Integer[] indexes = new Integer[n];
		Stack<Integer> stk = new Stack<>();
		for (int i = 0; i < n; i++) {
			indexes[i] = i;
		}
		Arrays.sort(indexes, (l, r) -> Integer.compare(positions[l], positions[r]));

		for (Integer index : indexes) {
			if (directions.charAt(index) == 'R') {
				stk.push(index);
			} else {
				while (!stk.empty() && healths[index] > 0) {
					Integer topIndex = stk.pop();
					if (healths[topIndex] > healths[index]) {
						healths[topIndex] -= 1;
						healths[index] = 0;
						stk.push(topIndex);
					} else if (healths[topIndex] < healths[index]) {
						healths[index] -= 1;
						healths[topIndex] = 0;
					} else {
						healths[index] = 0;
						healths[topIndex] = 0;
					}
				}
			}
		}
		List<Integer> ans = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if (healths[i] > 0)
				ans.add(healths[i]);
		}

		return ans;

	}

	public static void main(String[] args) {
		new RobotCollisions().survivedRobotsHealths(new int[] { 3, 5, 2, 6 }, new int[] { 10, 10, 15, 12 }, "RLRL");
		new RobotCollisions().survivedRobotsHealths(new int[] { 12, 33, 37 }, new int[] { 49, 5, 38 }, "RLL");

	}

}
