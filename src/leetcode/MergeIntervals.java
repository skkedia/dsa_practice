package leetcode;

import java.util.Arrays;
import java.util.LinkedList;

public class MergeIntervals {

	public int[][] merge(int[][] intervals) {
//		Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
//		List<int[]> ll = new ArrayList<>();
//		for (int[] in : intervals) {
//			if (ll.isEmpty() || in[0] > ll.get(ll.size() - 1)[1]) {
//				ll.add(in);
//			} else {
//				ll.get(ll.size() - 1)[1] = Math.max(ll.get(ll.size() - 1)[1], in[1]);
//			}
//		}
//		return ll.toArray(new int[ll.size()][]);
		Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
		LinkedList<int[]> ll = new LinkedList<>();
		for (int[] in : intervals) {
			if (ll.isEmpty() || in[0] > ll.getLast()[1]) {
				ll.add(in);
			} else {
				ll.getLast()[1] = Math.max(ll.getLast()[1], in[1]);
			}
		}
		return ll.toArray(new int[ll.size()][]);
	}

	public static void main(String[] args) {

	}

}
