package leetcode;

public class RLEIterator {

	class RLIterator {
		int[] val;
		int[] cnt;
		int top = 0;

		public RLIterator(int[] encoding) {
			val = new int[encoding.length / 2];
			cnt = new int[encoding.length / 2];
			int k = 0;
			for (int i = 0; i < encoding.length - 1; i += 2) {
				cnt[k] = encoding[i];
				val[k] = encoding[i + 1];
				k = k + 1;
			}

		}

		public int next(int n) {
			while (n > 0 && top <= val.length - 1) {
				if (cnt[top] >= n) {
					cnt[top] = cnt[top] - n;
					return val[top];
				} else {
					n = n - cnt[top];
					cnt[top] = 0;
					val[top] = 0;
					top++;
				}
			}
			return top >= val.length && n > 0 ? -1 : val[top];
		}
	}

	public static void main(String[] args) {

		RLIterator rLEIterator = new RLEIterator().new RLIterator(new int[] { 3, 8, 0, 9, 2, 5 }); // This maps to the
																									// sequence
																									// [8,8,8,5,5].
		System.out.println(rLEIterator.next(2)); // exhausts 2 terms of the sequence, returning 8. The remaining
													// sequence is now
		// [8, 5, 5].
		System.out.println(rLEIterator.next(1)); // exhausts 1 term of the sequence, returning 8. The remaining sequence
													// is now
		// [5, 5].
		System.out.println(rLEIterator.next(1)); // exhausts 1 term of the sequence, returning 5. The remaining sequence
													// is now
		// [5].
		System.out.println(rLEIterator.next(2)); // exhausts 2 terms, returning -1. This is because the first term
													// exhausted was
		// 5,
		// but the second term did not exist. Since the last term exhausted does not
		// exist, we return -1.

	}

}
