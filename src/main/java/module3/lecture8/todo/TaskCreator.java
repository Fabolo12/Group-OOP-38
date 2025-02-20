package module3.lecture8.todo;

import com.google.gson.Gson;
import jakarta.servlet.http.HttpServletRequest;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.util.UUID;

public class TaskCreator {

    private static final Gson GSON = new Gson();

    @SneakyThrows
    public Task createTask(final HttpServletRequest req) {
        try (BufferedReader reader = req.getReader()) {
            Task task = GSON.fromJson(reader, Task.class);
            if (task == null) {
                throw new IllegalArgumentException("Task is null");
            }
            task.setId(UUID.randomUUID());
            return task;
        }
    }
}
