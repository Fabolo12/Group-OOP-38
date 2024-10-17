package module1.lecture15;

public final class FinalClass { // 5
    private static final double PI = 3.14; // 3

    public static void main(final String[] args) { // 1
        final int a = 5; // 2

        final int[] arr1 = {1, 2, 3};
        final int[] arr2 = {1, 2, 3};
    }

    public final void print() { // 4
        System.out.println("Final method");
    }
}

