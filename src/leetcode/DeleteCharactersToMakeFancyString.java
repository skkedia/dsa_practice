package leetcode;

public class DeleteCharactersToMakeFancyString {

    public String makeFancyString(String s) {
        if (s.length() < 3)
            return s;
        int k = 2;
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0)).append(s.charAt(1));

        while (k < s.length()) {
            if ((sb.charAt(sb.length() - 1) == s.charAt(k))
                    || (sb.charAt(sb.length() - 2) == s.charAt(k))) {
                k++;
            } else {
                sb.append(s.charAt(k++));
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {

    }

}
