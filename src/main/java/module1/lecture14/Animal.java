package module1.lecture14;

public abstract class Animal {
    private String name;
    private int age;
    private String color;

    private static int count = 0;

    public Animal(final String name, final int age, final String color) {
        this.name = name;
        this.age = age;
        this.color = color;
        count++;
    }

    public abstract void printShortInfo();

    public String getName() {
        return name;
    }

    public Animal setName(final String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Animal setAge(final int age) {
        this.age = age;
        return this;
    }

    public String getColor() {
        return color;
    }

    public Animal setColor(final String color) {
        this.color = color;
        return this;
    }

    public void printFullInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Color: " + color);
    }
}
