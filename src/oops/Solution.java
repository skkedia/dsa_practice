package oops;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

interface Drink {
	int getPrice();

	String getName();

	int getQuantityLeft();

	void serveDrink();
}

class ServeDrinkSummary {
	Drink servedDrink;
	int change;
}

class OutOfStockException extends Exception {
	public OutOfStockException(String message) {
		super(message);
	}
}

class InsufficientMoneyException extends Exception {
	public InsufficientMoneyException() {
		super();
	}
}

class VendingMachine {
	// private Map<Integer, List<Drink>> stock = new HashMap<>();
	private Map<Integer, Drink> stock = new HashMap<>();
	private Map<Integer, String> stockName = new HashMap<>();

	void registerDrink(int buttonIdx, Drink drink) {
		// if(stock.get(buttonIdx) == null) {
		// stock.put(buttonIdx, new ArrayList<Drink>());
		// }

		stock.put(buttonIdx, drink);
		stockName.put(buttonIdx, drink.getName());
		// System.out.println("42 : " + stock);
	}

	ServeDrinkSummary dispatch(int buttonPressed, int money) throws OutOfStockException, InsufficientMoneyException {

		if (!stock.containsKey(buttonPressed) || stock.get(buttonPressed) == null
				|| stock.get(buttonPressed).getQuantityLeft() <= 0) {
			throw new OutOfStockException(stockName.get(buttonPressed) + " is out of stock");
		}
		if (stock.get(buttonPressed).getPrice() > money) {
			throw new InsufficientMoneyException();
		}

		ServeDrinkSummary drink = new ServeDrinkSummary();
		// stock.get(buttonPressed).serveDrink();
		drink.servedDrink = stock.get(buttonPressed);
		drink.change = money - stock.get(buttonPressed).getPrice();
		// System.out.println(stock);
		return drink;
	}
}

class Solution {

	public static void main(String[] args) throws IOException {
		int arr[];
		int quantity[] = new int[3], pricePerUnit[] = new int[3], buttonAssigned[] = new int[3];

		/**
		 * 2 0 0 4 2 3 2 0 1 4 2 4 2 3 2 5 2 3
		 * 
		 */
		Integer i = 0;

		String s = String.valueOf(i.intValue());

		quantity[0] = 2;
		quantity[1] = 0;
		quantity[2] = 0;

		pricePerUnit[0] = 4;
		pricePerUnit[1] = 2;
		pricePerUnit[2] = 3;

		buttonAssigned[0] = 2;
		buttonAssigned[1] = 0;
		buttonAssigned[2] = 1;

		VendingMachine vendingMachine = new VendingMachine();
		Drink coke = new Coke(pricePerUnit[0], "Coke", quantity[0]);
		Drink fanta = new Fanta(pricePerUnit[1], "Fanta", quantity[1]);
		Drink sprite = new Sprite(pricePerUnit[2], "Sprite", quantity[2]);
		vendingMachine.registerDrink(buttonAssigned[0], coke);
		vendingMachine.registerDrink(buttonAssigned[1], fanta);
		vendingMachine.registerDrink(buttonAssigned[2], sprite);
		System.out.println("Vending machine set up");

		int[][] req = new int[][] { { 2, 4 }, { 2, 3 }, { 2, 5 }, { 2, 3 } };

		int totalNumberOfRequests = 4;
		int idd = 0;
		while (totalNumberOfRequests-- > 0) {
			arr = req[i++];
			int buttonPressed = arr[0], money = arr[1];
			try {
				ServeDrinkSummary serveDrinkSummary = vendingMachine.dispatch(buttonPressed, money);
				serveDrinkSummary.servedDrink.serveDrink();
				System.out.println(serveDrinkSummary.servedDrink.getName() + " " + serveDrinkSummary.change);
			} catch (OutOfStockException e) {
				System.out.println(e.getMessage());
			} catch (InsufficientMoneyException e) {
				System.out.println("Insufficient money");
			}
		}
	}
}

class Coke implements Drink {
	private int price;
	private String name;
	private int quantityLeft;

	public Coke(int price, String name, int quantityLeft) {
		this.price = price;
		this.name = name;
		this.quantityLeft = quantityLeft;
	}

	public int getPrice() {
		return this.price;
	}

	public String getName() {
		return this.name;
	}

	public int getQuantityLeft() {
		return this.quantityLeft;
	}

	public void serveDrink() {
		if (this.quantityLeft > 0)
			this.quantityLeft -= 1;
	}
}

class Fanta implements Drink {
	private int price;
	private String name;
	private int quantityLeft;

	public Fanta(int price, String name, int quantityLeft) {
		this.price = price;
		this.name = name;
		this.quantityLeft = quantityLeft;
	}

	public int getPrice() {
		return this.price;
	}

	public String getName() {
		return this.name;
	}

	public int getQuantityLeft() {
		return this.quantityLeft;
	}

	public void serveDrink() {
		if (this.quantityLeft > 0)
			this.quantityLeft -= 1;
	}
}

class Sprite implements Drink {
	private int price;
	private String name;
	private int quantityLeft;

	public Sprite(int price, String name, int quantityLeft) {
		this.price = price;
		this.name = name;
		this.quantityLeft = quantityLeft;
	}

	public int getPrice() {
		return this.price;
	}

	public String getName() {
		return this.name;
	}

	public int getQuantityLeft() {
		return this.quantityLeft;
	}

	public void serveDrink() {
		if (this.quantityLeft > 0)
			this.quantityLeft -= 1;
	}
}

