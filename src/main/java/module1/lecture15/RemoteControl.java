package module1.lecture15;

public interface RemoteControl extends Control {

    int MAX_VOLUME = 100;

    void printDayOfWek();

    default void printVolume() {
        System.out.println("Volume is " + MAX_VOLUME);
    }
}
