package leetcode;

public class AddBinary {


    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        char carry = '0';

        a = new StringBuilder(a).reverse().toString();
        b = new StringBuilder(b).reverse().toString();

        int n = a.length();
        int m = b.length();

        int i = 0;
        int j = 0;

        while (i < n || j < m) {
            char x = i < n ? a.charAt(i) : '0';
            char y = j < m ? b.charAt(j) : '0';
            char add = '\0';
            if ((x == '0' && y == '1') || (x == '1' && y == '0')) {
                if (carry == '1') {
                    add = '0';
                } else {
                    add = '1';
                }
            } else if (x == '0' && y == '0') {
                if (carry == '1') {
                    add = '1';
                    carry = '0';
                } else {
                    add = '0';
                }
            } else if (x == '1' && y == '1') {
                if (carry == '1') {
                    add = '1';
                } else {
                    add = '0';
                    carry = '1';
                }
            }
            i++;
            j++;
            sb.append(add);
        }
        if (carry == '1') {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        AddBinary addBinary = new AddBinary();
        System.out.println(addBinary.addBinary("11", "1"));
    }

}
