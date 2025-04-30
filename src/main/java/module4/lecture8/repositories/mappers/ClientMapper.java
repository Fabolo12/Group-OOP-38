package module4.lecture8.repositories.mappers;

import lombok.SneakyThrows;
import module4.lecture8.models.Client;

import java.sql.ResultSet;
import java.util.UUID;

public class ClientMapper {
    @SneakyThrows
    public static Client map(final ResultSet resultSet) {
        final Client client = new Client();
        client.setId(resultSet.getObject("id", UUID.class));
        client.setName(resultSet.getString("name"));
        client.setAddress(resultSet.getString("address"));
        client.setAge(resultSet.getInt("age"));
        client.setActive(resultSet.getBoolean("active"));
        return  client;
    }
}
