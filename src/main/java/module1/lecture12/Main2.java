package module1.lecture12;

public class Main2 {
    public static void main(String[] args) {
        final Object o = new Object();
        People person = new People();

        System.out.println(person);
        System.out.println(person.toString());
        System.out.println(person.getPrintString());
        person.print();


        String line = person.toString();
        System.out.println(line);
    }
}
