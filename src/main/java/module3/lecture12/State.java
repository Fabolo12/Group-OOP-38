package module3.lecture12;

public class State {
    public static void main(String[] args) {
        TVContext context = new TVContext();

        context.setState(new TVStartState());
        context.doAction();

        context.setState(new TVStopState());
        context.doAction();
    }

    interface States {
        void doAction();
    }

    static class TVStartState implements States {

        @Override
        public void doAction() {
            System.out.println("TV is turned ON");
        }
    }

    static class TVStopState implements States {

        @Override
        public void doAction() {
            System.out.println("TV is turned OFF");
        }
    }

    static class TVContext {

        private States tvState;

        public States getState() {
            return this.tvState;
        }

        public void setState(States state) {
            this.tvState = state;
        }

        public void doAction() {
            this.tvState.doAction();
        }
    }
}
