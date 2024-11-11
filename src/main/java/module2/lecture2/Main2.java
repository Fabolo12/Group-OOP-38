package module2.lecture2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main2 {

    public static void main(String[] args) {
        final Parent parent = new Parent();
        final Child child = new Child();
        final Parent parent2 = new Child();

        final List<String> list = new ArrayList<>();
    }

    static sealed class Parent permits Child {
        public void print() {
            System.out.println("Parent");
        }
    }

    static non-sealed class Child extends Parent  {
        @Override
        public void print() {
            try {
                throw new IOException();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
