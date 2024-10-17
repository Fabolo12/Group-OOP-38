package module1.lecture7;

public class Main4 {
    public static void main(String[] args) {
        int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] numbers;
        numbers = new int[10];

        int[] numbers2;
//        numbers2 = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }; ERROR
        numbers2 = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        numbers2 = new int[]{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        var something = 0;
        var line = "Line";
        System.out.println(something);
//        var temp; ERROR
//        temp = "Temp";
    }
}
