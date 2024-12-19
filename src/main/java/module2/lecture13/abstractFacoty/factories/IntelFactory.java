package module2.lecture13.abstractFacoty.factories;

import module2.lecture13.abstractFacoty.laptops.Laptop;
import module2.lecture13.abstractFacoty.laptops.LaptopIntel;
import module2.lecture13.abstractFacoty.servers.Server;
import module2.lecture13.abstractFacoty.servers.ServerIntel;

public class IntelFactory extends ComputerAbstractFactory {

    private static final IntelFactory INSTANCE = new IntelFactory();

    private IntelFactory() {
        System.out.println("Creating IntelFactory");
    }

    public static IntelFactory getInstance() {
        return INSTANCE;
    }

    @Override
    public Server createServer() {
        return new ServerIntel();
    }

    @Override
    public Laptop createLaptop() {
        return new LaptopIntel();
    }
}
