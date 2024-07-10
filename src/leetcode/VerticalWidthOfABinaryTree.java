package leetcode;

public class VerticalWidthOfABinaryTree {
	class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
			left = null;
			right = null;
		}
	}

	/**
	 * Consider the solution as a number line with root acting as 0, if we go left
	 * minMax[0] is decreased by 1, if we go right then minMax[1] is increased by 1.
	 * In the end we return the difference between minMax[1]and minMax[0]
	 * 
	 * @param root
	 * @return
	 */

	public int verticalWidth(Node root) {
		if (root == null)
			return 0;
		int[] minMax = { 0, 0 };
		solve(root, 0, minMax);
		return minMax[1] - minMax[0] + 1;
	}

	private void solve(Node root, int i, int[] minMax) {
		if (root == null) {
			return;
		}
		minMax[0] = Math.min(minMax[0], i);
		minMax[1] = Math.max(minMax[1], i);
		solve(root.left, i - 1, minMax);
		solve(root.right, i + 1, minMax);

	}
}
