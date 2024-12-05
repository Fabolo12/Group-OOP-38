package module2.lecture10;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class Main4 {
    public static void main(String[] args) {
        final AtomicBoolean isStop = new AtomicBoolean(false);

        Runnable run = () -> {
            while (true) {
                if (!isStop.get()) {
                    System.out.println("Thread interrupted");
                    break;
                } else {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };

        Thread thread = new Thread(run);
        thread.start();

        Runnable run2 = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(i + ": Try to interrupt thread");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                isStop.set(true);
            }
        };

        Thread thread2 = new Thread(run2);
        thread2.start();
    }

    private static void defaultSystem() {
        Runnable run = () -> {
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("Thread interrupted");
                    break;
                } else {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };

        Thread thread = new Thread(run);
        thread.start();

        Runnable run2 = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(i + ": Try to interrupt thread");
                thread.interrupt();
            }
        };

        Thread thread2 = new Thread(run2);
        thread2.start();
    }
}
