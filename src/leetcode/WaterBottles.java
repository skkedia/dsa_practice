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

	public static void main(String[] args) {
		System.out.println(new WaterBottles().numWaterBottles(9, 3));
	}

}
