package module2.lecture10;

import java.util.concurrent.TimeUnit;

public class Main6 {

    private static int sum = 0;

    public static void main(String[] args) throws InterruptedException {
        Runnable run = () -> {
            for (int i = 0; i < 10_000; i++) {
                sum += 1;
            }
        };

        new Thread(run).start();
        new Thread(run).start();
        TimeUnit.SECONDS.sleep(3);
        System.out.println("Sum: " + sum);
        // Race condition
        // 18311
        // 14399
        // 15867
    }
}
