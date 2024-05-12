package dsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.Stack;
import java.util.regex.Pattern;

class ParkingSystem {

	int big;
	int medium;
	int small;

	public ParkingSystem(int big, int medium, int small) {
		this.big = big;
		this.medium = medium;
		this.small = small;
	}

	public boolean addCar(int carType) {
		switch (carType) {
		case 1:
			if (--big > -1) {
				return true;
			}
			break;
		case 2:
			if (--medium > -1) {
				return true;
			}
			break;
		case 3:
			if (--small > -1) {
				return true;
			}
			break;
		default:
			return false;
		}
		return false;
	}
}

class OrderedStream {

	int ptr = 0;
	String[] arr;

	public OrderedStream(int n) {
		arr = new String[n];
	}

	public List<String> insert(int idKey, String value) {
		arr[idKey - 1] = value;
		if (arr[ptr] == null || arr[ptr] == "") {
			return new ArrayList<>();
		}
		List<String> ans = new ArrayList<>();
		while (ptr < arr.length && arr[ptr] != null && arr[ptr] != "") {
			ans.add(arr[ptr++]);
		}
		return ans;
	}
}

class TreeNode {

	int val;
	TreeNode left;
	TreeNode right;

	public TreeNode() {
	}

	public TreeNode(int val) {
		this.val = val;
	}

	public TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

class RandomizedSet {

	Set<Integer> hash;

	public RandomizedSet() {
		hash = new HashSet<>();
	}

	public boolean insert(int val) {
		return hash.add(val);
	}

	public boolean remove(int val) {
		return hash.remove(val);
	}

	public int getRandom() {
		return hash.toArray(new Integer[hash.size()])[new Random().nextInt(hash.size())];
	}
}

public class LeetCode implements Inter, Some {

	private static int canBeTypedWords(String text, String brokenLetters) {
		String[] strarr = text.split(" ");
		char[] bw = brokenLetters.toCharArray();
		int count = strarr.length;
		for (String arr : strarr) {
			char[] crr = arr.toCharArray();
			boolean flag = false;
			for (Character c : crr) {
				for (Character z : bw) {
					if (c == z) {
						flag = true;
					}
				}
			}
			if (flag)
				count--;
		}
		return count < 0 ? 0 : count;
	}

	private static List<String> summaryRanges(int[] nums) {
		List<String> ans = new ArrayList<>();

		for (int i = 0; i < nums.length; i++) {
			int beg = nums[i];
			while (i + 1 < nums.length && nums[i] == nums[i + 1] - 1) {
				++i;
			}
			if (beg != nums[i]) {
				ans.add(beg + "->" + nums[i]);
			} else {
				ans.add(beg + "");
			}
		}
		return ans;
	}

	private static int findClosestNumber(int[] nums) {
		int ans = Integer.MAX_VALUE;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.put(Math.abs(nums[i] - 0),
					map.getOrDefault(Math.abs(nums[i] - 0), Integer.MIN_VALUE) > nums[i]
							? map.getOrDefault(Math.abs(nums[i] - 0), Integer.MIN_VALUE)
							: nums[i]);
		}

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (ans > entry.getKey()) {
				ans = entry.getKey();
			}
		}

