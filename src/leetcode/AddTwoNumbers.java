package leetcode;

public class AddTwoNumbers {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//		StringBuilder sb = new StringBuilder();
//		while (l1 != null) {
//			sb.append(l1.val);
//			l1 = l1.next;
//		}
//		BigInteger b1 = new BigInteger(sb.reverse().toString());
//		sb = new StringBuilder();
//		while (l2 != null) {
//			sb.append(l2.val);
//			l2 = l2.next;
//		}
//		BigInteger b2 = new BigInteger(sb.reverse().toString());
//
//		BigInteger b3 = b1.add(b2);
//		ListNode ans = new ListNode();
//		ListNode cur = ans;
//
//		String g = new StringBuilder(b3.toString()).reverse().toString();
//
//		for (int i = 0; i < g.length(); i++) {
//			ListNode temp = new ListNode(g.charAt(i));
//			cur.next = temp;
//			cur = cur.next;
//		}

		ListNode ans = new ListNode();
		ListNode cur = ans;
		int carry = 0;
		while (l1 != null || l2 != null || carry != 0) {
			int x = l1 != null ? l1.val : 0;
			int y = l2 != null ? l2.val : 0;
			l1 = l1 != null ? l1.next : l1;
			l2 = l2 != null ? l2.next : l2;

			int z = x + y + carry;

			carry = z / 10;

			cur.next = new ListNode(z % 10);
			cur = cur.next;
		}

		return ans.next;
	}

	public static void main(String[] args) {
		ListNode three = new ListNode(3, null);
		ListNode four = new ListNode(4, three);
		ListNode two = new ListNode(2, four);

		ListNode fou = new ListNode(4, null);
		ListNode six = new ListNode(6, fou);
		ListNode five = new ListNode(5, six);

		System.out.println(new AddTwoNumbers().addTwoNumbers(two, five));

	}

}
