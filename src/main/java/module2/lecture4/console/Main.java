package module2.lecture4.console;

import module2.lecture4.console.items.BruteForceFileMenu;
import module2.lecture4.console.items.DecryptFileMenu;
import module2.lecture4.console.items.DeleteFileMenu;
import module2.lecture4.console.items.EncryptFileMenu;
import module2.lecture4.console.items.ExitMenu;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Main {

    private static final Map<String, MenuItem> MENU_ITEMS = new LinkedHashMap<>();

    static {
        MENU_ITEMS.put("Encrypt file", new EncryptFileMenu());
        MENU_ITEMS.put("Decrypt file", new DecryptFileMenu());
        MENU_ITEMS.put("Brute force file", new BruteForceFileMenu());
        MENU_ITEMS.put("Delete file", new DeleteFileMenu());
        MENU_ITEMS.put("Exit", new ExitMenu());
    }

    public static void main(String[] args) {
        mapMenu();
    }

    private static void enumMenu() {
        while (true) {
            System.out.println("Welcome to the console application!");
            System.out.println("Please, select the menu item:");
            final Menu[] values = Menu.values();
            for (int i = 0; i < values.length; i++) {
                System.out.printf("%d. %s%n", i + 1, values[i]);
            }

            final int index = UserInputSystem.readInt() - 1;
            values[index].execute();
        }
    }

    private static void mapMenu() {
        while (true) {
            System.out.println("Welcome to the console application!");
            System.out.println("Please, select the menu item:");
            final Set<String> keys = MENU_ITEMS.keySet();
            int i = 0;
            for (String key : keys) {
                System.out.printf("%d. %s%n", i++ + 1, key);
            }
            final int index = UserInputSystem.readInt() - 1;
            final Collection<MenuItem> values = MENU_ITEMS.values();
            i = 0;
            for (MenuItem value : values) {
                if (i++ == index) {
                    value.execute();
                    break;
                }
            }
        }
    }
}
