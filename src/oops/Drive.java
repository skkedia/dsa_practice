package oops;


class Parent {
	
	protected void show() {
		System.out.println("I am parent");
	}
}


class Child extends Parent {
	
	@Override
	protected void show() {
		System.out.println("I am child");
	}
}






public class Drive {

	public static void main(String[] args) {
		Parent c = new Parent();
		c.show();
		
	}

}
