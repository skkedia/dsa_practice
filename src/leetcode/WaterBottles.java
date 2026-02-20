package leetcode;

public class WaterBottles {

	public int numWaterBottles(int numBottles, int numExchange) {
		int ans = numBottles;
		while (numBottles >= numExchange) {
			int drinkable = numBottles / numExchange;
			ans += drinkable;
			drinkable += numBottles % numExchange;
			numBottles = drinkable;
		}

		return ans;

	}

	public int numWaterBottles1(int numBottles, int numExchange) {
		int ans = 0;
		int empty = 0;
		while (numBottles > 0) {
			ans += numBottles;
			empty = empty + numBottles;
			numBottles = empty / numExchange;
			empty = empty % numExchange;
		}
		return ans + numBottles;
	}

	public static void main(String[] args) {
		System.out.println(new WaterBottles().numWaterBottles1(40, 4));
	}

}
