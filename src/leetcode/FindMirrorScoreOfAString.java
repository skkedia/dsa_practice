package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class FindMirrorScoreOfAString {
	private static Map<Character, Character> zz = new HashMap<>();

	static {
		zz.put('a', 'z');
		zz.put('b', 'y');
		zz.put('c', 'x');
		zz.put('d', 'w');
		zz.put('e', 'v');
		zz.put('f', 'u');
		zz.put('g', 't');
		zz.put('h', 's');
		zz.put('i', 'r');
		zz.put('j', 'q');
		zz.put('k', 'p');
		zz.put('l', 'o');
		zz.put('m', 'n');
		zz.put('n', 'm');
		zz.put('o', 'l');
		zz.put('p', 'k');
		zz.put('q', 'j');
		zz.put('r', 'i');
		zz.put('s', 'h');
		zz.put('t', 'g');
		zz.put('u', 'f');
		zz.put('v', 'e');
		zz.put('w', 'd');
		zz.put('x', 'c');
		zz.put('y', 'b');
		zz.put('z', 'a');
	}

	public long calculateScore(String s) {
		Map<Character, Stack<Integer>> hm = new HashMap<>();
		long ans = 0;

		hm.put(s.charAt(0), new Stack<>());
		hm.get(s.charAt(0)).add(0);

		for (int i = 1; i < s.length(); i++) {
			char cur = s.charAt(i);
			char mirror = zz.get(cur);
			if (!hm.containsKey(cur)) {
				hm.put(s.charAt(i), new Stack<>());
			}
			boolean f = true;

			System.out.println("cur : " + cur + " : mirror : " + mirror);
			// System.out.println("hm : " + hm);

			if (hm.containsKey(mirror)) {
				Stack<Integer> stk = hm.get(mirror);
				System.out.println("stk : " + stk);
				if (!stk.isEmpty()) {
					f = false;
					System.out.println("i : " + i + " : j : " + stk.peek());
					ans = ans + (i - stk.pop());
				}
			}
			if (f) {
				hm.get(s.charAt(i)).add(i);
			}
			System.out.println();
		}
		return ans;
	}

	public static void main(String[] args) {
		System.out.println(new FindMirrorScoreOfAString().calculateScore("aaz"));
		System.out.println(new FindMirrorScoreOfAString().calculateScore("eockppxdqclkhjgvnw"));
		System.out.println(new FindMirrorScoreOfAString().calculateScore("aczzx"));
	}

}
