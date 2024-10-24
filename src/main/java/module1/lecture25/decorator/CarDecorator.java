package module1.lecture25.decorator;

public abstract class CarDecorator implements CarFactory {
    protected CarFactory carFactory;

    protected CarDecorator(CarFactory carFactory) {
        this.carFactory = carFactory;
    }

    @Override
    public void assemble() {
        carFactory.assemble();
    }
}
