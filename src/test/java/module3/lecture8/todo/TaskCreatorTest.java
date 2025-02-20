package module3.lecture8.todo;

import com.google.gson.Gson;
import jakarta.servlet.http.HttpServletRequest;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class TaskCreatorTest {

    private TaskCreator target;

    private HttpServletRequest req;

    private Gson gson;

    @BeforeEach
    void setUp() {
        target = new TaskCreator();
        req = Mockito.mock(HttpServletRequest.class);
        gson = new Gson();
    }

    @SneakyThrows
    @Test
    void createTask() {
        // precondition
        Mockito.when(req.getReader()).thenReturn(null);

        Assertions.assertThrows(NullPointerException.class, () -> target.createTask(req));
    }
}