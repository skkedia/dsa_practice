package leetcode;

public class DesignAStackWithIncrementOperation {
	class CustomStack {
		int[] stk;
		int[] inc;
		int top = -1;

		public CustomStack(int m) {
			stk = new int[m];
			inc = new int[m];
			top = -1;
		}

		public void push(int x) {
			if (top > stk.length - 1) {
				return;
			}
			stk[++top] = x;
		}

		public int pop() {
			if (top < 0) {
				return -1;
			}
			int x = stk[top] + inc[top];
			stk[top] = 0;
			if (top > 0) {
				inc[top - 1] += inc[top];
			}
			inc[top] = 0;
			top--;
			return x;
		}

		public void increment(int k, int val) {
			if (top >= 0) {
				inc[Math.min(k - 1, top)] += val;
			}
		}
	}

	public static void main(String[] args) {
		CustomStack stk = new DesignAStackWithIncrementOperation().new CustomStack(3);
		stk.push(1); // stack becomes [1]
		stk.push(2); // stack becomes [1, 2]
		stk.pop(); // return 2 --> Return top of the stack 2, stack becomes [1]
		stk.push(2); // stack becomes [1, 2]
		stk.push(3); // stack becomes [1, 2, 3]
		stk.push(4); // stack still [1, 2, 3], Do not add another elements as size is 4
		stk.increment(5, 100); // stack becomes [101, 102, 103]
		stk.increment(2, 100); // stack becomes [201, 202, 103]
		stk.pop(); // return 103 --> Return top of the stack 103, stack becomes [201, 202]
		stk.pop(); // return 202 --> Return top of the stack 202, stack becomes [201]
		stk.pop(); // return 201 --> Return top of the stack 201, stack becomes []
		stk.pop();

	}

}
