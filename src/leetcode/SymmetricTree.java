package leetcode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class SymmetricTree {

	public boolean isSymmetric(TreeNode root) {
		Queue<TreeNode> qu = new LinkedList<>();
		qu.add(root);
		qu.add(root);
		while (!qu.isEmpty()) {
			TreeNode f = qu.poll();
			TreeNode s = qu.poll();
			if (f == null && s == null)
				continue;
			if (f == null || s == null)
				return false;
			if (f.val != s.val)
				return false;
			qu.add(f.left);
			qu.add(s.right);
			qu.add(f.right);
			qu.add(s.left);

		}
		Map<Integer, Integer> mp = new HashMap<>();
		Collection<Integer> ll = mp.values();
		Collections.sort((ArrayList<Integer>) ll);
		return true;
	}

	public static void main(String[] args) {

	}

}
