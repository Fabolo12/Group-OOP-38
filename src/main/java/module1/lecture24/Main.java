package module1.lecture24;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        String src = "src/main/java/module1/lecture24/log.txt";
        String dest = "src/main/java/module1/lecture24/new-log.log";
        copyByteFile(src, dest);
        copyCharFile(src, dest);
        readBuffered(src);
        readSettings();
        readConsole();
        writeBuffered(dest);
    }

    private static void writeBuffered(final String dest) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(dest, true));
        final List<String> list = List.of("Hello", "World", "Java");
        for (String line : list) {
            writer.write(line);
            writer.newLine();
        }

        writer.flush();
        writer.close();
    }

    private static void readConsole() throws IOException {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter a line: ");
        String line = buff.readLine();
        System.out.println("You entered: " + line);
    }

    private static void readSettings() throws IOException {
        final String src = "src/main/java/module1/lecture24/settings.txt";
        final BufferedReader reader = new BufferedReader(new FileReader(src));
        final Map<String, String> properties = new HashMap<>();

        while (reader.ready()) {
            String[] property = reader.readLine().split(":");
            properties.put(property[0], property[1]);
        }

        reader.close();

        if (properties.get("env").equals("dev")) {
            System.out.println("Development environment");
        } else {
            System.out.println("Production environment");
        }

        if (Boolean.parseBoolean(properties.get("log-date")) ) {
            System.out.println(LocalDate.now());
        }
    }

    private static void readBuffered(final String src) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(src));

        while (reader.ready()) {
            String line = reader.readLine();
            System.out.println(line);
        }
    }

    private static void copyCharFile(final String src, final String dest) throws IOException {
        FileReader reader = new FileReader(src);
        FileWriter writer = new FileWriter(dest);

        char[] buffer = new char[65536]; // 128Kb
        while (reader.ready()) {
            int real = reader.read(buffer);
            writer.write(buffer, 0, real);
        }

        reader.close();
        writer.close();
    }

    private static void copyByteFile(final String src, final String dest) throws IOException {
        FileInputStream input = new FileInputStream(src);
        FileOutputStream output = new FileOutputStream(dest);

        byte[] buffer = new byte[65536]; // 64Kb
        while (input.available() > 0) {
            int real = input.read(buffer);
            output.write(buffer, 0, real);
        }

        input.close();
        output.close();
    }
}
