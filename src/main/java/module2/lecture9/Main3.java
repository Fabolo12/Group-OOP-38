package module2.lecture9;

import java.util.concurrent.TimeUnit;

public class Main3 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Start");
        Thread.sleep(5000);
        System.out.println("End");

        System.out.println("Start");
        TimeUnit.SECONDS.sleep(5);
        System.out.println("End");
    }
}
