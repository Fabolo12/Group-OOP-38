package module4.lecture7;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

public class Main {

    private static final String url = "jdbc:postgresql://localhost:5433/TestBase";
    private static final String user = "postgres";
    private static final String password = "root";
    private static final String idParam = "c62cf0a0-4905-4ca0-b09e-0392e54ec40b";

    @SneakyThrows
    public static void main(String[] args) {
//        Class.forName("org.postgresql.Driver");
//        simpleConnect();
        printAllData();
        withoutTransaction();
        printAllData();
        withTransaction();
        printAllData();
    }

    @SneakyThrows
    private static void withoutTransaction() {
        final Connection connection = DriverManager.getConnection(url, user, password);
        final Statement statement = connection.createStatement();
        try {
            statement.execute("UPDATE table3 set age = 1000");
            brokenCommand();
            statement.execute("UPDATE table3 set age = 3000");
        } catch (RuntimeException e) {
            System.err.println("Exception: " + e.getMessage());
        } finally {
            connection.close();
        }
    }

    @SneakyThrows
    private static void withTransaction() {
        final Connection connection = DriverManager.getConnection(url, user, password);
        connection.setAutoCommit(false);
        final Statement statement = connection.createStatement();
        try {
            statement.execute("UPDATE table3 set age = 1000");
            brokenCommand();
            statement.execute("UPDATE table3 set age = 3000");
            connection.commit();
        } catch (RuntimeException e) {
            System.err.println("Exception: " + e.getMessage());
            connection.rollback();
        } finally {
            connection.close();
        }
    }

    @SneakyThrows
    private static void brokenCommand() {
        throw new RuntimeException("Broken command");
    }

    @SneakyThrows
    private static void printAllData() {
        try (final Connection connection = DriverManager.getConnection(url, user, password)) {
            final Statement statement = connection.createStatement();
            final ResultSet resultSet = statement.executeQuery("""
                    SELECT * FROM table3
                    """);

            while (resultSet.next()) {
                final String id = resultSet.getString("id");
                final String name = resultSet.getString("name");
                final int age = resultSet.getInt("age");
                final boolean active = resultSet.getBoolean("active");
                final Date date = resultSet.getDate("modificationTimestamp");

                System.out.println("""
                        id: %s
                        name: %s
                        age: %d
                        active: %b
                        modificationTimestamp: %s
                        """.formatted(id, name, age, active, date));
            }
        }
    }

    @SneakyThrows
    private static void simpleConnect() {
        try (final Connection connection = DriverManager.getConnection(url, user, password)) {
            final Statement statement = connection.createStatement();
            final boolean executed = statement.execute("""
                    UPDATE table3 set age = 1000
                    WHERE id = '%s'
                    """.formatted(idParam)); // WHERE id = 'guid' or ''=''
            System.out.println("Executed statement: " + executed);
        }

        try (final Connection connection = DriverManager.getConnection(url, user, password)) {
            final PreparedStatement preparedStatement = connection.prepareStatement("""
                            DELETE FROM table3
                            WHERE name = ?
                    """);
            preparedStatement.setObject(1, idParam + "' or ''='", java.sql.Types.OTHER);
            final boolean executed = preparedStatement.execute();
            System.out.println("Executed preparedStatement: " + executed);
        }
    }
}
