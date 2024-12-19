package module2.lecture13.facotyMethod;

public class Factory {
    static class ComputerFactory {
        public static Computer getComputer(ComputerType type, String ram, String hdd, String cpu) {
        /*if (ComputerType.PC == type) {
            return new PC(ram, hdd, cpu);
        } else if (ComputerType.SERVER == type) {
            return new ServerIntel(ram, hdd, cpu);
        }*/

            return switch (type) {
                case PC -> new PC(ram, hdd, cpu);
                case SERVER -> new Server(ram, hdd, cpu);
                case GAME_SERVER -> new GameServer(ram, hdd, cpu);
                default -> throw new IllegalArgumentException("Invalid Server Type");
            };
        }
    }

    static class LaptopFactory {
        public static Laptop getLaptop(LaptopType type, String ram, String hdd, String cpu) {
            return switch (type) {
                case STANDARD -> new Laptop();
                default -> throw new IllegalArgumentException("Invalid Laptop Type");
            };
        }
    }
}
