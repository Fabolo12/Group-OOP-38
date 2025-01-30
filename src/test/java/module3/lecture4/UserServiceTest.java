package module3.lecture4;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    private UserService target;

    private UserRepository userRepository;

    private User user;

    @BeforeAll
    static void beforeAll() {
        // create DB
    }

    @AfterAll
    static void afterAll() {
        // remove DB
    }

    @BeforeEach
    void setUp() {
        userRepository = Mockito.mock(UserRepository.class);
        target = new UserService(userRepository);
        user = new User(1, "John");
    }

    @Test
    void getUserByIdSuccess() {
        // precondition
        Mockito.when(userRepository.findById(1)).thenReturn(Optional.of(user));

        // action
        final User actual = target.getUserById(1);

        // assertion
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(user.getId(), actual.getId());
        Assertions.assertEquals(user.getName(), actual.getName());
        Assertions.assertEquals(user.getUpdatedAt(), actual.getUpdatedAt());
        Mockito.verify(userRepository, Mockito.only()).findById(1);
    }

    @Test
    void getUserByIdRandomSuccess() {
        // precondition
        Mockito.when(userRepository.findById(Mockito.eq(1), Mockito.anyInt())).thenReturn(Optional.of(user));

        // action
        final User actual = target.getUserByIdAndRandom(1);

        // assertion
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(user.getId(), actual.getId());
        Assertions.assertEquals(user.getName(), actual.getName());
        Assertions.assertEquals(user.getUpdatedAt(), actual.getUpdatedAt());
    }

    @Test
    void getUserByIdFail() {
        // precondition
        Mockito.when(userRepository.findById(Mockito.eq(1), Mockito.anyInt())).thenReturn(Optional.of(user));

        // action & assertion
        Assertions.assertThrows(NoSuchElementException.class, () -> target.getUserById(2));
    }

    @Test
    void updateUser() {

    }

    @Test
    void deleteUser() {
    }

    @Test
    void processUsers() {
    }

    @Test
    void getServiceName() {
    }
}