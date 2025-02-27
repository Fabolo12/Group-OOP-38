package module3.lecture9.repositories;

import module3.lecture9.models.User;

import java.util.ArrayList;
import java.util.List;

// DAO - Data Access Object
public class UserRepository {
    private static final List<User> DATA_BASE = new ArrayList<>();

    public List<User> getUsers() {
        return DATA_BASE.stream()
                .distinct()
                .toList();
    }
}
