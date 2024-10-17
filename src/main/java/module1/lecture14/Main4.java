package module1.lecture14;

public class Main4 {

    public static void main(String[] args) {
        final People people = new People();
        final People.Brain brain1 = people.new Brain();

        People.Brain brain = new People().new Brain();

        People.Brain2 brain2 = new People.Brain2();
    }

}

class People {
    public void think() {
        Brain brain = new Brain();
        System.out.println("I'm thinking about " + brain);
    }

    class Brain {

    }

    static class Brain2 {

    }
}

