package geeksforgeeks;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromParentArray {

	public Node createTree(int[] parent) {
		Node root = null;
		Map<Integer, Node> hm = new HashMap<>();

		for (int i = 0; i < parent.length; i++) {
			Node node = new Node(i);
			if (parent[i] == -1) {
				root = hm.get(i) != null ? hm.get(i) : new Node(i);
				hm.put(i, root);
			} else if (hm.get(parent[i]) != null) {
				if (hm.get(parent[i]).left == null) {
					hm.get(parent[i]).left = new Node(i);
					hm.put(i, hm.get(parent[i]).left);
				} else {
					hm.get(parent[i]).right = new Node(i);
					hm.put(i, hm.get(parent[i]).right);
				}
			} else {
				Node par = new Node(parent[i]);
				par.left = node;
				hm.put(i, node);
				hm.put(parent[i], par);
			}
		}

		return root;

	}

	public static void main(String[] args) {
		new ConstructBinaryTreeFromParentArray().createTree(new int[] { 1, 13, 31, 7, 17, 33, 27, 1, 5, 15, 19, 3, 33,
				17, 19, 21, 23, 25, 31, 11, 29, 13, 27, 7, 25, -1, 23, 15, 3, 11, 21, 5, 9, 9 });
		new ConstructBinaryTreeFromParentArray().createTree(new int[] { -1, 0, 0, 1, 1, 3, 5 });

		// 1 13 31 7 17 33 27 1 5 15 19 3 33,17 19 21 23 25 31 11 29 13 27 7 25 -1 23 15
		// 3 11 21 5 9 9
	}

}
