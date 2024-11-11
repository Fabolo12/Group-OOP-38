package module1.lecture28;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Commands: " + Arrays.toString(args));


        if (args.length != 3) {
            System.out.println("Use CLI");
        } else {
// java -jar c:/MyProject/target/myApp.jar ENCRYPT folder/textFile1.txt 20
            String command = args[0];
            String file = args[1];
            String key = args[2];
            System.out.println(command);
            System.out.println(file);
            System.out.println(key);
        }


        List<String> capitalLetters = List.of("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z");
        List<String> smallLetters = List.of("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z");
        String line = "aBc!";

        List<String> full = new ArrayList<>();
        full.addAll(capitalLetters);
        full.addAll(smallLetters);

        final String[] split = line.split("");
        for (String s : split) {
            if (capitalLetters.contains(s)) {
                System.out.println("Use capital letter: " + s);
            } else if (smallLetters.contains(s)) {
                System.out.println("Use small letter: " + s);
            } else {
                System.out.println("Use unknown letter: " + s);
            }

            System.out.println("Char code");
            int c = (int) s.toCharArray()[0];
            System.out.println((char) c);
            System.out.println(c);
            c++;
            System.out.println((char) c);
            System.out.println(c);
            c--;
            System.out.println((char) c);
            System.out.println(c);
            System.out.println("~~~~~~");
        }

    }
}
