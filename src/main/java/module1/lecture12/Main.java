package module1.lecture12;

public class Main {

    public static void main(String[] args) {
        People valerii = new People();
        valerii.name = "Valerii";
        valerii.age = 25;

        System.out.println(valerii);

        People vlad = new People();
        vlad.name = "Vlad";
        vlad.age = 30;
        System.out.println(vlad);
        System.out.println(valerii);

        People denis = new People();
        denis.age = 18;
        System.out.println(denis);
        denis.name = "Denis";
        System.out.println(denis);

        System.out.println("Denis has " + denis.age);

        denis.print();

        People valerii2 = new People();
        valerii2.name = "Valerii";
        valerii2.age = 25;

        System.out.println(valerii.equals(valerii2));
    }
}
