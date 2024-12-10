package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {

	public String serialize(TreeNode root) {
		if (root == null)
			return null;
		StringBuilder sb = new StringBuilder();

		String n = "null";
		Queue<TreeNode> qu = new LinkedList<>();
		qu.add(root);
		while (!qu.isEmpty()) {
			TreeNode node = qu.poll();
			if (node != null) {
				sb.append(node.val);
				qu.add(node.left);
				qu.add(node.right);
			} else {
				sb.append(n);
			}
			sb.append(",");
		}
		return sb.toString();
	}

	public TreeNode deserialize(String data) {
		if (data == null || data.length() == 0 || data.equals("null"))
			return null;

		String[] vals = data.split(",");
		if (vals == null || vals.length == 0)
			return null;
		String n = "null";
		TreeNode root = new TreeNode(Integer.parseInt(vals[0]));

		Queue<TreeNode> qu = new LinkedList<>();
		qu.add(root);
		int idx = 1;
		while (!qu.isEmpty()) {
			int size = qu.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = qu.poll();
				for (int j = idx; j < vals.length && j < idx + 2; j++) {
					if (vals[j].equals(n)) {
						if (j % 2 == 1) {
							node.left = null;
						} else {
							node.right = null;
						}
					} else {
						TreeNode temp = new TreeNode(Integer.parseInt(vals[j]));
						qu.add(temp);
						if (j % 2 == 1) {
							node.left = temp;
						} else {
							node.right = temp;
						}
					}
				}
				idx = idx + 2;
			}
		}
		return root;
	}

	public static void main(String[] args) {

	}

}
