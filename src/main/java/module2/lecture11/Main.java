package module2.lecture11;

import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Main {

    private static int sum = 0;
    private static int sum2 = 0;

    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    public static void main(String[] args) throws InterruptedException {
        new Main().run();
    }

    private void run() throws InterruptedException {
        class MyClass {

        }

        Runnable run1 = () -> {
            while (true) {

            }
        };
        Thread thread = new Thread() {
            @Override
            public void run() {
                while (true) {

                }
            }
        };
        Runnable run2 = () -> {
            for (int i = 0; i < 10_00; i++) {
                add2();
            }
        };

        final Thread thread1 = new Thread(run1);
        final Thread thread2 = new Thread(run2);
        final long start = new Date().getTime();
        thread1.start();
        thread2.start();

        thread1.join(Duration.ofSeconds(30));
        thread2.join(Duration.ofSeconds(30));
        final long end = new Date().getTime();
        System.out.println("Time: " + (end - start) / 100 + " miliseconds");
        // 39 seconds with synchronized
        // 19 second without synchronized
        // 19 second without part synchronized
        System.out.println("Sum: " + sum);
    }

    private void add1() {
        synchronized (lock1) {
            sum += 1;
        }

        try {
            TimeUnit.MILLISECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void add2() {
        synchronized (lock2) {
            sum2 += 1;
        }
    }
}
