package creational;

class Singleton {

	private static Singleton s = null;

	private Singleton() {
		if (s != null) {
			throw new RuntimeException();
		}
	}

	public static Singleton getInstance() {
		if (s == null) {
			synchronized (Singleton.class) {
				if (s == null)
					s = new Singleton();
			}
		}
		return s;
	}

}
