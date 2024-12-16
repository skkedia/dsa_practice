package leetcode;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII {

	public List<Integer> getRow(int k) {
		List<List<Integer>> pascal = new ArrayList<>();

		List<Integer> p = new ArrayList<>();
		p.add(1);

		pascal.add(p);

		for (int i = 1; i < k; i++) {
			List<Integer> pre = pascal.get(i - 1);
			List<Integer> cur = new ArrayList<>();
			cur.add(1);
			for (int j = 1; j < pre.size(); j++) {
				cur.add(pre.get(j) + pre.get(j - 1));
			}
			cur.add(1);
			pascal.add(cur);
		}

		return pascal.get(k);
	}

	public static void main(String[] args) {

	}

}
