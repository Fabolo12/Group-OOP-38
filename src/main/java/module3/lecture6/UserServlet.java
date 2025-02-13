package module3.lecture6;

import com.google.gson.Gson;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

// http://localhost:8080/user-program/users

@WebServlet(name = "UserServlet", value = "/users")
public class UserServlet extends HttpServlet {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServlet.class);

    private final List<User> users = new ArrayList<>();

    private final Gson gson = new Gson();

    @Override
    public void init(final ServletConfig config) {
        LOGGER.info("Init UserServlet");
        createUsers();
    }


    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        try (final PrintWriter writer = resp.getWriter()) {
            writer.println(gson.toJson(users));
        }
    }

    @Override
    protected void doPost(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        final UUID id = UUID.randomUUID();
        final String name = Objects.requireNonNullElse(req.getParameter("name"), "Default name");
        final int age = Integer.parseInt(Objects.requireNonNullElse(req.getParameter("age"), "18"));
        final User user = new User(id, name, age);
        users.add(user);
        try (final PrintWriter writer = resp.getWriter()) {
            writer.println(String.format("{\"message\": \"User with id [%s] created!\"", id));
        }
    }

    @Override
    protected void doPut(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        final HttpSession session = req.getSession();
        System.out.println("Session id: " + session.getId());
        final UUID userId = (UUID) session.getAttribute("userId");

        if (userId == null) {
            final UUID uuid = UUID.randomUUID();
            session.setAttribute("userId", uuid);
            try (final PrintWriter writer = resp.getWriter()) {
                writer.println(String.format("{\"message\": \"Create attribute userId\"}"));
            }
        } else {
            try (final PrintWriter writer = resp.getWriter()) {
                writer.println(String.format("{\"message\": \"Get attribute userId {%s}\"}", userId));
            }
        }

        final String id = Objects.requireNonNull(req.getParameter("id"));
        final User user = users.stream()
                .filter(u -> u.getId().toString().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        final String name = Objects.requireNonNull(req.getParameter("name"));
        user.setName(name);
        try (final PrintWriter writer = resp.getWriter()) {
            writer.println(String.format("{\"message\": \"User was changed!\"}", userId));
        }
    }

    @Override
    protected void doDelete(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        final String id = Objects.requireNonNull(req.getParameter("id"));
        users.removeIf(u -> u.getId().toString().equals(id));

        try (final PrintWriter writer = resp.getWriter()) {
            writer.println("{\"message\": \"User was deleted!\"}");
        }
    }

    private void createUsers() {
        users.add(new User(UUID.randomUUID(), "John", 25));
        users.add(new User(UUID.randomUUID(), "Jane", 30));
        users.add(new User(UUID.randomUUID(), "Alice", 35));
    }


}

