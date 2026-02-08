package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class MergeTwoBinaryTrees {

	class Pair {
		TreeNode t1;
		TreeNode t2;

		Pair(TreeNode t1, TreeNode t2) {
			this.t1 = t1;
			this.t2 = t2;
		}
	}

	public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
		if (root1 == null) {
			return root2;
		}

		if (root2 == null) {
			return root1;
		}
		Queue<TreeNode[]> qu = new LinkedList<>();
		qu.add(new TreeNode[] { root1, root2 });
		while (!qu.isEmpty()) {
			TreeNode[] t = qu.poll();
			if (t[0] == null || t[1] == null) {
				continue;
			}
			t[0].val += t[1].val;

			if (t[0].left == null) {
				t[0].left = t[1].left;
			} else {
				qu.add(new TreeNode[] { t[0].left, t[1].left });
			}

			if (t[0].right == null) {
				t[0].right = t[1].right;
			} else {
				qu.add(new TreeNode[] { t[0].right, t[1].right });
			}

		}
		return root1;

	}

	public static void main(String[] args) {

	}

}
