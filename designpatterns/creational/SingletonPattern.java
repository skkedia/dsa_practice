package creational;

class SingletonPattern {

	private static SingletonPattern s = null;

	private SingletonPattern() {
		if (s != null) {
			throw new RuntimeException();
		}
	}

	public static SingletonPattern getInstance() {
		if (s == null) {
			synchronized (SingletonPattern.class) {
				if (s == null)
					s = new SingletonPattern();
			}
		}
		return s;
	}

	public static void main(String[] args) {
		SingletonPattern ss = SingletonPattern.getInstance();
		System.out.println(ss);
	}

}
