package module1.lecture14;

public class Main {
    public static void main(String[] args) {
        final Cat cat = printCatInfo();
        System.out.println();
        final Dog dog = printDogInfo();

        final Animal animal2 = cat;
        final Animal animal3 = dog;

        System.out.println();
        if (animal2 instanceof Cat ) {
            Cat cat1 = (Cat) animal2;
            System.out.println(cat1);
        }

        if (animal3 instanceof Dog dog1) {
            System.out.println(dog1);
        }
        System.out.println();

        final Animal[] animals = {animal2, animal3};
        printInfo(animals);
    }

    private static void printInfo(final Animal[] animals) {
        for (int i = 0; i < animals.length; i++) {
            final Animal animal = animals[i];
            animal.printFullInfo();
            animal.printShortInfo();

            if (animal instanceof Cat cat) {
                cat.increaseMouseCount();
            }
        }
    }

    private static Cat printCatInfo() {
        final Cat cat = new Cat("Cat", 2, "White", 3);
        System.out.println("Default cat info:");
        cat.printFullInfo();
        System.out.println("~".repeat(5));
        cat.increaseMouseCount();
        System.out.println("Cat info:");
        cat.printFullInfo2();
        System.out.println("~".repeat(5));
        System.out.println("Cat info:");
        cat.printFullInfo3();
        return cat;
    }

    private static Dog printDogInfo() {
        final Dog dog = new Dog("Dog", 3, "Brown", 4);
        final Dog dog1 = new Dog("Dog", "Brown", 4);
        dog.increaseExhibitionsCount();
        System.out.println("Default dog info:");
        dog.printFullInfo();
        return dog;
    }
}

class Cat extends Animal {

    private int mouseCount;

    public Cat(final String name, final int age, final String color, final int mouseCount) {
        super(name, age, color);
        this.mouseCount = mouseCount;
    }

    public void increaseMouseCount() {
        mouseCount++;
    }

    public void printFullInfo2() {
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Color: " + getColor());
        System.out.println("Mouse count: " + mouseCount);
    }

    public void printFullInfo3() {
        super.printFullInfo();
        System.out.println("Mouse count: " + mouseCount);
    }

    @Override
    public void printShortInfo() {
        System.out.printf("Name: %s, age: %d, color: %s, mouse count: %d%n",
                getName(), getAge(), getColor(), mouseCount);
    }
}

class Dog extends Animal {
    private int exhibitionsCount;

    public Dog(final String name, final int age, final String color, final int exhibitionsCount) {
        super(name, age, color);
        this.exhibitionsCount = exhibitionsCount;
    }

    public Dog(final String name, final String color, final int exhibitionsCount) {
        super(name, 1, color);
        this.exhibitionsCount = exhibitionsCount;
    }

    public void increaseExhibitionsCount() {
        exhibitionsCount++;
    }

    @Override
    public void printFullInfo() {
        super.printFullInfo();
        System.out.println("Mouse count: " + exhibitionsCount);
    }

    @Override
    public void printShortInfo() {
        System.out.printf("Name: %s, age: %d, color: %s, exhibitions count: %d%n",
                getName(), getAge(), getColor(), exhibitionsCount);
    }
}