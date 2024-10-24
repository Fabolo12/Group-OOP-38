package module1.lecture25.decorator;

public class LuxuryCarDecorator extends CarDecorator {
    public LuxuryCarDecorator(CarFactory carFactory) {
        super(carFactory);
    }

    @Override
    public void assemble() {
        System.out.println("Adding features of Luxury Car");
        super.assemble();
    }
}
