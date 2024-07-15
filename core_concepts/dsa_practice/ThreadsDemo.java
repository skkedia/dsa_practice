package dsa_practice;

public class ThreadsDemo extends Thread {

	static Thread mainthread;

	@Override
	public void run() {
		try {
			mainthread.join();
			for (int i = 0; i < 5; i++) {
				System.out.println(i);
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		mainthread = Thread.currentThread();
		ThreadsDemo t1 = new ThreadsDemo();
		t1.start();
		try {
			t1.join();
			for (int i = 0; i < 5; i++) {
				System.out.println(i);
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
