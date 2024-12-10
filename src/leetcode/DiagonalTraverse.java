package leetcode;

public class DiagonalTraverse {

	public int[] findDiagonalOrder(int[][] matrix) {
		int i = 0;
		int j = 0;
		int m = matrix.length;
		int n = matrix[0].length;
		int[] ans = new int[m * n];
		int k = 0;
		while (i >= 0 && j >= 0 && i < m && j < n) {
			ans[k++] = matrix[i][j];

			while (i - 1 >= 0 && j + 1 < n) {
				ans[k++] = matrix[i--][j++];
			}

			while (i + 1 < m && j - 1 >= 0) {
				ans[k++] = matrix[i++][j--];
			}
			i++;
			j++;

		}
		return ans;
	}

	public static void main(String[] args) {
		System.out.println(
				new DiagonalTraverse().findDiagonalOrder(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }));

	}

}
