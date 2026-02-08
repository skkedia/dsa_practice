package leetcode;

public class SwapAdjacentinLRString {

	public boolean canTransform(String start, String result) {
		int sidx = 0;
		int ridx = 0;
		int len = start.length();

		while (sidx < len || ridx < len) {

			while (sidx < len && start.charAt(sidx) == 'X') {
				sidx++;
			}

			while (ridx < len && result.charAt(ridx) == 'X') {
				ridx++;
			}

			if (ridx == len || sidx == len)
				return ridx == len && sidx == len;

			if (start.charAt(sidx) != result.charAt(ridx) || (start.charAt(sidx) == 'L' && sidx < ridx)
					|| (start.charAt(sidx) == 'R' && ridx < sidx)) {
				return false;
			}
			sidx++;
			ridx++;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(new SwapAdjacentinLRString().canTransform("RXXLRXRXL", "XRLXXRRLX"));
	}

}
