package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class MaxStack {

	Queue<Integer> qu;
	Stack<Integer> stk;
	Map<Integer, Integer> hm;
	Map<Integer, Integer> mh;

	public MaxStack() {
		qu = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
		stk = new Stack<>();
		hm = new HashMap<>();
		mh = new HashMap<>();
	}

	public void push(int x) {
		qu.offer(x);
		stk.push(x);
	}

	public int pop() {
		while (hm.containsKey(stk.peek()) && hm.get(stk.peek()) > 0) {
			hm.put(stk.peek(), hm.getOrDefault(stk.peek(), 0) - 1);
			stk.pop();
		}
		int x = stk.pop();
		mh.put(x, mh.getOrDefault(x, 0) + 1);
		return x;
	}

	public int top() {
		while (hm.containsKey(stk.peek()) && hm.get(stk.peek()) > 0) {
			hm.put(stk.peek(), hm.getOrDefault(stk.peek(), 0) - 1);
			stk.pop();
		}
		return stk.peek();
	}

	public int peekMax() {
		while (mh.containsKey(qu.peek()) && mh.get(qu.peek()) > 0) {
			mh.put(qu.peek(), mh.getOrDefault(qu.peek(), 0) - 1);
			qu.poll();
		}
		return qu.peek();
	}

	public int popMax() {
		while (mh.containsKey(qu.peek()) && mh.get(qu.peek()) > 0) {
			mh.put(qu.peek(), mh.getOrDefault(qu.peek(), 0) - 1);
			qu.poll();
		}
		int x = qu.poll();
		hm.put(x, hm.getOrDefault(x, 0) + 1);
		return x;
	}

	public static void main(String[] args) {
		String[] operations = { "MaxStack", "push", "top", "popMax", "push", "pop", "push", "peekMax", "push", "pop",
				"push", "pop", "pop", "push", "top", "popMax", "push", "push", "pop", "push", "push" };
		Object[][] argsList = { {}, { 69 }, {}, {}, { -92 }, {}, { -83 }, {}, { -26 }, {}, { 69 }, {}, {}, { 92 }, {},
				{}, { 74 }, { -37 }, {}, { -86 }, { 29 } };

		MaxStack maxStack = null;

		for (int i = 0; i < operations.length; i++) {
			String op = operations[i];
			Object[] opArgs = argsList[i];

			switch (op) {
			case "MaxStack":
				maxStack = new MaxStack();
				System.out.println("MaxStack created");
				break;
			case "push":
				int valPush = (int) opArgs[0];
				maxStack.push(valPush);
				System.out.println("push(" + valPush + ")");
				break;
			case "pop":
				int popped = maxStack.pop();
				System.out.println("pop(): " + popped);
				break;
			case "top":
				int top = maxStack.top();
				System.out.println("top(): " + top);
				break;
			case "peekMax":
				int peekMax = maxStack.peekMax();
				System.out.println("peekMax(): " + peekMax);
				break;
			case "popMax":
				int popMaxVal = maxStack.popMax();
				System.out.println("popMax(): " + popMaxVal);
				break;
			default:
				System.out.println("Unknown operation: " + op);
			}
		}
	}

}
