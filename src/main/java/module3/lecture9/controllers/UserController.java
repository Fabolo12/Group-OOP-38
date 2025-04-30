package module3.lecture9.controllers;

import com.google.gson.Gson;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import module3.lecture9.services.UserService;

import java.io.PrintWriter;

@WebServlet(name = "ClientController", value = "/users2")
public class UserController extends HttpServlet {

    private final UserService userService;

    private final Gson gson;

    public UserController(final UserService userService) {
        this.userService = userService;
        this.gson = new Gson();
    }

    @SneakyThrows
    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) {
        checkRights(req);
        try (final PrintWriter writer = resp.getWriter()) {
            writer.println(gson.toJson(userService.getUsers()));
        }
    }

    private void checkRights(final HttpServletRequest req) {
        // check rights
    }
}
