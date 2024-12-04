package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaximumDepthOfNaryTree {

	class Node {
		public int val;
		public List<Node> children;

		public Node() {
		}

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val, List<Node> _children) {
			val = _val;
			children = _children;
		}
	};

	public int maxDepth(Node root) {
		if (root == null)
			return 0;
		Queue<Node> qu = new LinkedList<>();
		qu.add(root);
		int h = 0;
		while (!qu.isEmpty()) {
			h++;
			int n = qu.size();
			for (int i = 0; i < n; i++) {
				Node temp = qu.poll();
				for (Node child : temp.children) {
					qu.add(child);
				}
			}
		}
		return h;
	}

	public static void main(String[] args) {

	}

}
