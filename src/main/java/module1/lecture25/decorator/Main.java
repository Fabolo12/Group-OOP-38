package module1.lecture25.decorator;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        final CarFactory basic = new BasicCarFactory();
/*        basic.assemble();

        final LuxuryCarDecorator luxury = new LuxuryCarDecorator(basic);
        luxury.assemble();

        final SportCarDecorator sports = new SportCarDecorator(basic);
        sports.assemble();

        final SportCarDecorator sportsLuxury = new SportCarDecorator(luxury);
        final LuxuryCarDecorator luxurySportsLuxury = new LuxuryCarDecorator(sportsLuxury);
        luxurySportsLuxury.assemble();*/

        final CarFactory car = new Random().nextBoolean() ? new LuxuryCarDecorator(basic) : new SportCarDecorator(basic);
        car.assemble();
    }
}
