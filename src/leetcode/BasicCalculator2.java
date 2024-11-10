package leetcode;

public class BasicCalculator2 {

	public int calculate(String s) {
		int curNum = 0;
		int lastNum = 0;
		int result = 0;
		char op = '+';
		for (int i = 0; i < s.length(); i++) {
			char temp = s.charAt(i);
			if (Character.isDigit(temp)) {
				curNum = curNum * 10 + (temp - '0');
			}
			if (!Character.isDigit(temp) && !Character.isWhitespace(temp) || i == s.length() - 1) {
				if (op == '+') {
					result += lastNum;
					lastNum = curNum;
				} else if (op == '-') {
					result += lastNum;
					lastNum = -curNum;
				} else if (op == '*')
					lastNum = lastNum * curNum;
				else if (op == '/')
					lastNum = lastNum / curNum;
				op = temp;
				curNum = 0;
			}
		}
		result += lastNum;
		return result;

	}

	public static void main(String[] args) {
		System.out.println(new BasicCalculator2().calculate("3+2*2"));
	}
}
