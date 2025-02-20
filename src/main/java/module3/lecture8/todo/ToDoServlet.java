package module3.lecture8.todo;

import com.google.gson.Gson;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

@WebServlet(name = "ToDoServlet", value = "/tasks")
public class ToDoServlet extends HttpServlet {

    private static final Map<UUID, Task> TASK_MAP = new HashMap<>();

    private static final Gson GSON = new Gson();

    private final TaskCreator taskCreator;

    private final TaskGetter taskGetter;

    public ToDoServlet() {
        taskCreator = new TaskCreator();
        taskGetter = new TaskGetter();
    }

    @SneakyThrows
    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) {
        final String id = req.getParameter("id");
        final List<Task> tasks = taskGetter.get(id, TASK_MAP);
        resp.getWriter().append(GSON.toJson(tasks));
    }

    @SneakyThrows
    @Override
    protected void doPost(final HttpServletRequest req, final HttpServletResponse resp) {
        Task task = taskCreator.createTask(req);
        TASK_MAP.put(task.getId(), task);
        resp.getWriter().append("%s".formatted(task.getId()));
    }

    @SneakyThrows
    @Override
    protected void doPut(final HttpServletRequest req, final HttpServletResponse resp) {
        super.doPut(req, resp);
    }

    @SneakyThrows
    @Override
    protected void doDelete(final HttpServletRequest req, final HttpServletResponse resp) {
        super.doDelete(req, resp);
    }
}
