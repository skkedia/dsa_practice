package dsa_practice;

class Parent {
	public void sample() {
		System.out.println("hi parent");
	}
}

class Child extends Parent {
	@Override
	public void sample() {
		System.out.println("hi child");
	}
}

public class Inheritance {

	public static void main(String[] args) {
		Child c = new Child();
		c.sample();
		Parent p = new Parent();
		p.sample();
		Parent pc = new Child();
		pc.sample();
	}

}
