package leetcode;

public class LemonadeChange {
	public boolean lemonadeChange(int[] bills) {
		int c5 = 0;
		int c10 = 0;
		for (int i : bills) {
			if (i == 5) {
				c5++;
			} else if (i == 10) {
				if (c5 == 0 || c5 < 1)
					return false;
				c10++;
				c5--;
			} else if (i == 20) {
				if (c5 == 0 || c5 < 1)
					return false;
				if (c10 > 0) {
					c10--;
					c5--;
				} else if (c5 > 2) {
					c5 = c5 - 3;
				} else {
					return false;
				}
			}
		}
		return true;
	}

}
