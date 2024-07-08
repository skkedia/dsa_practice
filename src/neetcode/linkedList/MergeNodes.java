package linkedList;

public class MergeNodes {

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
		ListNode anss = new MergeNodes().mergeNodes(n11);
		while (anss != null) {
			System.out.println(anss.val);
			anss = anss.next;
		}
	}

}
