package module4.lecture8.controllers;

import com.google.gson.Gson;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import module3.lecture8.todo.Task;
import module4.lecture8.controllers.beans.ClientBean;
import module4.lecture8.services.ClientService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;
import java.util.UUID;

@WebServlet(name = "ClientController2", value = "/clients")
public class ClientController extends HttpServlet {
    private ClientService clientService;

    private Gson gson;

    @Override
    public void init(final ServletConfig config) throws ServletException {
        this.clientService = ClientService.getInstance();
        this.gson = new Gson();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if ("PATCH".equalsIgnoreCase(req.getMethod())) {
            doPatch(req, resp);
        } else {
            super.service(req, resp);
        }
    }

    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        final String id = req.getParameter("id");
        if (Objects.isNull(id)) {
            resp.getWriter().println(gson.toJson(clientService.getAll()));
        } else {
            resp.getWriter().println(gson.toJson(clientService.get(UUID.fromString(id))));
        }
    }

    @Override
    protected void doPost(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        try (BufferedReader reader = req.getReader();
             PrintWriter writer = resp.getWriter();
        ) {
            ClientBean bean = gson.fromJson(reader, ClientBean.class);
            final UUID uuid = clientService.create(bean);
            writer.println(gson.toJson(uuid));
        }
    }

    @Override
    protected void doPut(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        try (BufferedReader reader = req.getReader()) {
            ClientBean bean = gson.fromJson(reader, ClientBean.class);
            clientService.update(bean);
        }
    }

    @Override
    protected void doPatch(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        final String id = Objects.requireNonNull(req.getParameter("id"));
        clientService.restore(UUID.fromString(id));
    }

    @Override
    protected void doDelete(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        final String id = Objects.requireNonNull(req.getParameter("id"));
        clientService.delete(UUID.fromString(id));
    }
}
