package module2.lecture12;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        final ExecutorService singleThreadPool = Executors.newSingleThreadExecutor();
        System.out.println("Single thread pool");
        runExecutorService(singleThreadPool);
        final ExecutorService fixedThreadPool = Executors.newFixedThreadPool(10);
        System.out.println("Fixed thread pool");
        runExecutorService(fixedThreadPool);
        final ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        System.out.println("Cached thread pool");
        runExecutorService(cachedThreadPool);

        final StringBuilder stringBuilder = new StringBuilder();
        final StringBuffer stringBuffer = new StringBuffer();
    }

    private static void runExecutorService(ExecutorService executorService) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            executorService.execute(new Task(i));
        }
        executorService.awaitTermination(30, TimeUnit.SECONDS);
        executorService.shutdownNow();
    }

    static class Task implements Runnable {
        private final int taskNumber;

        public Task(int taskNumber) {
            this.taskNumber = taskNumber;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ignored) {
            }
            System.out.printf("Оброблено запит #%d у потоці id=%d\n", taskNumber, Thread.currentThread().getId());
        }
    }
}
