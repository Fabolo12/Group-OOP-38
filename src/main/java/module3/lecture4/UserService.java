package module3.lecture4;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

// CTRL + SHIFT + T
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Метод, который использует зависимость (Mockito позволит мокировать userRepository)
    public User getUserById(int id) {
        return userRepository.findById(id).orElseThrow(() -> new NoSuchElementException("User not found"));
//        return new User(1, "John");
    }

    public User getUserByIdAndRandom(int id) {
        final int random = new Random().nextInt(100);
        return userRepository.findById(id, random).orElseThrow(() -> new NoSuchElementException("User not found"));
    }

    // Метод для изменения состояния объекта (можно проверить в тестах)
    public void updateUser(User user) {
        user.setUpdatedAt(new Date());
        userRepository.save(user);
    }

    // Метод с исключением (JUnit позволяет тестировать его выбрасывание)
    public void deleteUser(int id) {
        boolean exists = userRepository.existsById(id);
        if (!exists) {
            throw new IllegalArgumentException("User does not exist");
        }
        userRepository.deleteById(id);
    }

    // Метод, использующий лямбда-выражение (Mockito можно использовать для проверки вызовов)
    public void processUsers(List<User> users, UserProcessor processor) {
        for (User user : users) {
            processor.process(user);
        }
    }

    // Финальный метод (для тестов с Mockito необходимо специальное расширение)
    public final String getServiceName() {
        return "User Service";
    }
}
