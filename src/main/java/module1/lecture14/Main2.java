package module1.lecture14;

public class Main2 {
    public static void main(String[] args) {
        int a1 = 5;
        long b1 = a1;
        if (b1 < Integer.MAX_VALUE) {
            int a2 = (int) b1;
        }

        Cat cat = new Cat("Cat", 2, "White", 3);
        Animal animal = cat;
        if (animal instanceof Cat) {
            Cat cat1 = (Cat) animal;
        }
    }
}
