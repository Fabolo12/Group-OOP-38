package module1.lecture7;

import java.util.Random;

public class Main6 {
    public static void main(String[] args) {
        int[][] map = new int[10][10];

        final Random random = new Random();
        int maxShipNumber = 25;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                final boolean isPlaceShip = random.nextBoolean();
                if (isPlaceShip && maxShipNumber > 0) {
                    map[i][j] = 1;
                    maxShipNumber--;
                    if (maxShipNumber == 0) {
                        break;
                    }
                }
            }
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
