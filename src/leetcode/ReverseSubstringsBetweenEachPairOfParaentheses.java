package leetcode;

import java.util.Stack;

public class ReverseSubstringsBetweenEachPairOfParaentheses {

	public String reverseParentheses(String s) {
		Stack<String> stk = new Stack<>();
		int i = 0;
		while (i < s.length()) {
			if (s.charAt(i) == '(') {
				i++;
				continue;
			}
			if (s.charAt(i) == ')') {
				String j = new StringBuilder(stk.pop()).reverse().toString();
				if (stk.size() > 0)
					j += stk.pop();
				stk.push(j);
				i++;
				continue;
			}
			String g = "";
			while (s.charAt(i) != '(' && s.charAt(i) != ')') {
				g += s.charAt(i);
				i++;
			}
			stk.push(g);
		}

		return stk.pop();
	}

	public static void main(String[] args) {
		System.out.println(new ReverseSubstringsBetweenEachPairOfParaentheses().reverseParentheses("(u(love)i)"));
	}

}
