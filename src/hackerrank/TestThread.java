package hackerrank;

class SampleDemo implements Runnable {
	
	private Thread thread;
	private String name;
	
	SampleDemo(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		while(true) {
			System.out.print(name);
		}
	}
	
	public void start() {
		if(thread == null) {
			thread = new Thread(this, name);
			thread.start();
		}
	}
	
}

public class TestThread {

	public static void main(String[] args) {

		SampleDemo A = new SampleDemo("A");
		SampleDemo B = new SampleDemo("B");
		
		B.start();
		A.start();
	}
}