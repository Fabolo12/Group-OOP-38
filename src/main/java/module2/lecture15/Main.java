package module2.lecture15;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static final int PORT = 6666;

    public static void main(String[] args) throws InterruptedException {
        final ExecutorService fixedThreadPool = Executors.newFixedThreadPool(2);
        fixedThreadPool.submit(() -> {
            try {
                final GreetServer greetServer = new GreetServer();
                greetServer.start(PORT);

                TimeUnit.SECONDS.sleep(5);
                greetServer.stop();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        fixedThreadPool.submit(() -> {
            try {
                final GreetClient greetClient = new GreetClient();
                greetClient.startConnection("localhost", PORT);

                TimeUnit.SECONDS.sleep(1);
                greetClient.sendMessage("hello server");
                TimeUnit.SECONDS.sleep(1);
                greetClient.sendMessage("ping");
                TimeUnit.SECONDS.sleep(1);
                greetClient.stopConnection();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        fixedThreadPool.awaitTermination(10, TimeUnit.SECONDS);
        fixedThreadPool.shutdownNow();
    }
}
