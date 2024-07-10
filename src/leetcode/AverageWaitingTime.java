package leetcode;

public class AverageWaitingTime {

	public double averageWaitingTime(int[][] customers) {
		double waitTime = 0;
		double finishTime = 0;
		for (int[] customer : customers) {
			finishTime = Math.max(customer[0], finishTime) + customer[1];
			waitTime += (finishTime - customer[0]);
		}
		return waitTime / customers.length;

	}

	public static void main(String[] args) {
		new AverageWaitingTime().averageWaitingTime(new int[][] { { 5, 2 }, { 5, 4 }, { 10, 3 }, { 20, 1 } });
		new AverageWaitingTime().averageWaitingTime(new int[][] { { 1, 2 }, { 2, 5 }, { 4, 3 } });

	}

}
