package module2.lecture13.abstractFacoty.servers;

public class ServerIntel implements Server {

    @Override
    public void printInfo() {
        System.out.println("Server Intel: RAM=16GB, HDD=1TB, CPU=Intel Xeon E5-2620");
    }
}
