package module2.lecture13.facotyMethod;

public class Main {
    public static void main(String[] args) {
        final Computer pc = Factory.ComputerFactory.getComputer(ComputerType.PC, "2 GB", "500 GB", "2.4 GHz");
        System.out.println(pc);

        final Computer server = Factory.ComputerFactory.getComputer(ComputerType.SERVER, "16 GB", "1 TB", "2.9 GHz");
        System.out.println(server);

        final Laptop laptop = Factory.LaptopFactory.getLaptop(LaptopType.STANDARD, "8 GB", "512 GB", "2.6 GHz");
        System.out.println(laptop);
    }
}
