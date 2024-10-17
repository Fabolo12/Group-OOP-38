package module1.lecture12;

public class People {

    String name = "default";

    int age;

    public void print() {
        System.out.println("Name: " + name + ", Age: " + age);
    }

    public String getPrintString() {
        return "Name: " + name + ", Age: " + age;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

