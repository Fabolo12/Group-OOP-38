package module2.lecture4;

import java.time.LocalDate;

public class MainMenuItem extends AbstractMenuItem implements DatePrinter {
    @Override
    public void printSpecificPart() {
        System.out.print("Today is: " );
        printDate(LocalDate.now());
        System.out.println("Welcome to the main menu!");
        System.out.println("Just type the number of the action");
        System.out.println("1. Start");
        System.out.println("2. Exit");
    }

    @Override
    public void printDate(final LocalDate date) {
        System.out.println(date);
    }
}
