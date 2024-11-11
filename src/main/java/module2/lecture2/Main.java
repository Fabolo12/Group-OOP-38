package module2.lecture2;

public class Main {
    public static void main(String[] args) {
        final AbstractFactory taytaFactory = new TaytaFactory();
        taytaFactory.buildCar();

        final AbstractFactory bmwFactory = new BmwFactory();
        bmwFactory.buildCar();
    }
}
