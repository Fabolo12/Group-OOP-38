package module2.lecture4;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        final List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new MainMenuItem());
        menuItems.add(new StartMenuItem());
        menuItems.add(new ExitMenuItem());

        for (MenuItem menuItem : menuItems) {
            menuItem.print();
            menuItem.printDate(LocalDate.now());
            System.out.println("-----");
        }

        MenuItem.printInternalDate();
    }
}
