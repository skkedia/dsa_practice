package leetcode;

public class BinaryTreeMaximumPathSum {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	private int ans = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {
		sum(root);
		return ans;
	}

	private int sum(TreeNode root) {
		if (root == null)
			return 0;
		int leftMax = Math.max(0, sum(root.left));
		int rightMax = Math.max(0, sum(root.right));
		ans = Math.max(ans, root.val + leftMax + rightMax);
		return root.val + Math.max(leftMax, rightMax);
	}

}
