package module2.lecture10;

import java.util.concurrent.TimeUnit;

public class Main3 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main thread started");

//        new Thread(Main3::print).start();
        final Thread thread = new Thread(() -> {
            while (true) {
                if (Thread.interrupted()) {
                    System.out.println("Thread interrupted, but not now :)");
                    System.out.println(Thread.currentThread().isInterrupted());
                }
            }
        });
        thread.start();

        for (int i = 0; i < 5; i++) {
            thread.interrupt();
            TimeUnit.SECONDS.sleep(1);
        }

//        print2();

        System.out.println("Main thread finished");
    }

    private static void print2() {
        final String name = Thread.currentThread().getName();
        try {
            for (int i = 0; i < 3; i++) {
                System.out.println(name + ": Hello " + i);
                TimeUnit.SECONDS.sleep(1);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void print() {
        final String name = Thread.currentThread().getName();
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println(name + ": Hello " + i);
                TimeUnit.SECONDS.sleep(1);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
