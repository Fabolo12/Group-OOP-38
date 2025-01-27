package module3.lecture3;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class CalcTest {

    private Calc target;

    @BeforeEach
    void setUp() {
//        System.out.println("Setting up Calc object");
        target = new Calc();
    }

    @AfterAll
    static void afterAll() {
//        System.out.println("After all tests");
    }

    @AfterEach
    void tearDown() {
//        System.out.println("Tearing down Calc object");
    }

    @BeforeAll
    static void beforeAll() {
//        System.out.println("Before all tests");
    }

    @Nested
    class CalcAddTest {
        @Test
        @DisplayName("Check sum of two positive numbers")
        void addPositiveNumbers() {

            final int add = target.add(1, 1);

            Assertions.assertEquals(2, add, "Sum of 1 and 1 should be 1");
            Assertions.assertNotEquals(2,1);
            Assertions.assertTrue(true);
            Assertions.assertFalse(false);
//        Assertions.assertThrows(ArithmeticException.class, () -> {});
            Assertions.assertDoesNotThrow(() -> {});
            Assertions.assertNotNull(new Object());
            Assertions.assertNull(null);
//        Assertions.fail("This test is not implemented yet");
        }

        @Test
        void addZeroNumbers() {
            // precondition
            final int firstNumber = 0;
            final int secondNumber = 0;
            final int expected = 0;

            // action
            final int actual = target.add(firstNumber, secondNumber);

            // assertions
            Assertions.assertEquals(expected, actual);
        }

        @Test
        void addNegativeNumbers() {
            // precondition
            final int firstNumber = -1;
            final int secondNumber = -1;
            final int expected = -2;

            // action
            final int actual = target.add(firstNumber, secondNumber);

            // assertions
            Assertions.assertEquals(expected, actual);
        }

        @Test
        void addBothPositiveAndNegativeNumbers() {
            // precondition
            final int firstNumber = -2;
            final int secondNumber = 1;
            final int expected = -1;

            // action
            final int actual = target.add(firstNumber, secondNumber);

            // assertions
            Assertions.assertEquals(expected, actual);
        }
    }

    @Nested
    class CalcDivTest {
        @Test
        void divPositiveNumbers() {
            // precondition
            final int firstNumber = 10;
            final int secondNumber = 2;
            final int expected = 5;

            // action
            final int actual = target.div(firstNumber, secondNumber);

            // assertions
            Assertions.assertEquals(expected, actual);
        }

        @Test
        void divZeroNumbers() {
            // precondition
            final int firstNumber = 0;
            final int secondNumber = 0;
            final int expected = 0;

            // action
            final int actual = target.div(firstNumber, secondNumber);

            // assertions
            Assertions.assertEquals(expected, actual);
        }

        @Test
        void divNegativeNumbers() {
            // precondition
            final int firstNumber = -10;
            final int secondNumber = -2;
            final int expected = 5;

            // action
            final int actual = target.div(firstNumber, secondNumber);

            // assertions
            Assertions.assertEquals(expected, actual);
        }

        @Test
        void divBothPositiveAndNegativeNumbers() {
            // precondition
            final int firstNumber = -10;
            final int secondNumber = 2;
            final int expected = -5;

            // action
            final int actual = target.div(firstNumber, secondNumber);

            // assertions
            Assertions.assertEquals(expected, actual);
        }

        @Test
        void divFirstNumber100() {
            // precondition
            final int firstNumber = 100;
            final int secondNumber = 2;

            // action & assertions
            Assertions.assertThrows(IllegalArgumentException.class, () -> target.div(firstNumber, secondNumber));
        }
    }

    /*public void sub(int a, int b) {
        return a - b;
    }

    public void mul(int a, int b) {
        return a * b;
    }*/
}