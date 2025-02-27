package module3.lecture9.services;

import module3.lecture9.models.User;
import module3.lecture9.repositories.UserRepository;

import java.util.List;

public class UserService {

    private final UserRepository userRepository;

    public UserService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return userRepository.getUsers();
    }
}
