package linkedList;

class Parent {
	public void sample() {
		System.out.println("hi parent");
	}
}

class Child extends Parent {
	@Override
	public void sample() {
		System.out.println("hi child");
	}
}

public class RemoveAllDuplicates {

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			next = null;
		}
	}

	static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public Node removeAllDuplicates(Node head) {
		if (head == null)
			return head;

		Node ans = new Node(0);
		Node a = ans;
		int prev = head.data;

		System.out.println(prev);
		head = head.next;
		boolean dup = false;
		while (head != null) {
			while (head != null && prev == head.data) {
				dup = true;
				head = head.next;
			}
			if (!dup) {
				Node temp = new Node(prev);
				ans.next = temp;
				ans = ans.next;
				prev = head.data;
				System.out.println(prev);
				dup = false;
			} else {
				dup = false;
			}
			head = head != null ? head.next : null;
		}

		return a.next;
	}

	public ListNode mergeNodes(ListNode head) {
		ListNode ans = null;
		ListNode node = new ListNode(0);
		ans = node;
		int curr = 0;
		head = head.next;
		while (head != null) {
			if (head.val == 0) {
				ListNode temp = new ListNode(curr);
				node.next = temp;
				node = node.next;
				curr = 0;
			}
			curr += head.val;
			head = head.next;
		}
		return ans.next;

	}

	public static void main(String[] args) {

		Child c = new Child();
		c.sample();
		Parent p = new Parent();
		p.sample();
		Parent pc = new Child();
		pc.sample();

		// [0,3,1,0,4,5,2,0]

		ListNode n11 = new ListNode(0);
		ListNode n21 = new ListNode(3);
		ListNode n31 = new ListNode(1);
		ListNode n41 = new ListNode(0);
		ListNode n51 = new ListNode(4);
		ListNode n61 = new ListNode(5);
		ListNode n71 = new ListNode(2);
		ListNode n81 = new ListNode(0);

		n11.next = n21;
		n21.next = n31;
		n31.next = n41;
		n41.next = n51;
		n51.next = n61;
		n61.next = n71;
		n71.next = n81;
		n81.next = null;
		ListNode anss = new RemoveAllDuplicates().mergeNodes(n11);
		while (anss != null) {
			System.out.println(anss.val);
			anss = anss.next;
		}

		// 23 28 28 35 49 49 53 53

		Node n1 = new Node(23);
		Node n2 = new Node(28);
		Node n3 = new Node(28);
		Node n4 = new Node(35);
		Node n5 = new Node(49);
		Node n6 = new Node(49);
		Node n7 = new Node(53);
		Node n8 = new Node(53);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		n8.next = null;

		Node ans = new RemoveAllDuplicates().removeAllDuplicates(n1);
		while (ans != null) {
			System.out.println(ans.data);
			ans = ans.next;
		}

	}

}