		return map.get(ans);
	}

	private static int findMinDifference(List<String> t) {
		t = new ArrayList<>();

		t.add("05:31");
		t.add("00:35");
		t.add("22:08");
		int min = Integer.MAX_VALUE;

		List<Integer> ll = new ArrayList<>();
		for (int i = 0; i < t.size(); i++) {
			String[] arr = t.get(i).split(":");
			int currSum = (Integer.parseInt(arr[1]) + (Integer.parseInt(arr[0]) * 60));
			ll.add(currSum);
		}
		Collections.sort(ll);

		for (int i = 0; i < ll.size(); i++) {
			for (int j = i + 1; j < ll.size(); j++) {
				min = Math.min(min, Math.abs(ll.get(i) + 1440 - ll.get(j)));
				min = Math.min(min, Math.abs(ll.get(j) - ll.get(i)));
			}
		}
		return min;
	}

	private static int alternateDigitSum(int n) {
		boolean flag = true;
		int ans = 0;
		int[] arr = new int[Integer.toString(n).length()];
		int i = 0;
		while (n > 0) {
			int z = n % 10;
			arr[i++] = z;
			n /= 10;
		}

		for (int j = arr.length - 1; j >= 0; j--) {
			if (flag) {
				ans += arr[j];
				flag = false;
			} else {
				ans -= arr[j];
				flag = true;
			}
		}
		return ans;
	}

	private static int[] separateDigits(int[] nums) {
		StringBuilder sb = new StringBuilder();
		for (Integer n : nums) {
			sb.append(new StringBuilder().append(Integer.toString(n)).reverse());
		}
		int[] ans = new int[sb.length()];
		for (int i = 0; i < sb.length(); i++) {
			ans[i] = Integer.parseInt(String.valueOf(sb.charAt(i)));
		}
		return ans;
	}

	private static int countEven(int num) {
		int count = 0;
		for (int i = 2; i <= num; i++) {
			int j = i;
			int sum = 0;
			while (j > 0) {
				sum += j % 10;
				j /= 10;
			}
			System.out.println("i = " + i + " ;sum = " + sum);
			if (sum % 2 == 0) {
				count++;
			}
		}
		return count;
	}

	private static int maxDivScore(int[] n, int[] d) {
		Arrays.sort(d);
		int prev = -1;
		int cur = 0;
		int[] a = new int[d.length];
		for (int i = 0; i < d.length; i++) {
			int c = 0;
			cur = d[i];
			if (cur == prev) {
				a[i] = a[i - 1];
				prev = cur;
				continue;
			}
			for (int j = 0; j < n.length; j++) {
				if (n[j] % cur == 0) {
					c++;
				}
			}
			a[i] = c;
			prev = cur;
		}
		int idx = 0;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < a.length; i++) {
			if (a[i] > max) {
				max = a[i];
				idx = i;
			}
		}
		return d[idx];
	}

	private static int pivotInteger(int n) {
		int t = ((n * (n + 1)) / 2);

		for (int i = 1; i <= n; i++) {
			int c = ((i * (i + 1)) / 2);
			if (t - c == c - i) {
				return i;
			}
		}
		return -1;
	}

	private static int minimumOperations(int[] nums) {
		Set<Integer> s = new HashSet<>();
		for (Integer n : nums) {
			if (n != 0 && s.add(n)) {
				s.add(n);
			}
		}
		return s.size();
	}

	private static String finalString(String s) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'i') {
				sb.reverse();
			} else {
				sb.append(s.charAt(i));
			}
		}
		return sb.toString();
	}

	private static String reverseOnlyLetters(String s) {
		int i = 0;
		int j = s.length() - 1;
		char[] arr = s.toCharArray();
		while (j > i) {
			if (!Character.isLetter(s.charAt(i))) {
				i++;
			} else if (!Character.isAlphabetic(s.charAt(j))) {
				j--;
			} else {
				arr[i] = s.charAt(j);
				arr[j] = s.charAt(i);
				j--;
				i++;
			}
		}
		return new String(arr);
	}

	private static int vowelStrings(String[] words, int left, int right) {
		int count = 0;
		for (int i = left; i <= right; i++) {
			String s = words[i];
			Integer len = s.length() - 1;
			if ((s.charAt(0) == 'a' || s.charAt(0) == 'e' || s.charAt(0) == 'i' || s.charAt(0) == 'o'
					|| s.charAt(0) == 'u')
					&& (s.charAt(len) == 'a' || s.charAt(len) == 'e' || s.charAt(len) == 'i' || s.charAt(len) == 'o'
							|| s.charAt(len) == 'u')) {
				count++;
			}
		}
		return count;
	}

	private static int maxPower(String s) {
		int max = Integer.MIN_VALUE;
		char[] arr = s.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			char prev = arr[i];
			int j = i + 1;
			int curmax = 1;
			while (j < arr.length && prev == arr[j]) {
				curmax++;
				j++;
			}
			if (curmax > max) {
				max = curmax;
			}
		}
		return max;
	}

	private static List<String> alertNames(String[] keyName, String[] keyTime) {
		Set<String> ans = new HashSet<>();
		Map<String, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < keyName.length; i++) {
			List<Integer> time = null;
			if (map.get(keyName[i]) == null) {
				time = new ArrayList<>();
			} else {
				time = map.get(keyName[i]);
			}
			time.add(getTime(keyTime[i]));
			map.put(keyName[i], time);
		}

		for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
			List<Integer> timestamps = entry.getValue();
			Collections.sort(timestamps);

			for (int i = 2; i < timestamps.size(); i++) {
				if (timestamps.get(i) - timestamps.get(i - 2) <= 60) {
					ans.add(entry.getKey());
					break;
				}
			}
		}
		List<String> anss = new ArrayList<>(ans);
		Collections.sort(anss);
		return anss;
	}

	private static Integer getTime(String time) {
		return (Integer.parseInt(time.split(":")[0]) * 60 + Integer.parseInt(time.split(":")[1]));
	}

	private static String largestNumber(int[] nums) {
		StringBuilder sb = new StringBuilder();
		Arrays.sort(nums);

		return sb.toString();
	}

	private static int numRabbits(int[] answers) {
		Map<Integer, Integer> map = new HashMap<>();
		for (Integer ans : answers) {
			map.put(ans, map.getOrDefault(ans, 0) + 1);
		}
		Integer rabbit = 0;
		for (Integer key : map.keySet()) {
			double val = (double) map.get(key);
			key += 1;
			rabbit += (int) Math.ceil(val / (1.0 * key)) * key;
		}
		return rabbit;
	}

	private static List<String> splitWordsBySeparator(List<String> words, char separator) {
		List<String> ans = new LinkedList<>();

		for (String w : words) {
			String[] arr = w.split(Pattern.quote(Character.toString(separator)));
			for (String s : arr) {
				if (s != null && s.length() > 0) {
					ans.add(s);
				}
			}
		}
		return ans;
	}

	private static String smallestString(String s) {
		String ans = "";
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			while (i < s.length() && s.charAt(i) != 'a') {
				sb.append(s.charAt(i));
			}
		}

		return ans;
	}

	private static int partitionString(String s) {
		int count = 1;
		String sb = "";
		for (int i = 0; i < s.length(); i++) {
			if (sb.contains(Character.toString(s.charAt(i)))) {
				sb = "";
				count++;
			}
			sb += s.charAt(i);
		}
		return count;
	}

	private static HashMap<String, PriorityQueue<String>> map = new HashMap<>();

	private static LinkedList<String> res = new LinkedList<>();

	private static List<String> findItinerary(List<List<String>> tickets) {
		tickets = new ArrayList<>();
		List<String> t1 = new ArrayList<>();
		t1.add("muc");
		t1.add("lhr");
		List<String> t2 = new ArrayList<>();
		t2.add("jfk");
		t2.add("muc");
		List<String> t3 = new ArrayList<>();
		t3.add("sfo");
		t3.add("sjc");
		List<String> t4 = new ArrayList<>();
		t4.add("lhr");
		t4.add("sfo");
		tickets.add(t1);
		tickets.add(t2);
		tickets.add(t3);
		tickets.add(t4);

		for (List<String> ticket : tickets) {
			String u = ticket.get(0);
			String v = ticket.get(1);
			PriorityQueue<String> temp = map.getOrDefault(u, new PriorityQueue<>());
			temp.offer(v);
			map.put(u, temp);
		}

		dfs("jfk");
		return res;
	}

	private static void dfs(String src) {
		PriorityQueue<String> pq = map.get(src);

		while (pq != null && pq.size() > 0) {
			String temp = pq.poll();
			dfs(temp);
		}
		res.addFirst(src);
		return;
	}

	private static String[] findWords(String[] words) {
		String r1 = "qwertyuiop";
		String r2 = "asdfghjkl";
		String r3 = "zxcvbnm";
		List<String> ans = new ArrayList<>();
		for (String g : words) {
			String s = g.toLowerCase();
			Set<String> set = new HashSet<>();
			for (int i = 0; i < s.length(); i++) {
				String c = Character.toString(s.charAt(i));
				set.add(c);
			}
			String ss = new ArrayList<>(set).get(0);

			if (r1.contains(ss)) {
				boolean flag = true;
				for (String c : set) {
					if (!r1.contains(c)) {
						flag = false;
						break;
					}
				}
				if (flag)
					ans.add(g);
			} else if (r2.contains(ss)) {
				boolean flag = true;
				for (String c : set) {
					if (!r2.contains(c)) {
						flag = false;
						break;
					}
				}
				if (flag)
					ans.add(g);
			} else if (r3.contains(ss)) {
				boolean flag = true;
				for (String c : set) {
					if (!r3.contains(c)) {
						flag = false;
						break;
					}
				}
				if (flag)
					ans.add(g);
			}
		}
		return ans.toArray(new String[0]);
	}

	private static int[] nextGreaterElement(int[] nums1, int[] nums2) {
		int[] ans = new int[nums1.length];
		for (int i = 0; i < nums1.length; i++) {
			int a = nums1[i];
			int b = -1;
			int j = 0;
			boolean flag = false;
			while (j < nums2.length) {
				if (nums2[j] == a) {
					flag = true;
					break;
				}
				j++;
			}
			if (flag) {
				for (int k = j; k < nums2.length; k++) {
					if (nums2[k] > a) {
						b = nums2[k];
						break;
					}
				}
			}
			ans[i] = b;
		}
		return ans;
	}

	private static int strStr(String haystack, String needle) {
		return haystack.indexOf(needle);
	}

	private static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		double d = 0.0;

		int n = nums1.length;
		int m = nums2.length;
		int i = 0;
		int j = 0;

		while (i < n && j < m) {
			if (nums1[i] < nums2[j]) {
				i++;
			}
			if (nums1[i] > nums2[j]) {
				j++;
			}
		}
		return d;
	}

	private static String[] divideString(String s, int k, char fill) {
		List<String> ll = new ArrayList<>();
		int b = 0;
		int e = k;

		while (e < s.length()) {
			String t = s.substring(b, e);
			ll.add(t);
			b = e;
			e += k;
		}

		return ll.toArray(new String[0]);
	}

	private static void matrix(int[][] arr) {
		Arrays.sort(arr, (a, b) -> a[1] - b[1]);
	}

	private static String removeTrailingZeros(String num) {
		for (int i = num.length() - 1; i >= 0; i--) {
			Character c = num.charAt(i);
			if (c != '0') {
				return num.substring(0, ++i);
			}
		}
		return "";
	}

	private static int maximumNumberOfStringPairs(String[] words) {
		int count = 0;
		Map<String, String> map = new HashMap<>();
		for (String word : words) {
			if (map.get(new StringBuilder(word).reverse().toString()) != null) {
				count++;
			}
			map.put(word, new StringBuilder(word).reverse().toString());
		}
		return count;
	}

	private static String entityParser(String text) {
		return text.replaceAll("&quot;", "\"").replaceAll("&apos;", "'").replaceAll("&amp.", "&")
				.replaceAll("&gt;", ">").replaceAll("&lt;", "<").replaceAll("&frasl;", "/");
	}

	private static boolean findSubarrays(int[] nums) {
		Set<Integer> set = new HashSet<>();
		int i = 0;
		int k = i + 1;
		while (k < nums.length) {
			int sum = nums[i] + nums[k];
			System.out.println(sum);
			if (!set.add(sum)) {
				return true;
			}
			k++;
			i++;
		}
		return false;
	}

	private static int maxScoreSightseeingPair(int[] values) {
		int ans = -1;
		for (int i = 0; i < values.length; i++) {
			for (int j = i + 1; j < values.length; j++) {
				int temp = values[i] + values[j] + i - j;
				ans = Math.max(ans, temp);
			}
		}
		return ans;
	}

	private static boolean isAnagram(String a, String b) {
		if (a.length() != b.length())
			return false;
		int[] arr = new int[26];
		a = a.toLowerCase();
		b = b.toLowerCase();
		for (int i = 0; i < a.length(); i++) {
			arr[a.charAt(i) - 'a'] = ++arr[a.charAt(i) - 'a'];
			arr[b.charAt(i) - 'a'] = --arr[b.charAt(i) - 'a'];
		}
		for (Integer i : arr) {
			if (i != 0) {
				return false;
			}
		}
		return true;
	}

	private static int[] findMode(TreeNode root) {
		Map<Integer, Integer> counter = new HashMap<>();
		dfs(root, counter);
		int maxFreq = 0;
		int prevmax = -1;
		List<Integer> ans = new ArrayList<>();

		for (int key : counter.keySet()) {
			maxFreq = Math.max(maxFreq, counter.get(key));
			if (maxFreq > prevmax) {
				ans.clear();
				prevmax = maxFreq;
			}
			if (maxFreq == prevmax)
				ans.add(counter.get(key));
		}

		int[] result = new int[ans.size()];
		for (int i = 0; i < ans.size(); i++) {
			result[i] = ans.get(i);
		}

		return result;
	}

	private static void dfs(TreeNode node, Map<Integer, Integer> counter) {
		if (node == null) {
			return;
		}

		counter.put(node.val, counter.getOrDefault(node.val, 0) + 1);
		dfs(node.left, counter);
		dfs(node.right, counter);
	}

	private static List<Integer> findPeaks(int[] mountain) {
		List<Integer> list = new ArrayList<>();
		for (int i = 1; i < mountain.length - 1; i++) {
			if (mountain[i] > mountain[i - 1] && mountain[i] > mountain[i + 1]) {
				list.add(i);
			}
		}
		return list;
	}

	private static int countX(int L, int R, int X) {
		int ans = 0;
		for (int i = L + 1; i < R; i++) {
			int n = i;
			while (n > 0) {
				Integer temp = n % 10;
				n = n / 10;
				if (temp == X)
					ans++;
			}
		}
		return ans;
	}

	private static int[] minHeap(int n, int[][] q) {
		List<Integer> ll = new ArrayList<>();
		Queue<Integer> a = new PriorityQueue<>();

		for (int i = 0; i < q.length; i++) {
			if (q[i].length == 2) {
				a.add(q[i][1]);
				continue;
			}
			ll.add(a.poll());
		}
		int[] arr = new int[ll.size()];
		for (int i = 0; i < ll.size(); i++) {
			arr[i] = ll.get(i);
		}
		return arr;
	}

	private static int minNumber(int arr[], int N) {
		int sum = 0;

		for (Integer i : arr) {
			sum += i;
		}
		int i = sum;
		while (true) {
			if (isPrime(i))
				break;
			i++;
		}
		return i - sum;
	}

	private static boolean isPrime(Integer i) {
		if (i == 1)
			return false;
		if (i == 2)
			return true;
		for (int j = 3; j <= Math.sqrt(i); j++) {
			if (i % j == 0) {
				return false;
			}
		}
		return true;
	}

	private static int smithNum(int n) {
		boolean isComp = checkComp(n);
		if (!isComp)
			return 0;
		int sum = findSumOfDigits(n);
		System.out.println(sum);
		int sumOfFac = factors(n);
		System.out.println(n);

		return sum == sumOfFac ? 1 : 0;
	}

	private static Map<Integer, Integer> pMap = new HashMap<>();

	private static int factors(Integer n) {
		int sum = 0;
		for (int i = 2; i <= n; i++) {
			if (pMap.containsKey(i) || checkPrime(i)) {
				while (n % i == 0) {
					System.out.println("i-" + i);
					n = n / i;
					sum += findSumOfDigits(i);
					System.out.println(sum);
				}
				pMap.put(i, i);
			}
		}
		return sum;
	}

	private static int findSumOfDigits(int n) {
		int sum = 0;
		while (n > 0) {
			sum += n % 10;
			n /= 10;
		}
		return sum;
	}

	private static boolean checkPrime(int n) {
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	private static boolean checkComp(int n) {
		return !checkPrime(n);
	}

	private static int maxGold(int n, int m, int M[][]) {
		int ans = 0;
		int[][] dp = new int[M.length][M[0].length];
		for (int j = M[0].length - 1; j >= 0; j--) {
			for (int i = M.length - 1; i >= 0; i--) {
				if (j == M[0].length - 1) {
					dp[i][j] = M[i][j];
				} else if (i == 0 && i + 1 < n) {
					dp[i][j] = M[i][j] + Math.max(dp[i][j + 1], dp[i + 1][j + 1]);
				} else if (i == M.length - 1 && j + 1 < m) {
					dp[i][j] = M[i][j] + Math.max(dp[i][j + 1], dp[i - 1][j + 1]);
				} else if (j + 1 < m && i + 1 < n && i - 1 > -1) {
					dp[i][j] = M[i][j] + Math.max(dp[i][j + 1], Math.max(dp[i + 1][j + 1], dp[i - 1][j + 1]));
				}
			}
		}

		ans = dp[0][0];

		for (int i = 1; i < dp.length; i++) {
			ans = Math.max(dp[i][0], ans);
		}
		return ans;
	}

	private static String[] winner(String arr[], int n) {
		Map<String, Integer> hm = new HashMap<>();

		for (String name : arr) {
			hm.put(name, hm.getOrDefault(name, 0) + 1);
		}
		String[] ans = new String[2];
		ans[0] = "";
		ans[1] = "-1";
		for (Map.Entry<String, Integer> en : hm.entrySet()) {
			if (en.getValue() > Integer.parseInt(ans[1])) {
				ans[1] = String.valueOf(en.getValue());
				ans[0] = en.getKey();
			} else if (en.getValue() == Integer.parseInt(ans[1])) {
				ans[0] = ans[0].compareTo(en.getKey()) > 0 ? en.getKey() : ans[0];
			}
		}
		return ans;
	}

	private static ArrayList<Integer> repeatedRows(int matrix[][], int m, int n) {
		Set<String> hashSet = new HashSet<>();
		ArrayList<Integer> ans = new ArrayList<>();

		for (int i = 0; i < matrix.length; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < matrix[i].length; j++) {
				sb.append(matrix[i][j]);
			}
			if (!hashSet.add(sb.toString())) {
				ans.add(i);
			}
		}
		return ans;
	}

	private static boolean closeStrings(String word1, String word2) {
		int[] arr1 = new int[26];
		int[] arr2 = new int[26];

		for (char ch : word1.toCharArray())
			arr1[ch - 'a']++;
		for (char ch : word2.toCharArray())
			arr2[ch - 'a']++;

		for (int i = 0; i < 26; i++) {
			if (arr1[i] == arr2[i]) {
				continue;
			}
			if (arr1[i] == 0 || arr2[i] == 0) {
				return false;
			}
		}

		Arrays.sort(arr1);
		Arrays.sort(arr2);

		for (int i = 0; i < 26; i++) {
			if (arr1[i] != arr2[i]) {
				return false;
			}
		}
		return true;
	}

	private static ArrayList<Integer> duplicates(int arr[], int n) {
		Set<Integer> ans = new HashSet<>();
		Set<Integer> seen = new HashSet<>();

		for (Integer i : arr) {
			if (!seen.add(i)) {
				ans.add(i);
			}
		}
		ArrayList<Integer> rr = new ArrayList<>(ans);
		if (rr.size() == 0) {
			rr.add(-1);
			return rr;
		} else {
			Collections.sort(rr);
			return rr;
		}
	}

	private static boolean ispar(String x) {
		Stack<String> st = new Stack<>();
		for (int i = 0; i < x.length(); i++) {
			String c = String.valueOf(x.charAt(i));
			if (c.equals("[") || c.equals("{") || c.equals("(")) {
				st.push(c);
			} else {
				String pop = st.isEmpty() ? "" : st.pop();
				if (c.equals("]") && pop.equals("[")) {
					continue;
				} else if (c.equals("}") && pop.equals("{")) {
					continue;
				} else if (c.equals(")") && pop.equals("(")) {
					continue;
				} else {
					return false;
				}
			}
		}
		return st.isEmpty();
	}

	private static int firstRepeated(int[] arr, int n) {
		Map<Integer, Integer> hm = new HashMap<>();

		for (Integer i : arr) {
			hm.put(i, hm.getOrDefault(i, 0) + 1);
		}
		for (int i = 0; i < arr.length; i++) {
			if (hm.get(arr[i]) > 0) {
				return i + 1;
			}
		}
		return -1;
	}

	private static String getBinaryRep(int N) {
		String binaryString = Integer.toBinaryString(N);
		String str = "";
		for (int i = 0; i < 30 - binaryString.length(); i++) {
			str += "0";
		}
		return (str + binaryString);
	}

	private static int[] count(String s) {
		int[] ans = new int[4];
		for (int i = 0; i < s.length(); i++) {
			int val = s.charAt(i);
			if (val >= 48 && val <= 57) {
				ans[3]++;
			} else if (val >= 65 && val <= 90) {
				ans[1]++;
			} else if (val >= 97 && val <= 122) {
				ans[0]++;
			} else {
				ans[2]++;
			}
		}
		return ans;
	}

	private static String is_palindrome(int n) {
		return String.valueOf(n).equals(new StringBuilder(String.valueOf(n)).reverse().toString()) ? "Yes" : "No";
	}

	private static ArrayList<Integer> leaders(int arr[], int n) {
		int maxSeen = Integer.MIN_VALUE;
		ArrayList<Integer> ans = new ArrayList<>();
		for (int i = arr.length - 1; i > 0; i--) {
			if (arr[i] > maxSeen) {
				ans.add(arr[i]);
				maxSeen = arr[i];
			}
		}
		Collections.reverse(ans);
		return ans;
	}

	private static boolean findPair(int arr[], int size, int n) {
		Set<Integer> hs = new HashSet<>();
		for (Integer i : arr) {
			if (hs.contains(n + i) || hs.contains(n - i)) {
				return true;
			}
			hs.add(i);
		}

		return false;
	}

	private static int countZeroes(int[] arr, int n) {
		int ans = 0;
		for (int i = arr.length - 1; i > -1; i--) {
			if (arr[i] == 0) {
				ans++;
			}
		}
		return ans;
	}

	private static void rotateArr(int arr[], int d, int n) {
		int start = 0;
		int end = arr.length;
		int rotateby = end % d;
		rotate(arr, start, end - 1);
		rotate(arr, start, rotateby - 1);
		rotate(arr, rotateby, end - 1);
	}

	private static void rotate(int[] arr, int start, int end) {
		while (end > start) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			end--;
			start++;
		}
	}

	private static int max_courses(int n, int total, int[] cost) {
		int ans = 0;
		double rem = total;
		for (Integer x : cost) {
			if (rem >= x) {
				ans++;
				rem = rem - Math.floor(x * 0.9);
			}
		}
		return ans;
	}

	private static List<List<Integer>> findWinners(int[][] matches) {
		List<List<Integer>> ans = new ArrayList<>();
		Map<Integer, Integer> mp = new HashMap<>();

		for (int i = 0; i < matches.length; i++) {
			mp.put(matches[i][0], mp.getOrDefault(matches[i][0], 0));
			mp.put(matches[i][1], mp.getOrDefault(matches[i][1], 0) + 1);
		}
		List<Integer> l1 = new ArrayList<>();
		List<Integer> l2 = new ArrayList<>();
		for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
			if (entry.getValue() == 0) {
				l1.add(entry.getKey());
			}
			if (entry.getValue() == 1) {
				l2.add(entry.getKey());
			}
		}
		Collections.sort(l1);
		Collections.sort(l2);
		ans.add(l1);
		ans.add(l2);
		return ans;
	}

	private static String reverseWords(String S) {
		StringBuilder ans = new StringBuilder();

		String[] sp = S.split("\\.");
		for (int i = sp.length - 1; i > -1; i--) {
			ans.append(sp[i]).append(".");
		}
		ans.setLength(ans.length() - 1);
		return ans.toString();
	}

	private static int transitionPoint(int arr[], int n) {
		int start = 0;
		int end = arr.length - 1;
		int ans = -1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (arr[mid] == 0) {
				start = mid + 1;
			} else {
				ans = mid;
				end = mid - 1;
			}
		}
		return ans;
	}

	private static int convertfive(int num) {
		return Integer.parseInt(String.valueOf(num).replace("0", "5"));
	}

	private static int lastIndex(String s) {
		return s.lastIndexOf("1");
	}

	private static String printNumber(String s, int n) {
		String ans = "";
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			switch (c) {
			case 'a':
			case 'b':
			case 'c':
				ans += "2";
				break;
			case 'd':
			case 'e':
			case 'f':
				ans += "3";
				break;
			case 'g':
			case 'h':
			case 'i':
				ans += "4";
				break;
			case 'j':
			case 'k':
			case 'l':
				ans += "5";
				break;
			case 'm':
			case 'n':
			case 'o':
				ans += "6";
				break;
			case 'p':
			case 'q':
			case 'r':
			case 's':
				ans += "7";
				break;
			case 't':
			case 'u':
			case 'v':
				ans += "8";
				break;
			case 'w':
			case 'x':
			case 'y':
			case 'z':
				ans += "9";
				break;
			default:
				break;
			}
		}
		return ans;
	}

	private static String firstAlphabet(String s) {
		String[] arr = s.split(" ");
		String ans = "";
		for (String ab : arr) {
			ans += ab.charAt(0);
		}
		return ans;
	}

	private static String removeChars(String string1, String string2) {
		for (int i = 0; i < string2.length(); i++) {
			string1 = string1.replace(String.valueOf(string2.charAt(i)), "");
		}
		return string1;
	}

	private static String arrangeString(String s) {
		char[] arr = new char[26];
		int sum = 0;
		for (char c : s.toCharArray()) {
			if (Character.isDigit(c)) {
				sum += c - '0';
			} else
				arr[c - 'A']++;
		}
		String ans = "";
		for (int i = 0; i < 26; i++) {
			int tot = arr[i];
			while (tot > 0) {
				char c = (char) ('A' + i);
				ans += c;
				tot--;
			}
		}
		return sum == 0 ? ans : ans + sum;
	}

	private static void segregate0and1(int[] arr, int n) {
		int zeroP = 0;
		int oneP = arr.length - 1;
		while (oneP > zeroP) {
			if (arr[zeroP] == 1) {
				int temp = arr[zeroP];
				arr[zeroP] = arr[oneP];
				arr[oneP] = temp;
				oneP--;
			} else {
				zeroP++;
			}
		}
		System.out.println(Arrays.toString(arr));
	}

	private static String modify(String s) {
		Character c = s.charAt(0);
		if (Character.isUpperCase(c)) {
			return s.toUpperCase();
		} else {
			return s.toLowerCase();
		}
	}

	private static int minValue(String s, int k) {
		int[] arr = new int[26];
		for (char c : s.toCharArray()) {
			arr[c - 'a']++;
		}
		while (k > 0) {
			int max = -1;
			int tem = -1;
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] > max) {
					max = arr[i];
					tem = i;
				}
			}
			if (tem != -1)
				arr[tem]--;
			k--;
		}
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > 0) {
				sum = sum + (arr[i] * arr[i]);
			}
		}
		return sum;
	}

	private static long[] minAnd2ndMin(long a[], long n) {
		PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 0; i < n; i++) {
			if (!pq.contains(a[i])) {
				pq.add(a[i]);
				if (pq.size() > 2) {
					pq.poll();
				}
			}
		}

		if (pq.size() < 2) {
			return new long[] { -1 };
		}

		long min = pq.poll();
		long smin = pq.poll();

		if (min != smin) {
			return new long[] { Math.min(min, smin), Math.max(min, smin) };
		} else {
			return new long[] { -1 };
		}
	}

	private static ArrayList<Integer> firstAndLast(int arr[], int n, int x) {
		ArrayList<Integer> ans = new ArrayList<>();

		int first = findIndex(arr, x, true);
		if (first == -1) {
			ans.add(-1);
			return ans;
		}
		int last = findIndex(arr, x, false);
		ans.add(first);
		ans.add(last);
		return ans;
	}

	private static int findIndex(int[] arr, int x, boolean flag) {
		int start = 0;
		int end = arr.length - 1;
		int ans = -1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (arr[mid] == x) {
				ans = mid;
				if (flag) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			} else if (arr[mid] > x) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return ans;
	}

	private static long totalFine(long n, long date, long car[], long fine[]) {
		long totFine = 0l;

		boolean iseven = date % 2 == 0;
		for (int i = 0; i < car.length; i++) {
			if (car[i] % 2 != 0 && iseven) {
				totFine += fine[i];
			} else if (car[i] % 2 == 0 && !iseven) {
				totFine += fine[i];
			}
		}
		return totFine;
	}

	private static String MaxZero(String arr[], int N) {
		int ans = -1;
		int max = -1;
		for (String s : arr) {
			int count = 0;
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == '0') {
					count++;
				}
			}
			Integer num = Integer.parseInt(s);
			if (count > max && count != 0) {
				ans = num;
				max = count;
			} else if (count == max) {
				ans = Math.max(ans, num);
			}

		}
		return String.valueOf(ans);
	}

	private static ArrayList<Integer> leaders2(int[] arr, int n) {
		ArrayList<Integer> ans = new ArrayList<>();
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] > max) {
				max = arr[i];
			} else {
				ans.add(max);
				max = arr[i];
			}
		}
		return ans;
	}

	private static boolean metaStrings(String s1, String s2) {
		if (s1.equals(s2) || !(s1.length() == (s2.length()))) {
			return false;
		}
		int[] arr = new int[26];

		for (int i = 0; i < s1.length(); i++) {
			arr[s1.charAt(i) - 'a']++;
			arr[s2.charAt(i) - 'a']--;
		}
		for (int i = 0; i < 26; i++) {
			if (arr[i] != 0)
				return false;

		}
		return true;
	}

	private static int extractMaximum(String s) {
		int ans = -1;

		for (int i = 0; i < s.length(); i++) {
			StringBuilder sb = new StringBuilder();
			if (Character.isDigit(s.charAt(i))) {
				while (i < s.length() && Character.isDigit(s.charAt(i))) {
					sb.append(s.charAt(i));
					i++;
				}
				ans = Math.max(ans, Integer.parseInt(sb.toString()));
			}
		}
		return ans;
	}

	private static boolean checkPangram(String s) {
		int[] arr = new int[26];
		s = s.toLowerCase();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c - 'a' >= 0 && c - 'a' < 26) {
				arr[c - 'a']++;
			}
		}
		for (int i = 0; i < 26; i++) {
			if (arr[i] == 0)
				return false;
		}
		return true;
	}

	private static boolean isPalindrome(String s) {
		if (s == null)
			return true;
		int left = 0;
		int right = s.length() - 1;

		while (left < right) {
			if (!checkChar(s.charAt(left))) {
				left++;
			}
			if (!checkChar(s.charAt(right))) {
				right--;
			}
			if (lower(s.charAt(right)) != lower(s.charAt(left))) {
				return false;
			} else {
				left++;
				right--;
			}
		}
		return true;
	}

	private static char lower(char l) {
		if ((l >= 'a' && l <= 'z') || (l >= '0' && l <= '9'))
			return l;
		return (char) (l + 32);
	}

	private static boolean checkChar(char c) {
		if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')) {
			return true;
		}
		return false;
	}

	private static int ans = 0;

	private static long numberOfPath(int n, int k, int[][] arr) {
		ans = 0;
		int sum = 0;
		findNoPaths(arr, 0, 0, sum, k);
		return ans;
	}

	private static void findNoPaths(int[][] arr, int row, int col, int sum, int k) {
		sum += arr[row][col];
		if (sum > k)
			return;
		if (row == arr.length - 1 && col == arr.length - 1) {
			if (k == sum)
				ans++;
			return;
		}
		if (col < arr.length - 1)
			findNoPaths(arr, row, col + 1, sum, k);
		if (row < arr.length - 1)
			findNoPaths(arr, row + 1, col, sum, k);
	}

	private static int countSubstrings(String s) {
		ans = 0;
		for (int i = 0; i < s.length(); i++) {
			findPalindromes(s, i, i);
			findPalindromes(s, i, i + 1);
		}
		return ans;
	}

	private static void findPalindromes(String s, int start, int end) {
		while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
			start--;
			end++;
			ans++;
		}
	}

	private static int calculate(String s) {
		Stack<Integer> stk = new Stack<>();
		int currentNumber = 0;
		char op = '+';
		for (int i = 0; i < s.length(); i++) {
			char curChar = s.charAt(i);
			if (Character.isDigit(curChar)) {
				currentNumber = currentNumber * 10 + (curChar - '0');
			}
			if (!Character.isDigit(curChar) && !Character.isWhitespace(curChar) || i == s.length() - 1) {
				if (op == '-')
					stk.push(-currentNumber);
				if (op == '+')
					stk.push(currentNumber);
				if (op == '/')
					stk.push(stk.pop() / currentNumber);
				if (op == '*')
					stk.push(stk.pop() * currentNumber);
				currentNumber = 0;
				op = curChar;
			}
		}
		int ans = 0;
		while (!stk.isEmpty()) {
			ans += stk.pop();
		}
		return ans;
	}

	class Solution {
		public static int calculate(String s) {
			int ans = 0;
			Stack<String> stk = new Stack<>();
			int curNum = 0;
			char op = '+';
			for (int i = 0; i < s.length(); i++) {
				char curChar = s.charAt(i);
				if (Character.isDigit(curChar)) {
					curNum = curNum * 10 + (curChar - '0');
				}
				if (!Character.isDigit(curChar) && !Character.isWhitespace(curChar) || i == s.length() - 1) {
					if (curChar == ')') {
						while (!stk.isEmpty() && !stk.peek().equals("(")) {
							ans += Integer.parseInt(stk.pop());
						}
						stk.pop();
						stk.push(String.valueOf(ans));
						continue;
					}
					if (op == '(') {
						stk.push(String.valueOf(curNum));
						curNum = 0;
						stk.push("(");
					}
					if (op == '-')
						stk.push(String.valueOf(-curNum));
					if (op == '+')
						stk.push(String.valueOf(curNum));
					if (op == '*')
						stk.push(String.valueOf(Integer.parseInt(stk.pop()) * curNum));
					if (op == '/')
						stk.push(String.valueOf(Integer.parseInt(stk.pop()) / curNum));
					op = curChar;
					curNum = 0;
				}
			}
			ans = 0;
			while (!stk.isEmpty()) {
				if (stk.peek() == "(") {
					stk.pop();
					continue;
				}
				// if (op == '/') {
				// ans = Integer.parseInt(stk.pop()) / ans;
				// }
				// if (op == '*') {
				// ans = Integer.parseInt(stk.pop()) * ans;
				// }
				// op = '+';
				ans += Integer.parseInt(stk.pop());
			}
			return ans;
		}
	}

	// [[2,-1,2,-1,2],[1,0,-1,2,-1],[2,-1,-1,-1,2],[2,1,2,-1,2],[0,1,0,0,0],[0,0,0,0,-1],[2,-1,2,2,0],[0,1,0,2,2],[2,2,0,1,-1]]
	public static int[][] modifiedMatrix(int[][] matrix) {
		int[][] ans = new int[matrix.length][matrix[0].length];

		for (int i = 0; i < 51; i++) {
			int tmp = -1;
			List<Integer> idx = new ArrayList<>();
			for (int j = 0; j < 51; j++) {
				if (isSafe(i, j, matrix.length, matrix[0].length)) {
					ans[j][i] = matrix[j][i];
					if (matrix[j][i] == -1) {
						idx.add(j);
						continue;
					}
					tmp = Math.max(tmp, matrix[j][i]);
				}

			}

			for (Integer x : idx)
				ans[x][i] = tmp;
		}

		return ans;
	}

	private static boolean isSafe(int i, int j, int rlength, int clength) {
		return i < clength && j < rlength;
	}

	private static Set<Integer> hs = new LinkedHashSet<>();
	private static Map<Integer, Integer> mp = new HashMap<>();

	private static ArrayList<Integer> recamanSequence(int n) {

		hs.add(0);
		mp.put(0, 0);
		for (int i = 1; i < n; i++) {
			int tmp = mp.get(i - 1) - i;
			if (tmp < 1 || hs.contains(tmp)) {
				tmp = mp.get(i - 1) + i;
			}
			hs.add(tmp);
			mp.put(i, tmp);
		}
		ArrayList<Integer> ans = new ArrayList<>();
		ans.addAll(hs);
		return ans;
	}

	private static int maxProduct(int arr[], int n) {
		// code here
		Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
		for (int i : arr) {
			q.add(i);
			if (q.size() > 2) {
				q.poll();
			}
		}
		return q.poll() * q.poll();
	}

	private static int maxProfit(int n, int[] price) {
		int[] profits = new int[n];
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				profits[i] = Math.max(profits[i], price[j] - price[i]);
			}
		}
		return 0;
	}

	private static int countPairs(LinkedList<Integer> head1, LinkedList<Integer> head2, int x) {
		int ans = 0;

		Set<Integer> hs = new HashSet<>();

		for (Integer i : head1) {
			hs.add(i);
		}
		for (Integer i : head2) {
			if (hs.contains(x - i)) {
				ans++;
			}
		}
		return ans;
	}

	private static int numIslands(char[][] grid) {
		int count = 0;
		int n = grid.length;
		int m = grid[0].length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == '1') {
					numberOfIsland(grid, i, j, n, m);
					count++;
				}
			}
		}
		return count;
	}

	private static void numberOfIsland(char[][] grid, int r, int c, int n, int m) {
		if (grid[r][c] == '2')
			return;
		int[][] dir = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
		grid[r][c] = '2';
		for (int[] d : dir) {
			int i = r + d[0];
			int j = c + d[1];
			if (GraphUtils.isSafe(i, j, n, m) && grid[i][j] == '1') {
				numberOfIsland(grid, i, j, n, m);
			}
		}
	}

	private static int cur = 0;

	private static int maxAreaOfIsland(int[][] grid) {
		int area = 0;
		int n = grid.length;
		int m = grid[0].length;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == 1) {
					cur = 1;
					getArea(grid, i, j, n, m);
				}
				area = Math.max(area, cur);
			}
		}
		return area;
	}

	private static void getArea(int[][] grid, int r, int c, int n, int m) {
		if (grid[r][c] != 1)
			return;
		grid[r][c] = 2;
		int[][] dir = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
		for (int[] d : dir) {
			int i = r + d[0];
			int j = c + d[1];
			if (GraphUtils.isSafe(i, j, n, m) && grid[i][j] == 1) {
				cur++;
				getArea(grid, i, j, n, m);
			}
		}
	}

	private static boolean checkValidString(String s) {
		try {
			int count = 0;
			Stack<Character> stk = new Stack<>();
			for (int i = 0; i < s.length(); i++) {
				System.out.println(count);
				switch (s.charAt(i)) {
				case '(':
					stk.push('(');
					break;
				case ')':
					if (stk.size() > 0) {
						stk.pop();
					} else if (count > 0) {
						count--;
					} else {
						return false;
					}
					break;
				case '*':
					count++;
					break;
				default:
					System.out.println(s.charAt(i));
					break;
				}
			}
			if (stk.size() == 0 || count >= stk.size()) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	private static int maximumPrimeDifference(int[] nums) {
		int l = 0;
		int r = nums.length - 1;
		boolean fl = false;
		boolean fr = false;
		while (r >= l) {
			int left = nums[l];
			int right = nums[r];
			if (fl || isPrime(left)) {
				fl = true;
			} else {
				l++;
			}
			if (fr || isPrime(right)) {
				fr = true;
			} else {
				r--;
			}
			if (fl && fr) {
				break;
			}
		}
		return Math.abs(l - r);

	}

	private static boolean canMakeSquare(char[][] grid) {
		int[][] dirs = new int[][] { { 1, 0 }, { 0, 1 }, { 1, 1 } };
		for (int i = 0; i < grid.length - 1; i++) {
			for (int j = 0; j < grid.length - 1; j++) {
				int w = 0;
				int b = 0;
				if (grid[i][j] == 'B')
					b += 1;
				else
					w += 1;
				for (int[] dir : dirs) {
					int x = i + dir[0];
					int y = j + dir[1];
					if (x < 0 || y < 0 || x > grid.length - 1 || y > grid.length - 1)
						continue;
					if (grid[x][y] == 'B')
						b += 1;
					else
						w += 1;

				}
				if ((b == 1 && w == 3) || (w == 1 && b == 3) || (w == 0 && b == 4) || (b == 0 && w == 4))
					return true;
			}
		}
		return false;
	}

	public int gcd(int a, int b) {
		while (b != 0) {
			int temp = a % b;
			a = b;
			b = temp;
		}
		return a;
	}

	public int minAnagramLength(String s) {
		int[] freq = new int[26];
		for (Character c : s.toCharArray()) {
			freq[c - 'a']++;
		}
		int common = freq[s.charAt(0) - 'a'];
		for (int i = 0; i < 26; i++) {
			if (freq[i] != 0) {
				common = gcd(common, freq[i]);
			}
		}
		int sum = 0;
		for (int i = 0; i < 26; i++) {
			sum += freq[i];
		}
		return sum / common;

	}

	public boolean isValid(String word) {
		if (word == null)
			return false;
		if (word.length() < 3)
			return false;
		boolean uc = false;
		boolean lc = false;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
				if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I'
						|| c == 'O' || c == 'U')
					lc = true;
				else
					uc = true;
			} else if (c >= '0' && c <= '9') {
				continue;
			} else {
				return false;
			}
		}
		if (uc && lc)
			return true;
		return false;
	}

	public int findMaxK(int[] nums) {
		Map<Integer, Integer> hm = new HashMap<>();
		int max = -1;
		for (Integer i : nums) {
			hm.put(i, i);
		}
		for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
			if (entry.getKey() < 0 && hm.get(Math.abs(entry.getKey())) != null) {
				max = Math.max(max, Math.abs(entry.getKey()));
			} else if (hm.get(Math.negateExact(entry.getKey())) != null) {
				max = Math.max(max, entry.getKey());
			}
		}
		return max;
	}

	public long maximumHappinessSum(int[] happiness, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for (int h : happiness) {
			pq.add(h);
		}
		long ans = 0l;
		int turns = 0;
		for (int i = 0; i < k; i++) {
			ans += Math.max(pq.poll() - turns, 0);
			turns++;
		}
		return ans;
	}

	public boolean satisfiesConditions(int[][] grid) {
		if (grid == null || grid.length == 0) {
			return false;
		}

		for (int j = 0; j < grid[0].length; j++) {
			int col = grid[0][j];
			for (int i = 0; i < grid.length; i++) {
				if (grid[i][j] != col) {
					return false;
				}
			}
		}

		for (int i = 0; i < grid.length; i++) {
			int col = grid[i][0];
			for (int j = 1; j < grid[i].length; j++) {
				if (grid[i][j] == col) {
					return false;
				}
				col = grid[i][j];
			}
		}

		return true;
	}

	public int findPermutationDifference(String s, String t) {
		int ans = 0;
		Map<Character, Integer> mp = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			mp.put(s.charAt(i), i);
		}

		for (int i = 0; i < t.length(); i++) {
			ans += Math.abs(mp.get(t.charAt(i)) - i);
		}
		return ans;
	}

	public static int maximumEnergy(int[] energy, int k) {
		int ans = Integer.MIN_VALUE;
		for (int i = k; i < energy.length; i++) {
			energy[i] = Math.max(energy[i - k] + energy[i], energy[i]);
		}
		for (int i = energy.length - k; i < energy.length; i++) {
			ans = Math.max(ans, energy[i]);
		}
		return ans;
	}

	public static void main(String[] args) {

		System.out.println(maximumEnergy(new int[] { -2, -3, -1 }, 2));

		System.out.println(maximumEnergy(new int[] { 5, 2, -10, -5, 1 }, 3));

		System.out.println(canMakeSquare(new char[][] { { '1', '2', 'B' }, { 'W', 'B', 'W' }, { 'B', 'W', 'B' } }));

		System.out.println(maximumPrimeDifference(new int[] { 4, 8, 2, 8 }));

		System.out.println(checkValidString(
				"(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())"));

		System.out.println(maxAreaOfIsland(
				new int[][] { { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
						{ 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0 },
						{ 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
						{ 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 } }));

		System.out.println(numIslands(new char[][] { { '1', '0', '1', '1', '1' }, { '1', '0', '1', '0', '1' },
				{ '1', '1', '1', '0', '1' } }));

		System.out.println(numIslands(new char[][] { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' },
				{ '1', '1', '0', '0', '0' }, { '0', '0', '0', '0', '0' } }));

		System.out.println(countPairs(new LinkedList<Integer>(), new LinkedList<Integer>(), 10));

		System.out.println(maxProfit(6, new int[] { 10, 22, 5, 75, 65, 80 }));

		System.out.println(maxProduct(new int[] { 1, 100, 42, 4, 23 }, 5));

		System.out.println(recamanSequence(5));

		System.out.println(Arrays.toString(modifiedMatrix(new int[][] { { 2, -1, 2, -1, 2 }, { 1, 0, -1, 2, -1 },
				{ 2, -1, -1, -1, 2 }, { 2, 1, 2, -1, 2 }, { 0, 1, 0, 0, 0 }, { 0, 0, 0, 0, -1 }, { 2, -1, 2, 2, 0 },
				{ 0, 1, 0, 2, 2 }, { 2, 2, 0, 1, -1 } })));

		System.out.println(modifiedMatrix(new int[][] { { 1, 2, -1 }, { 4, -1, 6 }, { 7, 8, 9 } }));

		System.out.println(Solution.calculate("(1+(2+3+4)-5)+(6+7)"));

		System.out.println(Solution.calculate("(-3+8)+100"));

		System.out.println(calculate("-3+8      * 100"));
		System.out.println(countSubstrings("abbbbdefg"));

		System.out.println(numberOfPath(3, 12, new int[][] { { 1, 2, 3 }, { 4, 6, 5 }, { 3, 2, 1 } }));

		Math.pow(10, 10);

		System.out.println(isPalindrome("A man, a plan, a canal: Panama"));

		System.out.println(checkPangram("Bawds jog, flick quartz, vex nymph"));

		System.out.println(extractMaximum("100klh564abc365bg"));

		System.out.println(metaStrings("abcd", "badc"));

		System.out.println(metaStrings("geeks", "exeks"));

		System.out.println(leaders2(new int[] { 16, 17, 4, 3, 5, 2 }, 6));

		System.out.println(MaxZero(new String[] { "90028", "30020" }, 2));

		System.out.println(
				totalFine(9, 3, new long[] { 2, 10, 4, 7, 4, 4, 5, 3, 8 }, new long[] { 2, 3, 10, 6, 4, 2, 5, 2, 8, }));
		System.out.println(totalFine(5, 12, new long[] { 2375, 7682, 2325, 2352 }, new long[] { 250, 500, 350, 200 }));

		System.out.println(firstAndLast(new int[] { 1, 3, 5, 5, 5, 5 }, 6, 5));

		System.out.println(minAnd2ndMin(new long[] { 5, 2, 2, 2, 2 }, 5));
		System.out.println(minAnd2ndMin(new long[] { 1, 2, 3, 4, 5 }, 5));
		System.out.println(minAnd2ndMin(new long[] { 1, 2 }, 2));

		System.out.println(minValue("adcceec", 2));
		System.out.println(minValue("ac", 6));

		System.out.println(modify("Axbsnk"));

		segregate0and1(new int[] { 1, 1, 1, 1 }, 4);
		segregate0and1(new int[] { 0, 0, 1, 1, 0 }, 5);

		System.out.println(arrangeString("ACCBA10D2EW30"));

		System.out.println(removeChars("geeksforgeeks", "gfg"));

		System.out.println(firstAlphabet("Geeks For Geeks"));

		System.out.println(printNumber("geeksforgeeks", 10));

		System.out.println(lastIndex("0011779111"));

		System.out.println(convertfive(1005));

		System.out.println(transitionPoint(new int[] { 0, 0, 1, 1, 1 }, 5));

		System.out.println(reverseWords("ac.ss.dd.ww.sdd"));

		System.out.println(findWinners(new int[][] { { 1, 2 }, { 3, 5 }, { 2, 4 } }));

		System.out.println(max_courses(2, 19, new int[] { 10, 9 }));

		rotateArr(new int[] { 1, 2, 3, 4, 5, 6 }, 4, 6);

		System.out.println(countZeroes(new int[] { 0, 0, 0, 1, 1, 1, 1 }, 7));

		System.out.println(findPair(new int[] { 2, 80, 30, 34 }, 4, 78));

		System.out.println(leaders(new int[] { 1, 1, 1, 1, 1, 1 }, 6));

		System.out.println(max_courses(11, 10, new int[] { 10, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }));

		System.out.println(is_palindrome(555));

		System.out.println(count("adbhuwhdiwjk883ihdn!@#@*bjx"));

		System.out.println(getBinaryRep(123));

		System.out.println(firstRepeated(new int[] { 112, 34, 56, 776, 44, 3, 112 }, 7));

		System.out.println(ispar("{}{}{}{}{[][][[()({}{}{})]]}}"));

		System.out.println(duplicates(new int[] { 12, 12, 12, 33, 23 }, 5));

		System.out.println(closeStrings("abc", "cba"));

		System.out.println(repeatedRows(new int[][] { { 0, 0 }, { 0, 1 } }, 0, 0));

		System.out.println(winner(new String[] { "ab", "gv", "hb", "hj", "ju" }, 5));

		System.out.println(maxGold(1, 4, new int[][] { { 0, 0, 0, 0 } }));

		System.out.println(factors(985));

		System.out.println(smithNum(985));

		TreeNode tn = new TreeNode(5);

		System.out.println(findMode(tn));

		System.out.println(minNumber(new int[] { 2, 4, 6, 8, 12 }, 5));

		System.out.println(minHeap(5, new int[][] { { 1, 2, 4, 6 }, { 7, 9, 9, 7, 8 } }));

		System.out.println(countX(0, 10, 6));

		System.out.println(findPeaks(new int[] { 2, 4, 4 }));
		System.out.println(findPeaks(new int[] { 1, 4, 3, 8, 5 }));
		System.out.println(findPeaks(new int[] { 1, 1, 3 }));

		System.out.println(isAnagram("anagramm", "marganaa"));

		System.out.println(maxScoreSightseeingPair(new int[] { 8, 1, 5, 2, 6 }));

		OrderedStream os = new OrderedStream(5);
		System.out.println(os.insert(3, "ccccc"));
		System.out.println(os.insert(1, "aaaaa"));
		System.out.println(os.insert(2, "bbbbb"));
		System.out.println(os.insert(5, "eeeee"));
		System.out.println(os.insert(4, "ddddd"));

		System.out.println(findSubarrays(new int[] { 1, 2, 3, 4 }));

		System.out.println(entityParser("and I quote: &quot;...&quot;"));

		System.out.println(maximumNumberOfStringPairs(new String[] { "ab", "gb", "hb" }));

		System.out.println(removeTrailingZeros("6784567000000000"));

		matrix(new int[][] { { 1, 6, 7, 98 }, { 78, 89, 3, 78 } });

		System.out.println(divideString("fygygygyguygygygguyu", 5, 'o'));

		System.out.println(findMedianSortedArrays(new int[] { 1, 7, 6, 8, 6, 6 }, new int[] { 6, 9, 7, 76, 98, 8 }));

		ParkingSystem parkingSystem = new ParkingSystem(1, 1, 0);

		System.out.println(parkingSystem.addCar(1));
		System.out.println(parkingSystem.addCar(2));
		System.out.println(parkingSystem.addCar(3));

		System.out.println(nextGreaterElement(new int[] { 4, 1, 2 }, new int[] { 1, 3, 4, 2 }));

		System.out.println(strStr("assdd", "a"));

		System.out.println(findWords(new String[] { "Hello", "Alaska", "Dad", "Peace" }));

		System.out.println(findItinerary(null));

		System.out.println(partitionString("ssssss"));

		System.out.println(smallestString("adddwdwdwd"));

		System.out.println(splitWordsBySeparator(Arrays.asList("one.two.three", "four.five", "six"), '.'));

		System.out.println(numRabbits(new int[] { 10, 10, 10 }));
		System.out.println(numRabbits(new int[] { 1, 1, 2 }));

		System.out.println(largestNumber(new int[] { 23, 45, 34, 23 }));

		System.out.println(alertNames(new String[] { "daniel", "daniel", "daniel", "luis", "luis", "luis", "luis", },
				new String[] { "10:00", "10:40", "11:00", "09:00", "11:00", "13:00", "15:00", }));

		System.out.println(maxPower("leetcode"));

		System.out.println(vowelStrings(new String[] { "ab", "bc" }, 0, 2));

		System.out.println(reverseOnlyLetters("ab-cd"));

		System.out.println(finalString("poiinter"));

		System.out.println(minimumOperations(new int[] { 1, 2, 3, 4, 5 }));

		System.out.println(pivotInteger(8));

		System.out.println(maxDivScore(new int[] { 4, 7, 9, 3, 9 }, new int[] { 5, 2, 3 }));
		System.out.println(maxDivScore(new int[] { 20, 14, 21, 10 }, new int[] { 5, 7, 5 }));
		System.out.println(maxDivScore(new int[] { 4, 7, 9, 3, 9 }, new int[] { 10, 16 }));

		System.out.println(countEven(38));

		System.out.println(separateDigits(new int[] { 13, 25, 83, 77 }));

		System.out.println(alternateDigitSum(12));

		System.out.println(findMinDifference(null));

		System.out.println(findClosestNumber(new int[] { -4, -2, 1, 4, 8 }));
		System.out.println(findClosestNumber(new int[] { -4, -2, -4, -8 }));
		System.out.println(findClosestNumber(new int[] { -2, -1, 1 }));

		System.out.println(summaryRanges(new int[] { 0, 1, 2, 4, 5, 7 }));

		System.out.println(canBeTypedWords("abc de", "abc"));
		System.out.println(canBeTypedWords("world hello", "ad"));

	}

	@Override
	public void something() {
		throw new UnsupportedOperationException("Unimplemented method 'something'");
	}
}
