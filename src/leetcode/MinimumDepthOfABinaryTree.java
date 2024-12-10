package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthOfABinaryTree {

	public int minDepth(TreeNode root) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return 1;
		int ans = 1;
		Queue<TreeNode> qu = new LinkedList<>();
		qu.add(root);

		while (!qu.isEmpty()) {
			ans++;
			int size = qu.size();
			for (int i = 0; i < size; i++) {
				TreeNode temp = qu.poll();
				if (temp == null)
					continue;
				if (temp.left == null && temp.right == null)
					return ans;
				qu.add(temp.left);
				qu.add(temp.right);
			}
		}
		return -1;
	}

	public static void main(String[] args) {

	}

}
