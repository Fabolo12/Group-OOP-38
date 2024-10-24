package module1.lecture21;

import java.util.ArrayList;
import java.util.List;

public class Registration {
    private static List<User> users = new ArrayList<>();


    public static void main(String[] args) {
        registerUser("admin", "admin");
        registerUser("", "admin");
        register("admin", "");
//        register("", "");
        System.out.println("Registered users: ");
        for (User user : users) {
            System.out.println(user);
        }
    }

    private static void registerUser(final String login, final String password) {
        try {
            register(login, password);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    private static void register(final String login, final String password) {
        if (login == null || login.isBlank()) {
            throw new IllegalArgumentException("Login cannot be empty");
        }
        if (password == null || password.isBlank()) {
            throw new IllegalArgumentException("Password cannot be empty");
        }
        final User user = new User(login, password);
        users.add(user);
    }

    record User(String login, String password) {

    }
}
