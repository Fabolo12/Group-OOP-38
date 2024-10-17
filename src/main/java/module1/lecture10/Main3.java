package module1.lecture10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main3 {

    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        do {
            int userInput = printMenu();
            switch (userInput) {
                case 1 -> characterEscaping();
                case 2 -> specialCharacters();
                case 3 -> stringToArray();
                case 4 -> replaceUrl();
                case 5 -> substring();
                case 6 -> substringByChar();
                case 0 -> {
                    System.out.println("Exiting...");
                    return;
                }
            }
        } while (true);
    }

    private static int printMenu() throws IOException {
        System.out.println("Enter number of command:");
        System.out.println("1. Character escaping");
        System.out.println("2. Special characters");
        System.out.println("3. String to array");
        System.out.println("4. Replace URL");
        System.out.println("5. Substring");
        System.out.println("6. Substring 2");
        System.out.println("0. Exit");
        return Integer.parseInt(READER.readLine());
    }

    private static void characterEscaping() {
        System.out.println("String with special characters:");
        System.out.println("My \"string\" with special characters: \\");
    }

    private static void specialCharacters() {
        System.out.println("Special characters:");
        System.out.println("New line: \n");
        System.out.println("\t Tabulation");
        System.out.println("Backspace: \b");
        System.out.println("Carriage return: \r");
        System.out.println("Form feed: \f");
        System.out.println("Backslash: \\");
        System.out.println("Single quote: " + '\'');
        System.out.println("Double quote: \"");
        System.out.println("Not new line: \\n");
    }

    private static void stringToArray() throws IOException {
        System.out.println("Enter string:");
        final String line = READER.readLine();
        System.out.println("User line: " + line);
        final char[] charArray = line.toCharArray();
        System.out.println("Array of characters:" + Arrays.toString(charArray));
        String emptyString = "  ";
        System.out.println("Empty string isEmpty: " + emptyString.isEmpty());
        System.out.println("Empty string isBlank: " + emptyString.isBlank());
        final String trim = emptyString.trim();
        System.out.println("Empty trim string isEmpty: " + trim.isEmpty());
        System.out.println("Write your name:");
        final String userName = READER.readLine().trim().toLowerCase();
        System.out.println("Your name is: " + userName);
    }

    private static void replaceUrl() throws IOException {
        // https:\\javarush.com\\ua\quests\QUEST_JAVA_SYNTAX
        System.out.println("Write your URL:");
        final String incorrectUrl = READER.readLine().trim().toLowerCase();
        final String[] parts = incorrectUrl.split("\\\\"); // \\\\ -> \\ -> \
        final String correctUrl = String.join("/", parts);
        System.out.println("Correct URL: " + correctUrl);

        final String replaceFirst = incorrectUrl.replaceFirst("\\\\", "/");
        System.out.println("Replace first: " + replaceFirst);

        final String replaceAll = incorrectUrl.replaceAll("\\\\", "/");
        System.out.println("Replace all: " + replaceAll);

        final String replace = incorrectUrl.replace("\\", "/");
        System.out.println("Replace: " + replace);
    }

    private static void substring() throws IOException {
        System.out.println("Write your line:");
        final String line = READER.readLine().trim().toLowerCase();
        System.out.println("Write your start position:");
        final int start = Integer.parseInt(READER.readLine());
        System.out.println("Write your end position:");
        final int end = Integer.parseInt(READER.readLine());

        if (start < 0 || end > line.length() || start > end) {
            System.out.println("Incorrect input");
            return;
        }

        final String substring = line.substring(start, end);
        System.out.println("Substring: " + substring);
    }

    private static void substringByChar() throws IOException {
        System.out.println("Write your line:");
        final String line = READER.readLine().trim().toLowerCase();
        System.out.println("Write your start char:");
        final String start = READER.readLine();
        System.out.println("Write your end char:");
        final String end = READER.readLine();

        final int startIndex = line.indexOf(start);
        final int endIndex = line.indexOf(end);

        if (startIndex < 0 || endIndex < 0 || startIndex > endIndex) {
            System.out.println("Incorrect input");
            return;
        }

        final String substring = line.substring(startIndex, endIndex);
        System.out.println("Substring: " + substring);
    }
}
