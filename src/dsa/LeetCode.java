package dsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
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

public class LeetCode {

  public static int canBeTypedWords(String text, String brokenLetters) {
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
      if (flag) count--;
    }
    return count < 0 ? 0 : count;
  }

  public static List<String> summaryRanges(int[] nums) {
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

  public static int findClosestNumber(int[] nums) {
    int ans = Integer.MAX_VALUE;
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      map.put(
        Math.abs(nums[i] - 0),
        map.getOrDefault(Math.abs(nums[i] - 0), Integer.MIN_VALUE) > nums[i]
          ? map.getOrDefault(Math.abs(nums[i] - 0), Integer.MIN_VALUE)
          : nums[i]
      );
    }

    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      if (ans > entry.getKey()) {
        ans = entry.getKey();
      }
    }

    return map.get(ans);
  }

  public static int findMinDifference(List<String> t) {
    t = new ArrayList<>();

    t.add("05:31");
    t.add("00:35");
    t.add("22:08");
    int min = Integer.MAX_VALUE;

    List<Integer> ll = new ArrayList<>();
    for (int i = 0; i < t.size(); i++) {
      String[] arr = t.get(i).split(":");
      int currSum =
        (Integer.parseInt(arr[1]) + (Integer.parseInt(arr[0]) * 60));
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

  public static int alternateDigitSum(int n) {
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

  public static int[] separateDigits(int[] nums) {
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

  public static int countEven(int num) {
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

  public static int maxDivScore(int[] n, int[] d) {
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

  public static int pivotInteger(int n) {
    int t = ((n * (n + 1)) / 2);

    for (int i = 1; i <= n; i++) {
      int c = ((i * (i + 1)) / 2);
      if (t - c == c - i) {
        return i;
      }
    }
    return -1;
  }

  public static int minimumOperations(int[] nums) {
    Set<Integer> s = new HashSet<>();
    for (Integer n : nums) {
      if (n != 0 && s.add(n)) {
        s.add(n);
      }
    }
    return s.size();
  }

  public static String finalString(String s) {
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

  public static String reverseOnlyLetters(String s) {
    /*
     *
     * string
     *
     * gtrins
     *
     * gnrits
     *
     * gnirts
     */

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

  public static int vowelStrings(String[] words, int left, int right) {
    int count = 0;
    for (int i = left; i <= right; i++) {
      String s = words[i];
      Integer len = s.length() - 1;
      if (
        (
          s.charAt(0) == 'a' ||
          s.charAt(0) == 'e' ||
          s.charAt(0) == 'i' ||
          s.charAt(0) == 'o' ||
          s.charAt(0) == 'u'
        ) &&
        (
          s.charAt(len) == 'a' ||
          s.charAt(len) == 'e' ||
          s.charAt(len) == 'i' ||
          s.charAt(len) == 'o' ||
          s.charAt(len) == 'u'
        )
      ) {
        count++;
      }
    }
    return count;
  }

  public static int maxPower(String s) {
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

  public static List<String> alertNames(String[] keyName, String[] keyTime) {
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
    return (
      Integer.parseInt(time.split(":")[0]) *
      60 +
      Integer.parseInt(time.split(":")[1])
    );
  }

  public static String largestNumber(int[] nums) {
    StringBuilder sb = new StringBuilder();
    Arrays.sort(nums);

    return sb.toString();
  }

  public static int numRabbits(int[] answers) {
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

  public static List<String> splitWordsBySeparator(
    List<String> words,
    char separator
  ) {
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

  public static String smallestString(String s) {
    String ans = "";
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      while (i < s.length() && s.charAt(i) != 'a') {
        sb.append(s.charAt(i));
      }
    }

    return ans;
  }

  public static int partitionString(String s) {
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
  // airport(lexically asc sorted)
  private static LinkedList<String> res = new LinkedList<>(); // result

  public static List<String> findItinerary(List<List<String>> tickets) {
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

  public static String[] findWords(String[] words) {
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
        if (flag) ans.add(g);
      } else if (r2.contains(ss)) {
        boolean flag = true;
        for (String c : set) {
          if (!r2.contains(c)) {
            flag = false;
            break;
          }
        }
        if (flag) ans.add(g);
      } else if (r3.contains(ss)) {
        boolean flag = true;
        for (String c : set) {
          if (!r3.contains(c)) {
            flag = false;
            break;
          }
        }
        if (flag) ans.add(g);
      }
    }
    return ans.toArray(new String[0]);
  }

  public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
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

  public int strStr(String haystack, String needle) {
    return haystack.indexOf(needle);
  }

  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    double d = 0.0;

    int n = nums1.length;
    int m = nums2.length;
    int i = 0;
    int j = 0;

    // int mp = (n + m) % 2 == 0 ? (n + m) / 2 + 1 : (n + m) / 2;
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

  public String[] divideString(String s, int k, char fill) {
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

  public static void matrix(int[][] arr) {
    Arrays.sort(arr, (a, b) -> a[1] - b[1]);
  }

  public String removeTrailingZeros(String num) {
    for (int i = num.length() - 1; i >= 0; i--) {
      Character c = num.charAt(i);
      if (c != '0') {
        return num.substring(0, ++i);
      }
    }
    return "";
  }

  public int maximumNumberOfStringPairs(String[] words) {
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

  public static String entityParser(String text) {
    return text
      .replaceAll("&quot;", "\"")
      .replaceAll("&apos;", "'")
      .replaceAll("&amp.", "&")
      .replaceAll("&gt;", ">")
      .replaceAll("&lt;", "<")
      .replaceAll("&frasl;", "/");
  }

  public static boolean findSubarrays(int[] nums) {
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

  public static int maxScoreSightseeingPair(int[] values) {
    int ans = -1;
    for (int i = 0; i < values.length; i++) {
      for (int j = i + 1; j < values.length; j++) {
        int temp = values[i] + values[j] + i - j;
        ans = Math.max(ans, temp);
      }
    }
    return ans;
  }

  public static boolean isAnagram(String a, String b) {
    if (a.length() != b.length()) return false;
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

  public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  public static int[] findMode(TreeNode root) {
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
      if (maxFreq == prevmax) ans.add(counter.get(key));
    }

    int[] result = new int[ans.size()];
    for (int i = 0; i < ans.size(); i++) {
      result[i] = ans.get(i);
    }

    return result;
  }

  public static void dfs(TreeNode node, Map<Integer, Integer> counter) {
    if (node == null) {
      return;
    }

    counter.put(node.val, counter.getOrDefault(node.val, 0) + 1);
    dfs(node.left, counter);
    dfs(node.right, counter);
  }

  public static List<Integer> findPeaks(int[] mountain) {
    List<Integer> list = new ArrayList<>();
    for (int i = 1; i < mountain.length - 1; i++) {
      if (mountain[i] > mountain[i - 1] && mountain[i] > mountain[i + 1]) {
        list.add(i);
      }
    }
    return list;
  }

  int countX(int L, int R, int X) {
    int ans = 0;
    for (int i = L + 1; i < R; i++) {
      int n = i;
      while (n > 0) {
        Integer temp = n % 10;
        n = n / 10;
        if (temp == X) ans++;
      }
    }
    return ans;
  }

  static int[] minHeap(int n, int[][] q) {
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

  public static int minNumber(int arr[], int N) {
    int sum = 0;

    for (Integer i : arr) {
      sum += i;
    }
    int i = sum;
    while (true) {
      if (isPrime(i)) break;
      i++;
    }
    return i - sum;
  }

  private static boolean isPrime(Integer i) {
    if (i == 1 || i == 2) return true;
    for (int j = 2; j <= Math.sqrt(i); j++) {
      if (i % j == 0) {
        return false;
      }
    }
    return true;
  }

  private static int smithNum(int n) {
    boolean isComp = checkComp(n);
    if (!isComp) return 0;
    int sum = findSumOfDigits(n);
    System.out.println(sum);
    int sumOfFac = factors(n);
    System.out.println(n);

    return sum == sumOfFac ? 1 : 0;
    // code here
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
        pMap.put(i, i); //
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
          dp[i][j] =
            M[i][j] +
            Math.max(
              dp[i][j + 1],
              Math.max(dp[i + 1][j + 1], dp[i - 1][j + 1])
            );
        }
      }
    }

    ans = dp[0][0];

    for (int i = 1; i < dp.length; i++) {
      ans = Math.max(dp[i][0], ans);
    }
    return ans;
  }

  public static String[] winner(String arr[], int n) {
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

  public static ArrayList<Integer> repeatedRows(int matrix[][], int m, int n) {
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

  public static boolean closeStrings(String word1, String word2) {
    int[] arr1 = new int[26];
    int[] arr2 = new int[26];

    for (char ch : word1.toCharArray()) arr1[ch - 'a']++;
    for (char ch : word2.toCharArray()) arr2[ch - 'a']++;

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

  public static ArrayList<Integer> duplicates(int arr[], int n) {
    // code here
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

  public static boolean ispar(String x) {
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

  public static int firstRepeated(int[] arr, int n) {
    // Your code here
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

  public static String getBinaryRep(int N) {
    String binaryString = Integer.toBinaryString(N);
    String str = "";
    for (int i = 0; i < 30 - binaryString.length(); i++) {
      str += "0";
    }
    return (str + binaryString);
  }

  public int[] count(String s) {
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

  public static String is_palindrome(int n) {
    return String
        .valueOf(n)
        .equals(new StringBuilder(String.valueOf(n)).reverse().toString())
      ? "Yes"
      : "No";
  }

  public static ArrayList<Integer> leaders(int arr[], int n) {
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

  public static boolean findPair(int arr[], int size, int n) {
    Set<Integer> hs = new HashSet<>();
    for (Integer i : arr) {
      if (hs.contains(n + i) || hs.contains(n - i)) {
        return true;
      }
      hs.add(i);
    }

    return false;
  }

  public static int countZeroes(int[] arr, int n) {
    int ans = 0;
    for (int i = arr.length - 1; i > -1; i--) {
      if (arr[i] == 0) {
        ans++;
      }
    }
    return ans;
  }

  public static void rotateArr(int arr[], int d, int n) {
    int temp = -1;
    for (int i = 0; i < arr.length; i++) {}
  }

  public static void main(String[] args) {
    System.out.println(is_palindrome(555));

    System.out.println(closeStrings("abc", "cba"));

    System.out.println(repeatedRows(new int[][] { { 0, 0 }, { 0, 1 } }, 0, 0));

    System.out.println(maxGold(1, 4, new int[][] { { 0, 0, 0, 0 } }));

    System.out.println(factors(985));

    System.out.println(smithNum(985));

    System.out.println(minNumber(new int[] { 2, 4, 6, 8, 12 }, 5));

    System.out.println(findPeaks(new int[] { 2, 4, 4 }));

    System.out.println(findPeaks(new int[] { 1, 4, 3, 8, 5 }));

    System.out.println(findPeaks(new int[] { 1, 1, 3 }));

    System.out.println(isAnagram("anagramm", "marganaa"));

    System.out.println(maxScoreSightseeingPair(new int[] { 8, 1, 5, 2, 6 }));

    OrderedStream os = new OrderedStream(5);
    System.out.println(os.insert(3, "ccccc")); // Inserts (3, "ccccc"), returns [].
    System.out.println(os.insert(1, "aaaaa")); // Inserts (1, "aaaaa"), returns ["aaaaa"].
    System.out.println(os.insert(2, "bbbbb")); // Inserts (2, "bbbbb"), returns ["bbbbb", "ccccc"].
    System.out.println(os.insert(5, "eeeee")); // Inserts (5, "eeeee"), returns [].
    System.out.println(os.insert(4, "ddddd"));

    System.out.println(findSubarrays(new int[] { 1, 2, 3, 4 }));

    System.out.println(entityParser("and I quote: &quot;...&quot;"));

    ParkingSystem parkingSystem = new ParkingSystem(1, 1, 0);

    System.out.println(parkingSystem.addCar(1)); // return true because there is 1 available slot for a big car
    System.out.println(parkingSystem.addCar(2)); // return true because there is 1 available slot for a medium car
    System.out.println(parkingSystem.addCar(3)); // return false because there is no available slot for a small car
    System.out.println(parkingSystem.addCar(1));

    System.out.println(
      nextGreaterElement(new int[] { 4, 1, 2 }, new int[] { 1, 3, 4, 2 })
    );

    System.out.println(
      findWords(new String[] { "Hello", "Alaska", "Dad", "Peace" })
    );

    System.out.println(findItinerary(null));

    System.out.println(partitionString("ssssss"));

    System.out.println(
      splitWordsBySeparator(
        Arrays.asList("one.two.three", "four.five", "six"),
        '.'
      )
    );

    System.out.println(numRabbits(new int[] { 10, 10, 10 }));

    System.out.println(numRabbits(new int[] { 1, 1, 2 }));

    System.out.println(
      alertNames(
        new String[] {
          "daniel",
          "daniel",
          "daniel",
          "luis",
          "luis",
          "luis",
          "luis",
        },
        new String[] {
          "10:00",
          "10:40",
          "11:00",
          "09:00",
          "11:00",
          "13:00",
          "15:00",
        }
      )
    );

    System.out.println(maxPower("leetcode"));

    System.out.println(reverseOnlyLetters("ab-cd"));

    System.out.println(finalString("poiinter"));

    System.out.println(pivotInteger(8));

    System.out.println(
      maxDivScore(new int[] { 4, 7, 9, 3, 9 }, new int[] { 5, 2, 3 })
    );

    System.out.println(
      maxDivScore(new int[] { 20, 14, 21, 10 }, new int[] { 5, 7, 5 })
    );

    System.out.println(
      maxDivScore(new int[] { 4, 7, 9, 3, 9 }, new int[] { 10, 16 })
    );

    System.out.println(countEven(38));

    System.out.println(separateDigits(new int[] { 13, 25, 83, 77 }));

    System.out.println(alternateDigitSum(12));

    System.out.println(findMinDifference(null));

    System.out.println(findClosestNumber(new int[] { -4, -2, 1, 4, 8 }));

    System.out.println(findClosestNumber(new int[] { -4, -2, -4, -8 }));

    System.out.println(findClosestNumber(new int[] { -2, -1, 1 }));
    // System.out.println(summaryRanges(new int[] {0,1,2,4,5,7}));
    //
    //
    // System.out.println(canBeTypedWords("abc de", "abc"));
    // System.out.println(canBeTypedWords("world hello", "ad"));

  }
}
