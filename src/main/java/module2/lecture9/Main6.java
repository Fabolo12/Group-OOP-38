package module2.lecture9;

public class Main6 {
    public static void main(String[] args) {
        try (MyStream stream = new MyStream()) {
            System.out.println("Try");
        }
    }

    static class MyStream implements AutoCloseable {
        @Override
        public void close() {
            System.out.println("Close");
        }
    }
}
