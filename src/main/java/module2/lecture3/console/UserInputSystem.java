package module2.lecture3.console;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UserInputSystem {

    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    public static String readLine() {
        try {
            return READER.readLine();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static int readInt() {
        return Integer.parseInt(readLine());
    }
}
