package stack;

import java.util.Stack;

public class MinStack {

	private class Node {
		private Integer val;
		private Integer min;

		private Node(Integer val, Integer min) {
			this.val = val;
			this.min = min;
		}
	}

	private Stack<Node> stk;

	public MinStack() {
		stk = new Stack<>();
	}

	public void push(int val) {
		Node n;
		if (stk.isEmpty()) {
			n = new Node(val, val);
			stk.add(n);
		} else {
			stk.add(new Node(val, stk.peek().min > val ? val : stk.peek().min));
		}
	}

	public void pop() {
		stk.pop();
	}

	public int top() {
		return stk.peek().val;
	}

	public int getMin() {
		return stk.peek().min;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
