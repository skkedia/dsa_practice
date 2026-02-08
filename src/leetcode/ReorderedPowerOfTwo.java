package leetcode;

import java.util.Arrays;

public class ReorderedPowerOfTwo {
	private String getSortedStr(int n) {
		String s = String.valueOf(n);
		char[] arr = s.toCharArray();
		Arrays.sort(arr);
		s = new String(arr);
		return s;
	}

	public boolean reorderedPowerOf2(int n) {
		String s = getSortedStr(n);
		for (int i = 0; i <= 29; i++) {
			double temp = Math.pow(2, i);
			if (s.equals(getSortedStr((int) temp))) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(new ReorderedPowerOfTwo().reorderedPowerOf2(125));

	}

}
