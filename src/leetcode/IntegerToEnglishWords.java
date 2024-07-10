package leetcode;

public class IntegerToEnglishWords {

	String[] vals = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven",
			"Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen", "Twenty" };
	String[] TENS = { "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };
	String[] THOUSANDS = { "", "Thousand", "Million", "Billion" };

	public String numberToWords(int num) {
		if (num == 0)
			return "Zero";
		if (num < 21)
			return vals[num];
		String ans = "";
		int i = 0;
		while (num > 0) {
			if (num % 1000 != 0) {
				ans = findString(num % 1000) + THOUSANDS[i] + " " + ans;
			}
			num = num / 1000;
			i++;
		}
		return ans.trim();
	}

	private String findString(int num) {
		if (num == 0) {
			return "";
		} else if (num < 20) {
			return vals[num] + " ";
		} else if (num < 100) {
			return TENS[num / 10] + " " + findString(num % 10);
		} else {
			return vals[num / 100] + " Hundred " + findString(num % 100);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
