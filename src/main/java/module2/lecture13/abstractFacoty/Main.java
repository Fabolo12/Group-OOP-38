package module2.lecture13.abstractFacoty;

import module2.lecture13.abstractFacoty.factories.ComputerAbstractFactory;
import module2.lecture13.abstractFacoty.factories.Manufacturer;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        printInfo(ComputerAbstractFactory.getFactory(Manufacturer.INTEL));
        printInfo(ComputerAbstractFactory.getFactory(Manufacturer.APPLE));
//        Class.forName("module2.lecture13.abstractFacoty.factories.IntelFactory");
//        Class.forName("module2.lecture13.abstractFacoty.factories.AppleFactory");
//        System.out.println(ComputerAbstractFactory.getFactory(Manufacturer.INTEL));
//        System.out.println(ComputerAbstractFactory.getFactory(Manufacturer.INTEL));
//        System.out.println(ComputerAbstractFactory.getFactory(Manufacturer.INTEL));
    }

    private static void printInfo(final ComputerAbstractFactory factory) {
        factory.createServer().printInfo();
        factory.createLaptop().printInfo();
    }
}
