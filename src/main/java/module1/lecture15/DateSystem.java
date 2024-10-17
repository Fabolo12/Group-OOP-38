package module1.lecture15;

import java.time.LocalDate;

public class DateSystem implements Control, RemoteControl {
    @Override
    public void printDate() {
        System.out.println("Today is " + LocalDate.now());
    }

    @Override
    public void printDayOfWek() {
        System.out.println("Today is " + LocalDate.now().getDayOfWeek());
    }

    @Override
    public void printVolume() {
        System.out.println("***Volume is " + RemoteControl.MAX_VOLUME + "***");
    }
}


class MainDateSystem {

    public static void main(String[] args) {
        final DateSystem dateSystem = new DateSystem();

        final Control control = dateSystem;
        control.printDate();
        Control.printTime();

        final RemoteControl remoteControl = dateSystem;
        remoteControl.printDate();
        remoteControl.printDayOfWek();
        remoteControl.printVolume();
    }
}