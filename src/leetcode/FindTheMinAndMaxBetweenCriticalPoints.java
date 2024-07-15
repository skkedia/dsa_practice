package leetcode;

import java.util.ArrayList;
import java.util.List;

public class FindTheMinAndMaxBetweenCriticalPoints {

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public int[] nodesBetweenCriticalPoints(ListNode head) {
		if (head == null | head.next == null || head.next.next == null)
			return new int[] { -1, -1 };

		int[] minMax = new int[] { -1, -1 };

		ListNode temp = head.next;
		ListNode prev = head;
		List<Integer> dist = new ArrayList<>();
		int count = 0;
		boolean flag = false;
		while (temp != null && temp.next != null) {
			if ((temp.val > prev.val && temp.val > temp.next.val)
					|| (temp.val < prev.val && temp.val < temp.next.val)) {
				flag = true;
				dist.add(count);
			}
			if (flag) {
				count++;
			}
			prev = prev.next;
			temp = temp.next;
		}

		int min = Integer.MAX_VALUE;

		for (int i = 1; i < dist.size(); i++) {
			min = Math.min(min, dist.get(i) - dist.get(i - 1));
		}
		minMax[0] = min;
		minMax[1] = dist.get(dist.size() - 1) - dist.get(0);

		return minMax;
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(5);
		ListNode l2 = new ListNode(3);
		ListNode l3 = new ListNode(1);
		ListNode l4 = new ListNode(2);
		ListNode l5 = new ListNode(5);
		ListNode l6 = new ListNode(1);
		ListNode l7 = new ListNode(2);

		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;
		l6.next = l7;

		new FindTheMinAndMaxBetweenCriticalPoints().nodesBetweenCriticalPoints(l1);

		// [1,3,2,2,3,2,2,2,7]

		ListNode ll1 = new ListNode(1);
		ListNode ll2 = new ListNode(3);
		ListNode ll3 = new ListNode(2);
		ListNode ll4 = new ListNode(2);
		ListNode ll5 = new ListNode(3);
		ListNode ll6 = new ListNode(2);
		ListNode ll7 = new ListNode(2);
		ListNode ll8 = new ListNode(2);
		ListNode ll9 = new ListNode(7);

		ll1.next = ll2;
		ll2.next = ll3;
		ll3.next = ll4;
		ll4.next = ll5;
		ll5.next = ll6;
		ll6.next = ll7;
		ll7.next = ll8;
		ll8.next = ll9;
		new FindTheMinAndMaxBetweenCriticalPoints().nodesBetweenCriticalPoints(ll1);
	}

}
