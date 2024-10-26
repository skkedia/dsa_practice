package leetcode;

public class FindTheEncryptedString {

    public String getEncryptedString(String s, int k) {
        char[] seq = s.toCharArray();

        char[] arr = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            arr[i] = seq[(i + k - 1) % seq.length];
        }

        return new String(arr);

    }

    public static void main(String[] args) {

    }

}
