package geeksforgeeks;

import java.util.ArrayList;

public class AncestorsOfABinaryTree {

	ArrayList<Integer> ans = new ArrayList<>();

	public ArrayList<Integer> Ancestors(Node root, int target) {
		solve(root, target);
		return ans;
	}

	private int solve(Node root, int target) {
		if (root == null) {
			return 0;
		}
		if (root.data == target) {
			return 1;
		}
		int left = solve(root.left, target);
		int right = solve(root.right, target);

		if ((left | target) == 1) {
			ans.add(root.data);
		}
		return left | right;
	}

	public static void main(String[] args) {

	}

}
