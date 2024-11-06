package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class TwoSumIV {

	Map<Integer, Integer> hm = new HashMap<>();

	public boolean findTarget(TreeNode root, int k) {
		// hm.put(0, 1);
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			TreeNode ll = q.poll();
			if (ll.val == (k - ll.val)) {
				if (ll.left != null)
					q.add(ll.left);
				if (ll.right != null)
					q.add(ll.right);
			} else if (ll.val > (k - ll.val) && ll.left != null) {
				q.add(ll.left);
			} else if (ll.val < (k - ll.val) && ll.right != null) {
				q.add(ll.right);
			}
			if (hm.containsKey(k - ll.val)) {
				return true;
			}
			hm.put(ll.val, ll.val);
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
