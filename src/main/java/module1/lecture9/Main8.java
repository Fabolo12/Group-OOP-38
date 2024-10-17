package module1.lecture9;

public class Main8 {
    public static void main(String[] args) {
        /*
        109.1678 — звичайна форма;
        1.091678E+2 — експоненціальна форма запису.
        Мантиса повинна бути дробовим числом від 1.0 до 10.
         */

        double earthDiameter = 12742.0;
        double lightSpeed = 299792458.0;
        double uraniumAtomicMass = 238.0289;
        double averageBeeWeight = 0.085;
        double javaDeveloperSalary = 10000.0;

        parseAndPrintNumber(averageBeeWeight);
    }

    private static void parseAndPrintNumber(double number) {
        if (number < 10) {
            System.out.println("Number: " + number + "E+0");
        } else {
            final int mantissa = getMantissa(number);
            number = number / Math.pow(10, mantissa);
            System.out.println("Number: " + number + "E+" + mantissa);
        }
    }

    private static int getMantissa(double number) {
        if (number <= 10) {
            return 0;
        }
        number /= 10;
        return getMantissa(number) + 1;
    }

}
