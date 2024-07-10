package leetcode;

public class KokoEatingBananas {

	public int minEatingSpeed(int[] piles, int h) {
		int right = Integer.MIN_VALUE;
		for (int i : piles) {
			right = Math.max(right, i);
		}
		int left = 1;
		while (right > left) {
			int mid = left + (right - left) / 2;
			if (findSpeed(piles, mid, h)) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return left;

	}

	private boolean findSpeed(int[] piles, int mid, int h) {
		int hours = 0;
		for (int i = 0; i < piles.length; i++) {
			hours += piles[i] / mid;
			if (piles[i] % mid != 0)
				hours++;
		}
		System.out.println("gaurd - " + h + " mid val - " + mid + " hours taken - " + hours);
		return hours >= h;
	}

	public static void main(String[] args) {
		new KokoEatingBananas().minEatingSpeed(new int[] { 805306368, 805306368, 805306368 }, 1000000000);
		new KokoEatingBananas().minEatingSpeed(new int[] { 3, 6, 7, 11 }, 8);
		new KokoEatingBananas().minEatingSpeed(new int[] { 30, 11, 23, 4, 20 }, 6);
		new KokoEatingBananas().minEatingSpeed(new int[] { 30, 11, 23, 4, 20 }, 5);

	}

}
