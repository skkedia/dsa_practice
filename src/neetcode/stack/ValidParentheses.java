package stack;

public class ValidParentheses {

	public boolean isValid(String s) {

		char[] arr = new char[s.length()];
		int i = -1;
		for (Character c : s.toCharArray()) {
			if (c == '(' || c == '{' || c == '[') {
				arr[++i] = c;
			} else if (i > -1) {
				if (c == ')' && arr[i] != '(') {
					return false;
				} else if (c == '}' && arr[i] != '{') {
					return false;
				} else if (c == ']' && arr[i] != '[') {
					return false;
				} else {
					arr[i--] = '\0';
				}
			} else {
				return false;
			}
		}
		return i == -1;
	}

	public static void main(String[] args) {
		ValidParentheses vp = new ValidParentheses();
		vp.isValid("()");
	}


}
