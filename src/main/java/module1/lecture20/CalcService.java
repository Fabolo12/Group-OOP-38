package module1.lecture20;

public class CalcService {

    private static CalcService instance;

    private CalcService() {

    }

    public static CalcService getInstance() {
        if (instance == null) {
            System.out.println("Creating new instance");
            instance = new CalcService();
        }
        return instance;
    }

    public int operation(Person person, int a, int b, String operation) {
        int result = 0;

        switch (operation) {
            case "sum", "+":
                result = sum(person, a, b);
                break;
            case "sub", "-":
                result = sub(person, a, b);
                break;
            case "mul", "*":
                result = mul(person, a, b);
                break;
            case "div", "/":
                result = div(person, a, b);
                break;
            default:
                throw new IllegalArgumentException("Invalid operation " + operation);
        }

        switch (operation) {
            case "sum", "+" -> {
                result = sum(person, a, b);
                result = sum(person, a, b);
            }
            case "sub", "-" -> result = sub(person, a, b);
            case "mul", "*" -> result = mul(person, a, b);
            case "div", "/" -> result = div(person, a, b);
            default -> throw new IllegalArgumentException("Invalid operation " + operation);
        }

        result = switch (operation) {
            case "sum", "+" -> {
                sum(person, a, b);
                yield sum(person, a, b);
            }
            case "sub", "-" -> {
                yield sub(person, a, b);
            }
            case "mul", "*" -> {
                yield mul(person, a, b);
            }
            case "div", "/" -> {
                yield div(person, a, b);
            }
            default -> throw new IllegalArgumentException("Invalid operation " + operation);
        };

        result = switch (operation) {
            case "sum", "+" -> sum(person, a, b);
            case "sub", "-" -> sub(person, a, b);
            case "mul", "*" -> mul(person, a, b);
            case "div", "/" -> div(person, a, b);
            default -> throw new IllegalArgumentException("Invalid operation " + operation);
        };

        Number number = 1;

        switch (number) {
            case Integer i -> System.out.println("Integer " + i);
            case Double d -> System.out.println("Double " + d);
            default -> System.out.println("Unknown");
        }


        return result;
    }

    private int sum(Person person, int a, int b) {
        return a + b;
    }

    private int sub(Person person, int a, int b) {
        return a - b;
    }

    private int mul(Person person, int a, int b) {
        return a * b;
    }

    private int div(Person person, int a, int b) {
        return a / b;
    }
}
