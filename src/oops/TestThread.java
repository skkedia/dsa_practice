package oops;

class SampleDemo implements Runnable {

    private Thread thread;
    private String name;

    SampleDemo(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            System.out.print(name);
        }
    }

    public void start() {
        if (thread == null) {
            thread = new Thread(this, name);
            thread.start();
        }
    }

}

class Demo extends Thread {
    @Override
    public void run() {
        System.out.println("here");
    }
}

public class TestThread {

    public static void main(String[] args) {

        SampleDemo A = new SampleDemo("A");
        SampleDemo B = new SampleDemo("B");

        Demo th = new Demo();
        th.start();

        Thread tt = new Thread(new Runnable() {
            public void run() {
                System.err.println("hi");
            }
        });
        tt.start();

        B.start();
        A.start();
    }
}