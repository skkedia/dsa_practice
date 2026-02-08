package lld;

import java.util.List;

public class InventoryManagementsystem {

	public static void main(String[] args) {

	}

	class Product {

		int productId;
		String name;
		Double rating;

	}

	class Item extends Product {
		int qty;
		int price;
		List<Shelf> locations;

	}

	class WareHouse {
		int WareHouseid;
		WareHouseLocation location;
		String name;
		List<Item> items;
		List<Shelf> shelfLocations;
	}

	class Shelf {
		int row;
		int col;
		int level;

	}

	class WareHouseLocation {
		Double longi;
		Double lati;
		String streetName;
		String pincode;
	}

	abstract class User {
		String name;
		String email;
		String passwordHash;

	}

	interface ProductActions {
		void addproducts();

		void removeProducts();

		void changePrice(int itemId, Double price);
	}

	enum UserType {
		ADMIN, MANAGER, CUSTOMER;
	}

	interface WareHouseActions {
		void addWareHouse(WareHouse wareHouse);

		void removeWareHouse(int wareHouseId);
	}

	class Admin extends User implements ProductActions, WareHouseActions {
		UserType type = UserType.ADMIN;

		public void addWareHouse(WareHouse wareHouse) {
		};

		public void removeWareHouse(int wareHouseId) {
		};

		public void addproducts() {
		};

		public void removeProducts() {
		};

		public void changePrice(int itemId, Double price) {
		}

	}

	class Inventorymanager extends User implements ProductActions {
		UserType type = UserType.MANAGER;

		public void addproducts() {
		};

		public void removeProducts() {
		};

		public void changePrice(int itemId, Double price) {
		};
	}

	class Customer extends User {
		UserType type = UserType.CUSTOMER;

		void placeOrders() {
		}

	}

	class InventoryService {

	}

}

/**
 * 
 * Inventory management System
 * 
 * add/remove products from the inventory add/remove location/space from the
 * inventory
 * 
 * transport responsoible for shipping
 * 
 * Actors - Admin, invenorry manager, customer
 * 
 * 
 */
