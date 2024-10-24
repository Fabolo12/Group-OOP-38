package module1.lecture25.decorator;

public class BasicCarFactory implements CarFactory {
    @Override
    public void assemble() {
        System.out.println("Basic Car");
    }
}
