package leetcode;

import java.util.Stack;

public class FinalPricesWithASpecialDiscountInAShop {

	public int[] finalPrices(int[] prices) {
		int[] ans = new int[prices.length];
		for (int i = 0; i < prices.length; i++) {
			ans[i] = prices[i];
		}
		Stack<Integer> stk = new Stack<>();
		for (int i = 0; i < prices.length; i++) {
			while (!stk.isEmpty() && prices[stk.peek()] >= prices[i]) {
				ans[stk.pop()] -= prices[i];
			}
			stk.add(i);
		}
		return ans;
	}

	public static void main(String[] args) {
		System.out.println(new FinalPricesWithASpecialDiscountInAShop().finalPrices(new int[] { 5, 4, 3, 2, 1 }));
	}

}
