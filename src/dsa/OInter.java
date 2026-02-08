package dsa;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

class Parent implements Comparable<Parent> {
	void method() {
		System.out.println("hi from parent");
	}

	@Override
	public int compareTo(Parent x) {
		return 0;
	}
}

class Child extends Parent implements Comparator<Child> {
	@Override
	void method() {
		System.out.println("hi from child class");
	}

	@Override
	public int compare(Child x, Child y) {
		return 0;
	}

}

abstract class SingleTon {
	abstract void some();
}

public class OInter extends SingleTon {

	private static int binarySearch(int[] arr, int x) {
		int left = 0;
		int right = arr.length - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (arr[mid] == x)
				return mid;
			else if (arr[mid] > x) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {

		Thread t1 = new Thread("new thread") {
			@Override
			public void run() {
				System.out.println("hello");
			}
		};

		t1.start();

		Parent p = new Parent();
		p.method();
		if (p instanceof Parent) {
			System.out.println("hi");
		} else if (p instanceof Child) {
			System.out.println("there");
		}
		p = new Child();
		if (p instanceof Parent) {
			System.out.println("hi");
		} else if (p instanceof Child) {
			System.out.println("there");
		}
		p.method();

		List<Integer> ll = new ArrayList<>();
		ll.add(45);
		ll.add(5);
		ll.add(3);
		ll.add(34);
		ll.add(67);
		ll.add(12);
		ll.add(43);
		ll = ll.stream().sorted().collect(Collectors.toList());

		System.out.println(ll);

		System.out.println(binarySearch(new int[] { 23, 67, 78, 90, 100 }, 100));
		System.out.println(binarySearch(new int[] { 23, 67, 78, 90, 100 }, -1));
		/**
		 * 
		 * A- B C B - D E C - F G
		 * 
		 * A B c D E F G Node root; Node node = root; Node temp = null; while(node !=
		 * null) { temp = node; node = node.left; }
		 * 
		 * return temp.data;
		 */
	}

	@Override
	void some() {

	}

	public String findLargest(int[] arr) {
		// 11042 11590 18350 20078 20220
		// o/p 2007820220183501159011042
		// exp 2022020078183501159011042
		Queue<Integer> pq = new PriorityQueue<>((a, b) -> {
			String f = "" + b;
			String s = "" + a;

			if (f.charAt(0) > s.charAt(0)) {
				return 1;
			} else if (f.charAt(0) == s.charAt(0)) {
				int len1 = f.length();
				int len2 = s.length();
				if (len1 > len2) {
					int i = 0;
					while (i < len1) {
						char c = f.charAt(i);
						char d = i < len2 ? s.charAt(i) : s.charAt(len2 - 1);
						if (c > d) {
							return 1;
						} else if (d < c) {
							return -1;
						}
						i++;
					}
				} else if (len2 > len1) {
					int i = 0;
					while (i < len2) {
						char c = s.charAt(i);
						char d = i < len1 ? f.charAt(i) : f.charAt(len1 - 1);
						if (c > d) {
							return -1;
						} else if (d < c) {
							return 1;
						}
						i++;
					}
				} else {
					int i = 0;
					while (i < len2) {
						char c = f.charAt(i);
						char d = s.charAt(i);
						if (c > d) {
							return -1;
						} else if (d < c) {
							return 1;
						}
						i++;
					}
				}
				return 0;
			} else {
				return -1;
			}
		});
		for (int i = 0; i < arr.length; i++) {
			pq.offer(arr[i]);
		}
		StringBuilder sb = new StringBuilder();
		while (!pq.isEmpty()) {
			sb.append(pq.poll());
		}

		BigInteger bi = new BigInteger(sb.toString());

		return bi.toString();
	}

}
