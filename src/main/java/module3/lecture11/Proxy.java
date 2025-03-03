package module3.lecture11;

public class Proxy {

    public static void main(String[] args) {
        System.out.println("> Main start");

        System.out.println("> Create ExpensiveObject object");
        ExpensiveObject object = new ExpensiveObjectMockProxy();

        System.out.println("> Processing ExpensiveObject object");
        object.process();

        System.out.println("> Processing ExpensiveObject object again");
        object.process();
    }

    interface ExpensiveObject {
        void process();
    }

    static class ExpensiveObjectImpl implements ExpensiveObject {

        public ExpensiveObjectImpl() {
            heavyInitialConfiguration();
        }

        @Override
        public void process() {
            System.out.println("processing complete.");
        }

        private void heavyInitialConfiguration() {
            System.out.println("Loading initial configuration...");
        }
    }

    static class ExpensiveObjectProxy implements ExpensiveObject {
        private static ExpensiveObject object;

        @Override
        public void process() {
            if (object == null) {
                object = new ExpensiveObjectImpl();
            }
            object.process();
        }
    }

    static class ExpensiveObjectTimeLogProxy extends ExpensiveObjectImpl {
        @Override
        public void process() {
            System.out.println("Time log start");
            super.process();
            System.out.println("Time log end");
        }
    }
    static class ExpensiveObjectMockProxy implements ExpensiveObject {
        @Override
        public void process() {
            System.out.println("Mock processing complete.");
        }
    }
}
