package linkedList;

public class RemoveAllDuplicates {

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			next = null;
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

	public static void main(String[] args) {

		// [0,3,1,0,4,5,2,0]

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
