package leetcode;

public class AddingSpacesToAString {

	public String addSpaces(String s, int[] spaces) {
		char[] arr = new char[s.length() + spaces.length];
		int j = 0;
		for (int i : spaces) {
			arr[i + j] = ' ';
			j = j + 1;
		}
		j = 0;
		for (int i = 0; i < s.length(); i++) {
			while (j < arr.length && arr[j] == ' ') {
				j++;
			}
			arr[j++] = s.charAt(i);
		}
		return String.valueOf(arr);
	}

	public static void main(String[] args) {
		System.out.println(new AddingSpacesToAString().addSpaces("LeetcodeHelpsMeLearn", new int[] { 8, 13, 15 }));
		System.out.println(new AddingSpacesToAString().addSpaces("icodeinpython", new int[] { 1, 5, 7, 9 }));
		System.out.println(new AddingSpacesToAString().addSpaces("spacing", new int[] { 0, 1, 2, 3, 4, 5, 6 }));
		System.out.println(5 / 2);

	}

}
