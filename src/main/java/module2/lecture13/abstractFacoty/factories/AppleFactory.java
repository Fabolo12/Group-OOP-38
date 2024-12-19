package module2.lecture13.abstractFacoty.factories;

import module2.lecture13.abstractFacoty.laptops.Laptop;
import module2.lecture13.abstractFacoty.laptops.LaptopApple;
import module2.lecture13.abstractFacoty.servers.Server;
import module2.lecture13.abstractFacoty.servers.ServerApple;

public class AppleFactory extends ComputerAbstractFactory {

    private static AppleFactory instance;

    private AppleFactory() {
        System.out.println("Creating AppleFactory");
    }

    public static AppleFactory getInstance() {
        if (instance == null) {
            instance = new AppleFactory();
        }
        return instance;
    }

    @Override
    public Server createServer() {
        return new ServerApple();
    }

    @Override
    public Laptop createLaptop() {
        return new LaptopApple();
    }
}
