package module2.lecture15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class GreetClient {
    private Socket clientSocket;

    private PrintWriter out;

    private BufferedReader in;

    public void startConnection(String ip, int port) throws IOException {
        clientSocket = new Socket(ip, port);
        System.out.println("[Client] Client started");
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }

    public void sendMessage(String msg) throws IOException {
        out.println(msg);
        final String response = in.readLine();
        System.out.println("[Client] Message from server: " + response);
    }

    public void stopConnection() throws IOException {
        System.out.println("[Client] Client stopped");
        in.close();
        out.close();
        clientSocket.close();
    }
}
