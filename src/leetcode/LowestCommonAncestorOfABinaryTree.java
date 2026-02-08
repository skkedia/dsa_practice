package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class LowestCommonAncestorOfABinaryTree {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root == p || root == q)
			return root;
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);

		if (left == null)
			return right;
		else if (right == null)
			return left;
		else
			return root;
	}

	public static void main(String[] args) {
		Deque<Integer> qu = new ArrayDeque<>();
		qu.add(1);
	}

}
