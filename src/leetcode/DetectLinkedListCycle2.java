package leetcode;

public class DetectLinkedListCycle2 {

	public ListNode detectCycle(ListNode head) {
		if (head == null || head.next == null)
			return null;
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (slow == fast) { // find out where the loop starts
				ListNode entry = head;
				while (slow != entry) {
					slow = slow.next;
					entry = entry.next;
				}
				return entry;
			}
		}
		return null;
	}

}
