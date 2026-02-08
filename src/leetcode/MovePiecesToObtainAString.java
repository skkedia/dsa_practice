package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MovePiecesToObtainAString {

	public boolean canChange(String start, String target) {

		Set<String> vis = new HashSet<>();

		Queue<String> qu = new LinkedList<>();

		qu.add(start);

		while (!qu.isEmpty()) {
			String s = qu.poll();
			if (s.equals(target)) {
				return true;
			}

			for (int i = 1; i < s.length(); i++) {
				if (s.charAt(i) == 'L' && s.charAt(i - 1) == '_') {
					char[] arr = s.toCharArray();
					swap(arr, i - 1, i);
					String n = new String(arr);
					if (!vis.contains(n)) {
						vis.add(n);
						qu.add(n);
					}
					swap(arr, i, i - 1);
				}
				if (s.charAt(i - 1) == 'R' && s.charAt(i) == '_') {
					char[] arr = s.toCharArray();
					swap(arr, i - 1, i);
					String n = new String(arr);
					if (!vis.contains(n)) {
						vis.add(n);
						qu.add(n);
					}
					swap(arr, i, i - 1);
				}
			}
		}

		int idx = 0;
		int end = 0;
		int len = start.length();

		while (idx < len || end < len) {
			while (idx < len && start.charAt(idx) == '_') {
				idx++;
			}

			while (end < len && target.charAt(end) == '_') {
				end++;
			}

			if (idx == len || end == len) {
				return idx == len && end == len;
			}

			if (start.charAt(idx) != target.charAt(end) || (start.charAt(idx) == 'L' && idx < end)
					|| (start.charAt(end) == 'R' && idx > end)) {
				return false;
			}
			idx++;
			end++;
		}

		return true;
	}

	private void swap(char[] arr, int i, int j) {
		char tem = arr[j];
		arr[j] = arr[i];
		arr[i] = tem;
	}

	public static void main(String[] args) {
		System.out.println(new MovePiecesToObtainAString().canChange("_L__R__R_", "L______RR"));

	}

}
