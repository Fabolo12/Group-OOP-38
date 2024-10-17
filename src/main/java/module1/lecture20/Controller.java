package module1.lecture20;

public class Controller {
    public static void main(String[] args) {
       /* for (int i = 0; i < 10; i++) {
            final CalcService instance = CalcService.getInstance();
            System.out.println("Instance: " + instance);
            final int result = instance.operation(new Person("Person" + i), 1, 2, "sum");
            System.out.println("Result: " + result);
        }*/

        final CalcService instance = CalcService.getInstance();
        final int result = instance.operation(new Person("Person"), 1, 2, "sum");
        System.out.println("Result: " + result);
    }
}
