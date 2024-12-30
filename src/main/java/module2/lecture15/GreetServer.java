package module2.lecture15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import static module2.lecture15.Main.PORT;

public class GreetServer {
    private ServerSocket serverSocket;

    private Socket clientSocket;

    private PrintWriter out;

    private BufferedReader in;

    public static void main(String[] args) throws IOException {
        GreetServer server = new GreetServer();
        server.start(PORT);
    }

    public void start(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println("[Server] Server started");
        clientSocket = serverSocket.accept();
        System.out.println("[Server] Client connected");
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        while (!Thread.currentThread().isInterrupted()) {
            String greeting = in.readLine();
            if (greeting == null) {
                continue;
            }
            System.out.println("[Server] Message from client: " + greeting);
            if ("hello server".equals(greeting)) {
                out.println("hello client");
            } else {
                out.println("unrecognised greeting");
            }
        }

    }

    public void stop() throws IOException {
        System.out.println("[Server] Server stopped");
        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();
    }

}
