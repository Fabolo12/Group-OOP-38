package module2.module;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        /*final MapCell[][] map = new MapCell[5][5];
        Arrays.stream(map).forEach(a -> Arrays.fill(a, new MapCell()));


        for (int i = 0; i < 100; i++) {
            day(map);
        }*/

        final MapCell mapCell = new MapCell();
        mapCell.grass = new ArrayList<>();
        mapCell.grass.add(new Object());
        mapCell.grass.add(new Object());

        /*for (Object grass : mapCell.grass) {
            mapCell.grass.add(new Object());
        }*/

        for (int i = 0; i < mapCell.grass.size(); i++) {
            mapCell.newGrass.add(new Object());
        }
    }

    private static void day(final MapCell[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                final MapCell mapCell = map[i][j];

                mapCell.grass.forEach(o -> {
                    grove(o);
                    move(o);
                });

                mapCell.herbivores.forEach(o -> {
                    eat(o, mapCell);
                    grove(o);
                    move(o);
                });

                mapCell.predators.forEach(o -> {
                    eat(o, mapCell);
                    grove(o);
                    move(o);
                });
            }
        }
    }

    private static synchronized void eat(final Object me, final MapCell mapCell) {
        mapCell.herbivores.forEach(other -> {
            if (me != other) {
                final int percent = new Random().nextInt(100);
                final Integer i = Configure.eatMapping.get(Creature.WOLF).get(Creature.RABBIT);
                if (percent >= i) {
                    System.out.println("Eating");
                    mapCell.herbivores.remove(other);
                }
            }
        });
        System.out.println("Eating");
    }

    private static void grove(final Object o) {
        if (o.hashCode() > 100) {
            return;
        }
        System.out.println("Growing");
    }

    private static void move(final Object o) {
        if (o.hashCode() > 100) {
            return;
        }
        System.out.println("Moving");
    }

    static class MapCell {
        private List<Object> grass;

        private List<Object> newGrass;

        private List<Object> herbivores;

        private List<Object> predators;
    }
}
