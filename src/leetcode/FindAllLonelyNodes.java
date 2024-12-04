package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindAllLonelyNodes {

	public List<Integer> getLonelyNodes(TreeNode root) {
		List<Integer> ans = new ArrayList<>();
		Queue<TreeNode> qu = new LinkedList<>();
		qu.add(root);
		while (!qu.isEmpty()) {
			TreeNode cur = qu.poll();
			if (cur.left != null)
				qu.add(cur.left);
			if (cur.right != null)
				qu.add(cur.right);
			if (cur.left == null && cur.right != null) {
				ans.add(cur.right.val);
			} else if (cur.right == null && cur.left != null) {
				ans.add(cur.left.val);
			}
		}
		return ans;
	}

	public static void main(String[] args) {

	}

}
