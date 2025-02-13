package module3.lecture6;

import com.google.gson.Gson;

import java.util.UUID;

public class Main {

    public static void main(String[] args) {
        final User john = new User(UUID.randomUUID(), "John", 25);
        System.out.println(john);
        final Gson gson = new Gson();
        System.out.println(gson.toJson(john));
    }
}
