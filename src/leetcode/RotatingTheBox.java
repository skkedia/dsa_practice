package leetcode;

import java.util.Arrays;

public class RotatingTheBox {

	public char[][] rotateTheBox(char[][] box) {
		char[][] ans = new char[box[0].length][box.length];
		int m = 0;

		while (m < box.length) {
			int n = box[m].length - 1;
			int j = box[m].length - 1;
			while (n >= 0) {
				if (box[m][n] == '*') {
					j = n - 1;
				}
				if (box[m][n] == '#') {
					box[m][n] = '.';
					box[m][j] = '#';
					j = j - 1;
				}
				n--;
			}
			m++;
		}
		int k = box.length;
		for (int i = 0; i < ans.length; i++) {
			for (int j = 0; j < ans[i].length; j++) {
				ans[i][j] = box[k - 1 - j][i];
			}
		}
		for (char[] an : ans) {
			System.out.println(Arrays.toString(an));
		}
		return ans;
	}

	public static void main(String[] args) {
		new RotatingTheBox().rotateTheBox(new char[][] { { '#', '#', '*', '.', '*', '.' },
				{ '#', '#', '#', '*', '.', '.' }, { '#', '#', '#', '.', '#', '.' } });
		new RotatingTheBox().rotateTheBox(new char[][] { { '#', '.', '#' } });
		new RotatingTheBox().rotateTheBox(new char[][] { { '#', '.', '*', '.' }, { '#', '#', '*', '.' } });

	}

}
