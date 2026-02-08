package leetcode;

import java.util.Arrays;
import java.util.Stack;

public class DesignACircularQueue {

	class MyCircularQueue {

		int[] qu;
		int front = 0;
		int back = 0;

		public MyCircularQueue(int k) {
			qu = new int[k];
			Arrays.fill(qu, -1);
			front = -1;
			back = 0;
		}

		public boolean enQueue(int value) {
			int idx = (back) % qu.length;
			if (idx == front)
				return false;
			if (qu[idx] == -1) {
				qu[idx] = value;
				back++;
			}
			return true;
		}

		public boolean deQueue() {
			int idx = ++front % qu.length;

			if (qu[idx] == -1) {
				return false;
			}

			qu[idx] = -1;
			front++;
			return true;
		}

		public int Front() {
			return qu[front % qu.length];
		}

		public int Rear() {
			return qu[back % qu.length];
		}

		public boolean isEmpty() {
			if (front == back || (back + 1 == front)) {
				return true;
			} else {
				return false;
			}
		}

		public boolean isFull() {
			if ((back + 1) % qu.length == front) {
				return true;
			} else {
				return false;
			}
		}
	}

	public static void main(String[] args) {
		int[] nums = { 5, 4, 3, 2, 1 };
		int[] left = new int[nums.length];
		Stack<Integer> idx = new Stack<>();
		for (int i = 0; i < nums.length; i++) {
			while (!idx.isEmpty() && nums[idx.peek()] < nums[i]) {
				idx.pop();
			}
			left[i] = idx.isEmpty() ? -1 : idx.peek();
			idx.push(i);
		}
		System.out.println(Arrays.toString(left));
		while (!idx.isEmpty()) {
			System.out.println(nums[idx.pop()]);
		}

		MyCircularQueue myCircularQueue = new DesignACircularQueue().new MyCircularQueue(3);
		myCircularQueue.enQueue(1); // return True
		myCircularQueue.enQueue(2); // return True
		myCircularQueue.enQueue(3); // return True
		myCircularQueue.enQueue(4); // return False
		myCircularQueue.Rear(); // return 3
		myCircularQueue.isFull(); // return True
		myCircularQueue.deQueue(); // return True
		myCircularQueue.enQueue(4); // return True
		myCircularQueue.Rear(); // return 4
	}

}
