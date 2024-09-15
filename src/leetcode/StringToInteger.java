package leetcode;

import java.math.BigInteger;

public class StringToInteger {

	public int myAtoi(String s) {
		char[] arr = s.trim().toCharArray();
		int i = 0;

		if (arr.length == 0)
			return 0;

		StringBuilder sb = new StringBuilder();
		if (arr[i] == '-') {
			sb.append(arr[i++]);
		} else if (arr[i] == '+') {
			i++;
		}
		if (i >= arr.length || !Character.isDigit(arr[i])) {
			return 0;
		}
		while (i < arr.length && arr[i] == '0') {
			i++;
		}
		if (i >= arr.length || !Character.isDigit(arr[i])) {
			return 0;
		}
		while (i < arr.length && arr[i] >= '0' && arr[i] <= '9') {
			sb.append(arr[i++]);
		}
		BigInteger result = new BigInteger(sb.length() == 0 ? "0" : sb.toString());
		if (result.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) > 0) {
			return Integer.MAX_VALUE;
		} else if (result.compareTo(BigInteger.valueOf(Integer.MIN_VALUE)) < 0) {
			return Integer.MIN_VALUE;
		}
		return result.intValue();
	}

	public static void main(String[] args) {
		new StringToInteger().myAtoi("42");
		new StringToInteger().myAtoi("   -042");
		new StringToInteger().myAtoi("1337c0d3");
		new StringToInteger().myAtoi("0-1");
		new StringToInteger().myAtoi("words and 987");
		new StringToInteger().myAtoi("42");

	}

}
