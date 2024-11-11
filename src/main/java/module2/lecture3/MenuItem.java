package module2.lecture3;

import java.time.LocalDate;

public interface MenuItem {
    Integer DAY = 0;

    static void printInternalDate() {
        System.out.println("No date to print " + DAY);
    }

    void print();

    default void printDate(LocalDate date) {
        System.out.println("No date to print " + DAY);
    }
}
