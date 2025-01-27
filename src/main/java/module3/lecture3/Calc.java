package module3.lecture3;

public class Calc { // CTRL + SHIFT + T


    public int add(int a, int b) {
        return a + b;
    }

    public int sub(int a, int b) {
        return a - b;
    }

    public int mul(int a, int b) {
        return a * b;
    }

    public int div(int a, int b) {
        if (b == 0) {
            return 0;
        }
        if (a == 100) {
            throw new IllegalArgumentException();
        }
        return a / b;
    }
}
