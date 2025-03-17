package module3.lecture14;

import lombok.SneakyThrows;

import java.util.List;
import java.util.Random;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

public class MyPhaser extends Thread {

    private final Phaser phaser;

    private final Random random = new Random();

    MyPhaser(final Phaser phaser) {
        this.phaser = phaser;
        phaser.register();
    }

    @SneakyThrows
    @Override
    public void run() {
        final String name = Thread.currentThread().getName();
        int sleep = random.nextInt(1000);
        System.out.printf("[%s] waiting: %d\n", name, sleep);
        TimeUnit.MILLISECONDS.sleep(sleep);
        phaser.arriveAndAwaitAdvance(); // 0

        sleep = random.nextInt(1000);
        System.out.printf("[%s] waiting: %d\n", name, sleep);
        TimeUnit.MILLISECONDS.sleep(sleep);
        phaser.arriveAndAwaitAdvance(); // 1

        sleep = random.nextInt(1000);
        System.out.printf("[%s] waiting: %d\n", name, sleep);
        TimeUnit.MILLISECONDS.sleep(sleep);
        phaser.arriveAndAwaitAdvance(); // 2

        phaser.arriveAndDeregister(); // 3
        System.out.printf("[%s] end\n", name);
    }

    @SneakyThrows
    public static void main(String[] args) {
        final Phaser phaser1 = new Phaser(1);

        final List<Thread> mySemaphores = List.of(
                new MyPhaser(phaser1),
                new MyPhaser(phaser1),
                new MyPhaser(phaser1)
        );

        mySemaphores.forEach(Thread::start);

        int phase = phaser1.getPhase();
        System.out.printf("[MAIN] phase: %d\n", phase);
        phaser1.arriveAndAwaitAdvance(); // 0

        phase = phaser1.getPhase();
        System.out.printf("[MAIN] phase: %d\n", phase);
        phaser1.arriveAndAwaitAdvance(); // 1

        phase = phaser1.getPhase();
        System.out.printf("[MAIN] phase: %d\n", phase);
        phaser1.arriveAndAwaitAdvance(); // 2


        phaser1.arriveAndDeregister(); // 3
        System.out.printf("[MAIN] end\n");
        if (phaser1.isTerminated()) {
            System.out.printf("[MAIN] phaser is terminated\n");
        } else {
            System.out.printf("[MAIN] phaser is not terminated\n");
        }

    }
}
