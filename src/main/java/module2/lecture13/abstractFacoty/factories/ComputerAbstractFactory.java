package module2.lecture13.abstractFacoty.factories;

import module2.lecture13.abstractFacoty.laptops.Laptop;
import module2.lecture13.abstractFacoty.servers.Server;

public abstract class ComputerAbstractFactory {
    public static ComputerAbstractFactory getFactory(Manufacturer type) {
        return switch (type) {
            case INTEL -> IntelFactory.getInstance();
            case APPLE -> AppleFactory.getInstance();
        };
    }

    public abstract Server createServer();

    public abstract Laptop createLaptop();
}
