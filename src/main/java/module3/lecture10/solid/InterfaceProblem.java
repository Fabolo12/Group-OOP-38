package module3.lecture10.solid;

public class InterfaceProblem {
    interface Lifeble {
        void breathe();
        void move();
        void sleep();
    }

    abstract class People implements Lifeble {

    }

    abstract class Robot implements Lifeble {

    }
}
