package module3.lecture12;

import java.util.ArrayList;
import java.util.List;

public class Mediator {

    public static void main(String[] args) {
        ChatMediator mediator = new ChatMediator();
        User user1 = new User(mediator, "Pankaj");
        new User(mediator, "Lisa");
        new User(mediator, "Saurabh");
        new User(mediator, "David");

        user1.send("Hi All");
    }

    static class User {
        protected ChatMediator mediator;

        protected String name;

        public User(ChatMediator med, String name) {
            this.mediator = med;
            this.mediator.addUser(this);
            this.name = name;
        }

        public void send(String msg) {
            System.out.println(this.name + ": Sending Message=" + msg);
            mediator.sendMessage(msg, this);
        }

        public void receive(String msg) {
            System.out.println(this.name + ": Received Message:" + msg);
        }
    }

    static class ChatMediator {

        private final List<User> users;

        public ChatMediator() {
            this.users = new ArrayList<>();
        }

        public void addUser(User user) {
            this.users.add(user);
        }

        public void sendMessage(String msg, User user) {
            for (User u : this.users) {
                //message should not be received by the user sending it
                if (u != user) {
                    u.receive(msg);
                }
            }
        }
    }


}
