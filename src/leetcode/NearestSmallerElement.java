package leetcode;

import java.util.Arrays;
import java.util.Stack;

public class NearestSmallerElement {

	public int[] prevSmaller(int[] a) {
		if (a == null || a.length == 0) {
			return new int[0];
		}
		Stack<Integer> stk = new Stack<>();

		int[] ans = new int[a.length];

		for (int i = 0; i < a.length; i++) {
			while (!stk.isEmpty() && a[i] <= stk.peek()) {
				stk.pop();
			}
			if (!stk.isEmpty()) {
				ans[i] = stk.peek();
			} else {
				ans[i] = -1;
			}
			stk.push(a[i]);
		}
		return ans;
	}

	public static void main(String[] args) {
		System.out.println(Arrays
				.toString(new NearestSmallerElement().prevSmaller(new int[] { 34, 35, 27, 42, 5, 28, 39, 20, 28 })));

	}

}
