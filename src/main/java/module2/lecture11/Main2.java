package module2.lecture11;

public class Main2 {

    public static void main(String[] args) throws InterruptedException {
        Clock clock = new Clock();
        Thread clockThread = new Thread(clock);
        clockThread.start();

        Thread.sleep(10000);
        clock.cancel();
    }

    static class Clock implements Runnable {
        private volatile transient boolean isCancel = false;

        public void cancel() {
            this.isCancel = true;
        }

        public void run() {
            while (!this.isCancel) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Tik");
            }
        }
    }
}