/**
 * import java.io.*; import java.util.*; import java.text.*; import java.math.*;
 * import java.util.regex.*;
 * 
 * interface Drink{ int getPrice(); String getName(); int getQuantityLeft();
 * void serveDrink(); }
 * 
 * class ServeDrinkSummary{ Drink servedDrink; int change; }
 * 
 * class OutOfStockException extends Exception{ public
 * OutOfStockException(String message){ super(message); } }
 * 
 * class InsufficientMoneyException extends Exception{ public
 * InsufficientMoneyException(){ super(); } }
 * 
 * class VendingMachine{ //private Map<Integer, List<Drink>> stock = new
 * HashMap<>(); private Map<Integer, Drink> stock = new HashMap<>(); private
 * Map<Integer, String> stockName = new HashMap<>();
 * 
 * void registerDrink(int buttonIdx, Drink drink){ // if(stock.get(buttonIdx) ==
 * null) { // stock.put(buttonIdx, new ArrayList<Drink>()); // }
 * 
 * stock.put(buttonIdx, drink); stockName.put(buttonIdx, drink.getName());
 * //System.out.println("42 : " + stock); }
 * 
 * ServeDrinkSummary dispatch(int buttonPressed, int money) throws
 * OutOfStockException, InsufficientMoneyException {
 * 
 * if(!stock.containsKey(buttonPressed) || stock.get(buttonPressed) == null ||
 * stock.get(buttonPressed).getQuantityLeft() <= 0) { throw new
 * OutOfStockException(stockName.get(buttonPressed) + " is out of stock"); }
 * if(stock.get(buttonPressed).getPrice() > money) { throw new
 * InsufficientMoneyException(); }
 * 
 * ServeDrinkSummary drink = new ServeDrinkSummary();
 * stock.get(buttonPressed).serveDrink(); drink.servedDrink =
 * stock.get(buttonPressed); drink.change = money -
 * stock.get(buttonPressed).getPrice(); System.out.println(stock); return drink;
 * } }
 * 
 * class Solution{
 * 
 * public static void main(String[] args) throws IOException{ String arr[]; int
 * quantity[] = new int[3], pricePerUnit[] = new int[3], buttonAssigned[] = new
 * int[3];
 * 
 * BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 * PrintWriter out = new PrintWriter(System.out);
 * 
 * arr = br.readLine().split(" "); for(int i = 0; i < 3; i++){ quantity[i] =
 * Integer.parseInt(arr[i]); }
 * 
 * arr = br.readLine().split(" "); for(int i = 0; i < 3; i++){ pricePerUnit[i] =
 * Integer.parseInt(arr[i]); }
 * 
 * arr = br.readLine().split(" "); for(int i = 0; i < 3; i++){ buttonAssigned[i]
 * = Integer.parseInt(arr[i]); }
 * 
 * VendingMachine vendingMachine = new VendingMachine(); Drink coke = new
 * Coke(pricePerUnit[0], "Coke", quantity[0]); Drink fanta = new
 * Fanta(pricePerUnit[1], "Fanta", quantity[1]); Drink sprite = new
 * Sprite(pricePerUnit[2], "Sprite", quantity[2]);
 * vendingMachine.registerDrink(buttonAssigned[0], coke);
 * vendingMachine.registerDrink(buttonAssigned[1], fanta);
 * vendingMachine.registerDrink(buttonAssigned[2], sprite); out.println("Vending
 * machine set up");
 * 
 * int totalNumberOfRequests = Integer.parseInt(br.readLine().trim());
 * while(totalNumberOfRequests-- > 0){ arr = br.readLine().split(" "); int
 * buttonPressed = Integer.parseInt(arr[0]), money = Integer.parseInt(arr[1]);
 * try{ ServeDrinkSummary serveDrinkSummary =
 * vendingMachine.dispatch(buttonPressed, money);
 * serveDrinkSummary.servedDrink.serveDrink();
 * out.println(serveDrinkSummary.servedDrink.getName() + " " +
 * serveDrinkSummary.change); }catch(OutOfStockException e){
 * out.println(e.getMessage()); }catch(InsufficientMoneyException e){
 * out.println("Insufficient money"); } }
 * 
 * out.flush(); out.close(); } }
 * 
 * class Coke implements Drink{ private int price; private String name; private
 * int quantityLeft;
 * 
 * public Coke(int price, String name, int quantityLeft){ this.price = price;
 * this.name = name; this.quantityLeft = quantityLeft; }
 * 
 * public int getPrice(){ return this.price; }
 * 
 * public String getName(){ return this.name; }
 * 
 * public int getQuantityLeft(){ return this.quantityLeft; }
 * 
 * public void serveDrink(){ if(this.quantityLeft > 0) this.quantityLeft -= 1; }
 * }
 * 
 * class Fanta implements Drink{ private int price; private String name; private
 * int quantityLeft;
 * 
 * public Fanta(int price, String name, int quantityLeft){ this.price = price;
 * this.name = name; this.quantityLeft = quantityLeft; }
 * 
 * public int getPrice(){ return this.price; }
 * 
 * public String getName(){ return this.name; }
 * 
 * public int getQuantityLeft(){ return this.quantityLeft; }
 * 
 * public void serveDrink(){ if(this.quantityLeft > 0) this.quantityLeft -= 1; }
 * }
 * 
 * class Sprite implements Drink{ private int price; private String name;
 * private int quantityLeft;
 * 
 * public Sprite(int price, String name, int quantityLeft){ this.price = price;
 * this.name = name; this.quantityLeft = quantityLeft; }
 * 
 * public int getPrice(){ return this.price; }
 * 
 * public String getName(){ return this.name; }
 * 
 * public int getQuantityLeft(){ return this.quantityLeft; }
 * 
 * public void serveDrink(){ if(this.quantityLeft > 0) this.quantityLeft -= 1; }
 * }
 * 
 */
