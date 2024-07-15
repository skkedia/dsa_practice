package dsa_practice;

@FunctionalInterface
// A functional interface contains only single abstract method. It can contain any number of default or static methods.
public interface IFunctional {

	public void there();

	static void here() {
	};

	default void where() {

	}
}
