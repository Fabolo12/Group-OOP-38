package module2.lecture10;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Main7 {
    public static void main(String[] args) {
        List.of(new Horse("Horse 1"), new Horse("Horse 2"), new Horse("Horse 3"))
                .forEach(Thread::start);
    }

    static class Horse extends Thread {
        private final Random random = new Random();
        private static final int MAX_DISTANCE = 1_000;

        public Horse(final String name) {
            super(name);
        }

        @Override
        public void run() {
            int currecntDistance = 0;
            while (currecntDistance < MAX_DISTANCE) {
                currecntDistance += random.nextInt(100);
                System.out.println(getName() + ": " + "-".repeat(currecntDistance / 100) + ">");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println(getName() + " has finished the");
        }
    }
}
