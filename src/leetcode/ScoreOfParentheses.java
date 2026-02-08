package leetcode;

import java.util.Stack;

public class ScoreOfParentheses {

	public int scoreOfParentheses(String s) {
		int ans = 0;
		Stack<Character> stk = new Stack<>();
		int pair = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stk.push(s.charAt(i));
				ans = ans + pair;
				pair = 0;
			} else {
				stk.pop();
				pair = pair + 1;
			}
		}
		ans = ans + pair;
		return ans;
	}

	public static void main(String[] args) {
		int ans = 3;
		System.out.println(1 << ans);
		for (int i = 0; i < 10; i++) {
			ans = 1 << i;
		}

		System.out.println(new ScoreOfParentheses().scoreOfParentheses("(()(()))"));
		System.out.println(new ScoreOfParentheses().scoreOfParentheses("(((())))()"));
		System.out.println(new ScoreOfParentheses().scoreOfParentheses("(())"));

	}

}
