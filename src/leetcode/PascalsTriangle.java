package leetcode;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

	public List<List<Integer>> generate(int num) {
		List<List<Integer>> ans = new ArrayList<>();
		ans.add(new ArrayList<>());
		ans.get(0).add(1);
		for (int i = 1; i < num; i++) {
			List<Integer> cur = new ArrayList<>();
			cur.add(1);
			List<Integer> pre = ans.get(i - 1);

			for (int j = 1; j < i; j++) {
				cur.add(pre.get(j - 1) + pre.get(j));
			}
			cur.add(1);
			ans.add(cur);
		}
		return ans;
	}

	public static void main(String[] args) {
		System.out.println(new PascalsTriangle().generate(6));
	}

}
