package lld;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

//Product Model
class Product {
	private String name;
	private String brand;
	private double price;
	private double rating;
	private int categoryId;

	public Product(String name, String brand, double price, double rating, int categoryId) {
		this.name = name;
		this.brand = brand;
		this.price = price;
		this.rating = rating;
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public String getBrand() {
		return brand;
	}

	public double getPrice() {
		return price;
	}

	public double getRating() {
		return rating;
	}

	public int getCategoryId() {
		return categoryId;
	}
}

//Strategy Interfaces
interface ProductFilterStrategy {
	List<Product> filter(List<Product> products, String filterValue);
}

interface ProductSortStrategy {
	List<Product> sort(List<Product> products, String order);
}

//Filtering Strategies
class BrandFilterStrategy implements ProductFilterStrategy {
	public List<Product> filter(List<Product> products, String brand) {
		if (brand == null || brand.isEmpty())
			return products;
		List<Product> result = new ArrayList<>();
		for (Product p : products) {
			if (p.getBrand().equalsIgnoreCase(brand))
				result.add(p);
		}
		return result;
	}
}

//Sorting Strategies
class PriceSortStrategy implements ProductSortStrategy {
	public List<Product> sort(List<Product> products, String order) {
		products.sort(order.equalsIgnoreCase("asc") ? Comparator.comparingDouble(Product::getPrice)
				: Comparator.comparingDouble(Product::getPrice).reversed());
		return products;
	}
}

class RatingSortStrategy implements ProductSortStrategy {
	public List<Product> sort(List<Product> products, String order) {
		products.sort(order.equalsIgnoreCase("asc") ? Comparator.comparingDouble(Product::getRating)
				: Comparator.comparingDouble(Product::getRating).reversed());
		return products;
	}
}

//Product Service with Strategy Pattern
class ProductService {
	private Map<String, ProductFilterStrategy> filterStrategies = new HashMap<>();
	private Map<String, ProductSortStrategy> sortStrategies = new HashMap<>();
	private List<Product> products;

	public ProductService(List<Product> products) {
		this.products = products;
		filterStrategies.put("brand", new BrandFilterStrategy());
		sortStrategies.put("price", new PriceSortStrategy());
		sortStrategies.put("rating", new RatingSortStrategy());
	}

	public List<Product> getProducts(int categoryId, String filterType, String filterValue, String sortType,
			String order) {
		List<Product> filtered = new ArrayList<>();
		for (Product p : products) {
			if (p.getCategoryId() == categoryId)
				filtered.add(p);
		}
		if (filterStrategies.containsKey(filterType))
			filtered = filterStrategies.get(filterType).filter(filtered, filterValue);
		if (sortStrategies.containsKey(sortType))
			filtered = sortStrategies.get(sortType).sort(filtered, order);
		return filtered;
	}
}

//Main Class
public class ECommerceAPI {
	public static void main(String[] args) {
		List<Product> products = Arrays.asList(new Product("Laptop", "Dell", 800, 4.5, 1),
				new Product("Phone", "Apple", 1200, 4.8, 1), new Product("Laptop", "HP", 700, 4.3, 1),
				new Product("Tablet", "Samsung", 300, 4.0, 2));

		ProductService productService = new ProductService(products);
		List<Product> result = productService.getProducts(1, "brand", "Dell", "price", "asc");

		for (Product p : result) {
			System.out.println(p.getBrand() + " - $" + p.getPrice());
		}
	}
}

//Write a library that determines a winner in a fake card game called ComboBreaker.
//The game consists of 30 cards, where each card has a Value which is a number between 0-9 and a Color which is Red, Green, or Blue (RGB)
//Each player gets 3 cards
//Each game consists of some number of players, and winners are determined by who has the best Combo in the following order:
//Color Combo (3 cards same color)
//Value Combo (3 cards same value)
//Pair Combo (2 cards with same value, and 1 random card)
//etc. (there are many possibilities and it's not important to know all of them now)
//
//Write the library required to play this game.
//Don't worry about UI or getters/setters/constructors, or implementing every method, just draw out what you need and who will call what,
//and we will dive deeper into the interesting areas.-

//A - RRR-> 1,2,9 -> 
//B - RRR-> 4,5,9 -> 

//R->G->B

class Player {
	String name;
	List<Card> cards;

}

class GameHand {

	int noOfPlayer;
	Deque<Player> players;

	DealerService service;

	public void dealCard() {
//   while() {
//       service.dealCard();
//   }

	}

	public List<Player> getWinner() {

//   List<WinningStrategy> strategies = new ArrayList<>()p;
//   
//   strategioes.add(WinningStrategy combio = new ColorCombo());
//   strategioes.add(WinningStrategy combio = new ColorCombo());
//   strategioes.add(WinningStrategy combio = new ColorCombo());
//   
//   List<Players> player;
//   for(WinnerStra  strategy : strategioes) {
//       player = strategy.getWinner();
//       if(!player.isEmpty()) {
//           break;
//       }
//   }
		return null;

	}
}

interface WinningStrategy {
	public List<Player> getWinner(List<Player> player);
}

class CompositeCondition {

	public List<Player> getWinner(List<Player> player) {
		// List<Player> list = getWinner();
		return null;

	}

}

class ColorCombo implements WinningStrategy {

	public List<Player> getWinner(List<Player> player) {
		List<Player> winners = new ArrayList<>();
//   for(Player player : player) {
//       int number = player.getCards().get(0);
//       int preNumber = 0;
//       
//       for(int i = 1; i < player.getCards().size(); i++) {
//           if(player.getCard().get(i).COLOR() != number) {
//               break;   
//           }
//       }
//   }
		return null;

	}
}

class ValueCombo implements WinningStrategy {
	public List<Player> getWinner(List<Player> player) {
//		List<Player> winners = new ArrayList<>();
//		for (Player player : player) {
//			int number = player.getCards().get(0);
//			int preNumber = 0;
//
//			for (int i = 1; i < player.getCards().size(); i++) {
//				if (player.getCard().get(i).getNumber() != number) {
//					break;
//				}
//			}
//		}
		return null;
	}
}

class PairCombo implements WinningStrategy {

	@Override
	public List<Player> getWinner(List<Player> player) {
		return null;
	}

}

class DealerService {
	Set<Card> set;

	public Card dealCard() {
		return null;
	}
}

class Card {
	Color color;
	int number;
}

enum Color {
	RED, BLUE, GREEN;
}
