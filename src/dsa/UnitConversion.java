package dsa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

class ConversionRates {
	String from;
	String to;
	double rate;

	ConversionRates(String from, String to, double rate) {
		this.from = from;
		this.to = to;
		this.rate = rate;
	}

}

public class UnitConversion {

	private static Map<String, Map<String, Double>> rates = new HashMap<>();

	public static void main(String[] args) {
		readFile("conversion.log");
		System.out.println(rates);
		System.out.println(answerQueuries("meters", "centimeters", 10.0));
		System.out.println(answerQueuries("meters", "feet", 2.0));

	}

	private static void readFile(String fileName) {
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] rates = line.replaceAll("[{}\"]", "").split(", ");
				addRates(new ConversionRates(rates[0].split(":")[1], rates[1].split(":")[1],
						Double.parseDouble(rates[2].split(":")[1])));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void addRates(ConversionRates conversionRates) {
		rates.computeIfAbsent(conversionRates.from, k -> new HashMap<>()).put(conversionRates.to, conversionRates.rate);
		rates.computeIfAbsent(conversionRates.to, k -> new HashMap<>()).put(conversionRates.from,
				1 / conversionRates.rate);
	}

	private static double answerQueuries(String from, String to, Double amount) {
		if (rates.containsKey(from) && rates.get(from).containsKey(to)) {
			return amount * rates.get(from).get(to);
		}

		for (String intermediaryUnit : rates.get(from).keySet()) {
			if (rates.containsKey(intermediaryUnit) && rates.get(intermediaryUnit).containsKey(to)) {
				double toIntermediary = rates.get(from).get(intermediaryUnit);
				double toFinal = rates.get(intermediaryUnit).get(to);
				return amount * toIntermediary * toFinal;
			}
		}
		throw new IllegalArgumentException("Cannot convert :" + from + " to " + to);
	}

}

class Solution {
	static class Rate {
		String fromCurrency;
		String toCurrency;
		double amount;

		public Rate(String fromCurrency, String toCurrency, double amount) {
			this.fromCurrency = fromCurrency;
			this.toCurrency = toCurrency;
			this.amount = amount;
		}
	}

	private static class Edge implements Comparable<Edge> {
		String currency;
		String parent;
		double cost;

		public Edge(String parent, String currency, double cost) {
			this.currency = currency;
			this.parent = parent;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			if (this.cost == o.cost) {
				return 1;
			} else {
				return Double.compare(this.cost, o.cost);
			}
		}
	}

	HashMap<String, HashMap<String, Double>> graph = new HashMap<>();

	public double solve(List<Rate> rates, String from, String to) {

		buildGraph(rates);

		if (!graph.containsKey(from)) {
			return -1;
		}

		Queue<Edge> queue = new PriorityQueue<>();

		queue.add(new Edge(null, from, 1.0));

		Map<String, Double> vs = new HashMap<>();

		Map<String, String> parent = new HashMap<>();

		parent.put(from, from);
		while (!queue.isEmpty()) {

			Edge edge = queue.poll();
			String top = edge.currency;

			if (vs.containsKey(top) && vs.get(top) < edge.cost) {
				continue;
			}

			vs.put(top, edge.cost);
			parent.put(top, edge.parent);
			graph.get(from).put(top, edge.cost);

			for (var dest : graph.get(top).entrySet()) {
				double rate = graph.get(from).get(top) * dest.getValue();

				if (vs.containsKey(dest.getKey()) && vs.get(dest.getKey()) >= rate || dest.getKey().equals(from)) {
					continue;
				}
				queue.add(new Edge(top, dest.getKey(), rate));
			}
		}

		if (!graph.get(from).containsKey(to)) {
			return -1;
		}

		System.out.println(getPath(parent, from, to));
		return graph.get(from).get(to);
	}

	private String getPath(Map<String, String> parent, String from, String to) {
		String current = to;
		System.out.println(current);
		Stack<String> res = new Stack<>();
		res.add(to);
		while (!parent.get(current).equals(from)) {
			current = parent.get(current);
			res.add(current);
		}

		StringBuilder stringBuilder = new StringBuilder();
		res.add(from);

		while (res.size() != 0) {

			stringBuilder.append(res.pop());
			if (res.size() > 0) {
				stringBuilder.append(" -> ");
			}
		}
		return stringBuilder.toString();
	}

	private void buildGraph(List<Rate> rates) {

		for (Rate rate : rates) {
			if (!graph.containsKey(rate.fromCurrency)) {
				graph.put(rate.fromCurrency, new HashMap<>());
			}

			graph.get(rate.fromCurrency).put(rate.fromCurrency, 1.0);

			graph.get(rate.fromCurrency).put(rate.toCurrency, rate.amount);
		}

		for (Rate rate : rates) {
			for (var val : graph.get(rate.fromCurrency).entrySet()) {
				if (!graph.containsKey(val.getKey())) {
					graph.put(val.getKey(), new HashMap<>());
				}

				graph.get(val.getKey()).put(val.getKey(), 1.0);

				if (!graph.get(val.getKey()).containsKey(rate.fromCurrency)) {
					graph.get(val.getKey()).put(rate.fromCurrency, 1.0 / val.getValue());
				}
			}
		}
	}

}

class Main {
	public static void main(String[] args) {

		Solution solution = new Solution();

		List<Solution.Rate> rates = List.of(new Solution.Rate("USD", "JPY", 110), new Solution.Rate("USD", "AUD", 1),
				new Solution.Rate("AUD", "MOS", 4), new Solution.Rate("MOS", "JPY", 2));

		String from = "USD";
		String to = "JPY";

		double result = solution.solve(rates, from, to);

		System.out.println(result);
	}
}
