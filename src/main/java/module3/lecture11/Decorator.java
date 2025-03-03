package module3.lecture11;

public class Decorator {

    public static void main(String[] args) {

        final Car basicCar = new BasicCar();
        basicCar.assemble();
        System.out.println();

        Car sportsCar = new SportsCar(basicCar);
        sportsCar.assemble();
        System.out.println();

        Car luxuryCar = new LuxuryCar(basicCar);
        luxuryCar.assemble();
        System.out.println();

        Car luxuryCar2 = new LuxuryCar(sportsCar);
        luxuryCar2.assemble();
        System.out.println();

        Car luxuryCar3 = new LuxuryCar(new LuxuryCar(new SportsCar(new LuxuryCar(sportsCar))));
        luxuryCar3.assemble();
        System.out.println();
    }

    interface Car {
        void assemble();
    }

    static class BasicCar implements Car {
        @Override
        public void assemble() {
            System.out.print("Basic Car.");
        }
    }

    abstract static class CarDecorator implements Car {

        protected Car car;

        protected CarDecorator(Car c) {
            this.car = c;
        }

        @Override
        public void assemble() {
            this.car.assemble();
        }
    }

    static class SportsCar extends CarDecorator {

        public SportsCar(Car c) {
            super(c);
        }

        @Override
        public void assemble() {
            super.assemble();
            System.out.print(" Adding features of Sports Car.");
        }
    }


    static class LuxuryCar extends CarDecorator {

        public LuxuryCar(Car c) {
            super(c);
        }

        @Override
        public void assemble() {
            super.assemble();
            System.out.print(" Adding features of Luxury Car.");
        }
    }
}
