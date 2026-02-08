package leetcode;

public class SubStringMatchingPattern {

	public boolean hasMatch(String s, String p) {
		String[] arr = p.split("\\*");

		if (arr.length == 0)
			return true;

		if (arr[0] == "") {
			return s.indexOf(arr[1]) != -1;
		}

		int idx = s.indexOf(arr[0]);
		if (idx == -1)
			return false;
		String sub = s.substring(idx + arr[0].length(), s.length());

		if (arr.length > 1 && sub.indexOf(arr[1]) == -1) {
			return false;
		}

		return true;
	}

	public static void main(String[] args) {
		System.out.println(new SubStringMatchingPattern().hasMatch("ckckkk", "ck*kc"));
		System.out.println(new SubStringMatchingPattern().hasMatch("nrnrs", "*nn"));
		System.out.println(new SubStringMatchingPattern().hasMatch("l", "*"));
		System.out.println(new SubStringMatchingPattern().hasMatch("luck", "u*"));
		System.out.println(new SubStringMatchingPattern().hasMatch("ojju", "*o"));
		System.out.println(new SubStringMatchingPattern().hasMatch("tokk", "t*t"));
	}

}
