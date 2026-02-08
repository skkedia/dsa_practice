package leetcode;

public class ReverseNodesInKGroups {

	public ListNode reverseKGroup(ListNode head, int k) {
		if (k == 1 || head == null)
			return head;

		ListNode dummy = new ListNode(0);
		dummy.next = head;

		ListNode tempHead = dummy;

		while (true) {

			ListNode tempStart = tempHead.next;
			ListNode tempEnd = tempHead;
			for (int i = 0; i < k && tempEnd != null; i++) {
				tempEnd = tempEnd.next;
			}
			if (tempEnd == null)
				break;

			ListNode nextStart = tempEnd.next;

			ListNode prev = null;
			ListNode current = tempStart;
			while (current != nextStart) {
				ListNode next = current.next;
				current.next = prev;
				prev = current;
				current = next;
			}

			tempHead.next = tempEnd;
			tempStart.next = nextStart;

			tempHead = tempStart;
		}

		return dummy.next;
	}

	public static void main(String[] args) {
		ListNode five = new ListNode(5, null);
		ListNode four = new ListNode(4, five);
		ListNode three = new ListNode(3, four);
		ListNode two = new ListNode(2, three);
		ListNode one = new ListNode(1, two);
		new ReverseNodesInKGroups().reverseKGroup(one, 2);
	}

}
