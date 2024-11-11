package module2.lecture2;

public abstract class AbstractFactory {

    public void buildCar() {
        final Car car = new Car();
        car.setModel(getModel());
        car.setColor(getColor());
        car.setYear(getYer());
        System.out.println("Build car: " + car);
    }

    public abstract String getModel();

    public abstract String getColor();

    public abstract int getYer();
}
