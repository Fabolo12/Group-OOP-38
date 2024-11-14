package module2.lecture4;

public abstract class AbstractMenuItem implements MenuItem {

    @Override
    public void print() {
        printSpecificPart();
        System.out.println("You can chose any action");
    }

    protected abstract void printSpecificPart();
}
