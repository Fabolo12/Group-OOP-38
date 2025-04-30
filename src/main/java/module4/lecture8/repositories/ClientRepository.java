package module4.lecture8.repositories;

import lombok.SneakyThrows;
import module4.lecture8.controllers.beans.ClientBean;
import module4.lecture8.models.Client;
import module4.lecture8.repositories.mappers.ClientMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public class ClientRepository extends AbstractRepository {

    private static ClientRepository instance;

    private ClientRepository() {
        super();
    }

    public static ClientRepository getInstance() {
        if (instance == null) {
            instance = new ClientRepository();
        }
        return instance;
    }

    @SneakyThrows
    public Set<Client> getAll() {
        try (final Connection connection = getConnection();
             final Statement statement = connection.createStatement()
        ) {
            final ResultSet resultSet = statement.executeQuery("SELECT * FROM client WHERE active = true");
            final Set<Client> clients = new HashSet<>();
            while (resultSet.next()) {
                clients.add(ClientMapper.map(resultSet));
            }
            return clients;
        }
    }

    @SneakyThrows
    public Optional<Client> get(final UUID id) {
        final String sql = "SELECT * FROM client WHERE id = ?";

        try (final Connection connection = getConnection();
             final PreparedStatement statement = connection.prepareStatement(sql)
        ) {
            statement.setObject(1, id);
            final ResultSet resultSet = statement.executeQuery();
            return resultSet.next() ?
                    Optional.of(ClientMapper.map(resultSet)) : Optional.empty();
        }
    }

    @SneakyThrows
    public UUID create(final ClientBean bean) {
        final String sql = """
                INSERT INTO client (id, name, address, age, active)
                VALUES (?, ?, ?, ?, ?)
                """;
        try (final Connection connection = getConnection();
             final PreparedStatement statement = connection.prepareStatement(sql)
        ) {
            final UUID uuid = UUID.randomUUID();
            statement.setObject(1, uuid);
            statement.setString(2, bean.getName());
            statement.setString(3, bean.getAddress());
            statement.setInt(4, bean.getAge());
            statement.setBoolean(5, true);
            statement.execute();
            return uuid;
        }
    }

    @SneakyThrows
    public void update(final ClientBean bean) {
        final String sql = """
                UPDATE client SET
                name = ?,
                address = ?,
                age = ?
                WHERE id = ?
                """;
        final Client client = get(bean.getId())
                .orElseThrow(() -> new RuntimeException("Client with id " + bean.getId() + " not found."));
        try (final Connection connection = getConnection();
             final PreparedStatement statement = connection.prepareStatement(sql)
        ) {
            final String name = bean.getName() == null ? client.getName() : bean.getName();
            statement.setString(1, name);
            final String address = bean.getAddress() == null ? client.getAddress() : bean.getAddress();
            statement.setString(2, address);
            final int age = bean.getAge() == null ? client.getAge() : bean.getAge();
            statement.setInt(3, age);
            statement.setObject(4, bean.getId());
            statement.execute();
        }
    }

    @SneakyThrows
    public void delete(final UUID id) {
        final String sql = """
                UPDATE client SET
                active = false
                WHERE id = ?
                """;
        try (final Connection connection = getConnection();
             final PreparedStatement statement = connection.prepareStatement(sql)
        ) {
            statement.setObject(1, id);
            statement.execute();
        }
    }

    @SneakyThrows
    public void restore(final UUID id) {
        final String sql = """
                UPDATE client SET
                active = true
                WHERE id = ?
                """;
        try (final Connection connection = getConnection();
             final PreparedStatement statement = connection.prepareStatement(sql)
        ) {
            statement.setObject(1, id);
            statement.execute();
        }
    }
}
