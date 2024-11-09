package leetcode;

public class ReachingPoints {

	// (x, x + y) or (x + y, y)

	public boolean reachingPoints(int sx, int sy, int tx, int ty) {
		while (!(sx == tx && sy == ty)) {
			if (sx > tx || sy > ty) {
				return false;
			}
			if (tx > ty) {
				if ((tx % ty == sx % ty) && ty == sy) { // checking mid steps
					return true;
				} else {
					tx = tx % ty; // <- important
				}
			} else {
				if ((ty % tx == sy % tx) && tx == sx) { // checking mid steps
					return true;
				} else {
					ty = ty % tx; // <- important
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {

	}

}
