package stack;

import java.util.Stack;

public class EvaluateReversePolishNotation {

	public int evalRPN(String[] tokens) {
		Stack<Integer> stk = new Stack<>();

		for (String s : tokens) {
			if (s.length() == 1 && isOp(s) && stk.size() >= 2) {
				stk.push(calc(stk.pop(), stk.pop(), s));
			} else {
				stk.push(Integer.parseInt(s));
			}
		}
		return stk.pop();
	}

	private boolean isOp(String s) {
		if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"))
			return true;
		return false;
	}

	private int calc(int a, int b, String op) {
		switch (op) {
		case "+":
			return a + b;
		case "-":
			return b - a;
		case "*":
			return b * a;
		default:
			return b / a;
		}
	}

	public static void main(String[] args) {
		new EvaluateReversePolishNotation().evalRPN(new String[] { "4", "13", "5", "/", "+" });
		new EvaluateReversePolishNotation().evalRPN(new String[] { "2", "1", "+", "3", "*" });
	}

}
