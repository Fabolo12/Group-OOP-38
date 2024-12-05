package module2.lecture10;

import java.util.concurrent.TimeUnit;

public class Main5 {
    public static void main(String[] args) throws InterruptedException {
        Runnable run = () -> {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        final Thread thread = new Thread(run);
        thread.start();
        TimeUnit.SECONDS.sleep(3);
        System.out.println("Main thread finished");
    }
}
