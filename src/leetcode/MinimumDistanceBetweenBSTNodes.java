package leetcode;

public class MinimumDistanceBetweenBSTNodes {

	TreeNode prev;
	int min = Integer.MAX_VALUE;

	public int minDiffInBST(TreeNode root) {
		traverse(root);
		return min;
	}

	private void traverse(TreeNode root) {
		if (root == null)
			return;

		traverse(root.left);
		if (prev != null) {
			min = Math.min(min, root.val - prev.val);
		}
		prev = root;
		traverse(root.right);

	}

	public static void main(String[] args) {

	}

}
