package leetcode;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {

	class Node {
		int val;
		Node next;
		Node random;

		public Node(int val) {
			this.val = val;
			this.next = null;
			this.random = null;
		}
	}

	Map<Node, Node> nodeMap = new HashMap<>();

	public Node copyRandomList(Node head) {
		if (head == null)
			return null;
		Node temp = new Node(head.val);
		nodeMap.put(head, temp);
		temp.next = copyRandomList(head.next);
		temp.random = nodeMap.get(head.random);
		return temp;
	}

	public static void main(String[] args) {

	}

}
