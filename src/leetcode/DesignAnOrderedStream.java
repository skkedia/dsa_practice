package leetcode;

import java.util.ArrayList;
import java.util.List;

public class DesignAnOrderedStream {

	class OrderedStream {

		List<String> stream;
		int k = 1;

		public OrderedStream(int n) {
			stream = new ArrayList<>();
			for (int i = 0; i <= n; i++) {
				stream.add("");
			}
			k = 1;
		}

		public List<String> insert(int idKey, String value) {
			stream.set(idKey, value);
			if (idKey == k) {
				List<String> ans = new ArrayList<>();
				while (k <= stream.size() && !stream.get(k).equals("")) {
					ans.add(stream.get(k));
					k++;
				}
				return ans;
			}
			return new ArrayList<>();
		}
	}

	public static void main(String[] args) {
		OrderedStream os = new DesignAnOrderedStream().new OrderedStream(5);
		os.insert(3, "ccccc"); // Inserts (3, "ccccc"), returns [].
		os.insert(1, "aaaaa"); // Inserts (1, "aaaaa"), returns ["aaaaa"].
		os.insert(2, "bbbbb"); // Inserts (2, "bbbbb"), returns ["bbbbb", "ccccc"].
		os.insert(5, "eeeee"); // Inserts (5, "eeeee"), returns [].
		os.insert(4, "ddddd");

	}

}
