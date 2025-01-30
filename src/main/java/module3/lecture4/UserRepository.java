package module3.lecture4;

import java.util.Optional;

// C.R.U.D. operations
public interface UserRepository {
    Optional<User> findById(int id);
    void save(User user);
    boolean existsById(int id);
    void deleteById(int id);

    Optional<User> findById(int id, int random);
}
