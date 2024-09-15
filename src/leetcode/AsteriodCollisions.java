package leetcode;

import java.util.Stack;

public class AsteriodCollisions {

	public int[] asteroidCollision(int[] asteriods) {
		Stack<Integer> stk = new Stack<>();
		for (Integer asteriod : asteriods) {
			if (asteriod > 0) {
				stk.push(asteriod);
			} else {
				while (!stk.empty() && stk.peek() > 0 && stk.peek() < -asteriod) {
					stk.pop();
				}
				if (stk.isEmpty() || stk.peek() < 0)
					stk.push(asteriod);
				if (stk.peek() == -asteriod)
					stk.pop();
			}
		}
		int[] ans = new int[stk.size()];
		int i = stk.size() - 1;
		while (!stk.empty()) {
			ans[i--] = stk.pop();
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
