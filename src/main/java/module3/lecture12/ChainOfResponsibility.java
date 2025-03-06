package module3.lecture12;

public class ChainOfResponsibility {

    public static void main(String[] args) {
        DispenseChain c1 = new Dollar50Dispenser();
        DispenseChain c2 = new Dollar20Dispenser();
        DispenseChain c3 = new Dollar10Dispenser();

        // set the chain of responsibility
        c1.setNextChain(c2);
        c2.setNextChain(c3);

        int amount = 180;
        c1.dispense(new Currency(amount));
    }


    interface DispenseChain {

        void setNextChain(DispenseChain nextChain);

        void dispense(Currency cur);
    }

    record Currency(int amount) {
    }

    static class Dollar50Dispenser implements DispenseChain {

        private DispenseChain chain;

        @Override
        public void setNextChain(DispenseChain nextChain) {
            this.chain = nextChain;
        }

        @Override
        public void dispense(Currency cur) {
            if (cur.amount() >= 50) {
                int num = cur.amount() / 50;
                int remainder = cur.amount() % 50;
                System.out.println("Dispensing " + num + " 50$ note");
                if (remainder != 0) {
                    this.chain.dispense(new Currency(remainder));
                }
            } else {
                this.chain.dispense(cur);
            }
        }
    }

    static class Dollar20Dispenser implements DispenseChain {

        private DispenseChain chain;

        @Override
        public void setNextChain(DispenseChain nextChain) {
            this.chain = nextChain;
        }

        @Override
        public void dispense(Currency cur) {
            if (cur.amount() >= 20) {
                int num = cur.amount() / 20;
                int remainder = cur.amount() % 20;
                System.out.println("Dispensing " + num + " 20$ note");
                if (remainder != 0) {
                    this.chain.dispense(new Currency(remainder));
                }
            } else {
                this.chain.dispense(cur);
            }
        }
    }

    static class Dollar10Dispenser implements DispenseChain {

        private DispenseChain chain;

        @Override
        public void setNextChain(DispenseChain nextChain) {
            this.chain = nextChain;
        }

        @Override
        public void dispense(Currency cur) {
            if (cur.amount() >= 10) {
                int num = cur.amount() / 10;
                int remainder = cur.amount() % 10;
                System.out.println("Dispensing " + num + " 10$ note");
                if (remainder != 0) {
                    this.chain.dispense(new Currency(remainder));
                }
            } else {
                if (this.chain != null) {
                    this.chain.dispense(cur);
                }
            }
        }
    }
}
