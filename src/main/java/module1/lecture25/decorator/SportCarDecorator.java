package module1.lecture25.decorator;

public class SportCarDecorator extends CarDecorator {
    public SportCarDecorator(CarFactory carFactory) {
        super(carFactory);
    }

    @Override
    public void assemble() {
        System.out.println("Adding features of Sport Car");
        super.assemble();
    }
}
