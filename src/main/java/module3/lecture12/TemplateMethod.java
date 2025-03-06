package module3.lecture12;

public class TemplateMethod {

    public static void main(String[] args) {
        HouseTemplate houseType = new WoodenHouse();
        //using template method
        houseType.buildHouse();
        System.out.println("************");
        houseType = new GlassHouse();
        houseType.buildHouse();
    }

    abstract static class HouseTemplate {

        //template method, final so subclasses can't override
        public final void buildHouse() {
            buildFoundation();
            buildPillars();
            buildWalls();
            buildWindows();
            System.out.println("House is built.");
        }

        //default implementation
        protected void buildWindows() {
            System.out.println("Building Glass Windows");
        }

        //methods to be implemented by subclasses
        public abstract void buildWalls();

        public abstract void buildPillars();

        private void buildFoundation() {
            System.out.println("Building foundation with cement,iron rods and sand");
        }
    }

    static class WoodenHouse extends HouseTemplate {

        @Override
        public void buildWalls() {
            System.out.println("Building Wooden Walls");
        }

        @Override
        public void buildPillars() {
            System.out.println("Building Pillars with Wood coating");
        }
    }

    static class GlassHouse extends HouseTemplate {

        @Override
        public void buildWalls() {
            System.out.println("Building Glass Walls");
        }

        @Override
        public void buildPillars() {
            System.out.println("Building Pillars with glass coating");
        }

        @Override
        protected void buildWindows() {
            System.out.println("Building Non-Glass Windows");
        }
    }
}
