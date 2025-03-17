package module3.lecture14;

import lombok.SneakyThrows;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class MyCountDownLatch2 extends  Thread {
    private final CountDownLatch downLatch;

    MyCountDownLatch2(final CountDownLatch downLatch) {
        this.downLatch = downLatch;
    }

    @SneakyThrows
    @Override
    public void run() {
        final String name = Thread.currentThread().getName();
        final int sleepTime = new Random().nextInt(1000);
        System.out.printf("[%s] Sleep for %dms%n", name, sleepTime);
        TimeUnit.MILLISECONDS.sleep(sleepTime);
        System.out.printf("[%s] Finish part%n", name);
        downLatch.countDown();
    }

    @SneakyThrows
    public static void main(String[] args) {
        final CountDownLatch countDownLatch = new CountDownLatch(4);

        final List<Thread> mySemaphores = List.of(
                new MyCountDownLatch2(countDownLatch),
                new MyCountDownLatch2(countDownLatch),
                new MyCountDownLatch2(countDownLatch),
                new MyCountDownLatch2(countDownLatch)
        );


        System.out.println("~~~~~~Start construct TV~~~~~~");
        mySemaphores.forEach(Thread::start);
        countDownLatch.await();
        System.out.println("~~~~~~Finish construct TV~~~~~~");
    }
}
