package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PlutonianPebbles {

	public static void main(String[] args) {
		List<Long> ans = new ArrayList<>();
		ans.add(28591l);
		ans.add(78l);
		ans.add(0l);
		ans.add(3159881l);
		ans.add(4254l);
		ans.add(524155l);
		ans.add(598l);
		ans.add(1l);

		Queue<Long> qu = new LinkedList<>();
		for (long i : ans) {
			qu.add(i);
		}
		ans.clear();
		ans = new ArrayList<>();
		int k = 75;
		int h = 0;
		while (k > 0) {
			System.out.println("iter " + h++ + " size = " + qu.size());
			int size = qu.size();
			for (int f = 0; f < size; f++) {
				long z = qu.poll();
				if (z == 0) {
					qu.offer(1l);
				} else {
					String s = String.valueOf(z);
					if (s.length() % 2 == 0) {
						String s1 = s.substring(0, s.length() / 2);
						String s2 = s.substring((s.length() / 2), s.length());
						qu.offer(Long.valueOf(s1));
						int i = 0;
						while (i < s2.length() && s2.charAt(i) == '0') {
							i++;
						}
						if (i == s2.length()) {
							qu.offer(0l);
						} else {
							qu.offer(Long.valueOf(s2.substring(i, s2.length())));
						}
					} else {
						qu.offer(z * 2024);
					}
				}
			}
			k--;
		}
		System.out.println(qu.size());
	}

}
