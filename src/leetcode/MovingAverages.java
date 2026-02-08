package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverages {

	class MovingAverage {

		Queue<Integer> stream;
		double sum;
		int size;

		public MovingAverage(int size) {
			stream = new LinkedList<>();
			this.sum = 0d;
			this.size = size;
		}

		public double next(int val) {
			this.sum += val;
			if (stream.size() > size) {
				this.sum = this.sum - stream.poll();
			}
			stream.offer(val);
			return this.sum / stream.size();
		}
	}

	public static void main(String[] args) {
		MovingAverage movingAverage = new MovingAverages().new MovingAverage(3);
		movingAverage.next(1); // return 1.0 = 1 / 1
		movingAverage.next(10); // return 5.5 = (1 + 10) / 2
		movingAverage.next(3); // return 4.66667 = (1 + 10 + 3) / 3
		movingAverage.next(5); // return 6.0 = (10 + 3 + 5) / 3
	}

}
