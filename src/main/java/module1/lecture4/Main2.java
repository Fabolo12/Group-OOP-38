package module1.lecture4;

public class Main2 {
    public static void main(String[] args) {
        String line1 = "TEST";
        String line2 = "TEST";
        String line3 = "TEST";

        boolean line1EqualsLine2 = line1.equals(line2);
        boolean line2EqualsLine3 = line2.equals(line3);
        boolean allLineTheSame = line1EqualsLine2 && line2EqualsLine3;
        if (allLineTheSame) {
            System.out.println("All lines are the same");
        }

        if (line1EqualsLine2) {
            System.out.println("Line 1 and Line 2 are the same");
        }

        if (line2EqualsLine3) {
            System.out.println("Line 2 and Line 3 are the same");
        }

        boolean line1EqualsLine3 = line1.equals(line3);
        if (line1EqualsLine3) {
            System.out.println("Line 1 and Line 3 are the same");
        }
    }
}
