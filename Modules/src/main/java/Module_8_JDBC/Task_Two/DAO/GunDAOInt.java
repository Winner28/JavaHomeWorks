package Module_8_JDBC.Task_Two.DAO;

import Module_8_JDBC.Task_Two.model.Gun;
import lombok.SneakyThrows;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

interface GunDAOInt {


    String updateRow = "UPDATE Gun SET name=?,caliber=? WHERE id=?";
    String insertRow = "INSERT INTO Gun (name,caliber) VALUES (?, ?)";
    String showBase   = "SELECT * FROM Gun";
    String dropBase  = "DROP TABLE Gun";


    Optional<HashSet<Gun>> getAllGuns();
    Optional<Gun> getGunById();
    Optional<Gun> getGunByName();
    Optional<Gun> getGunsByCaliber();

    void updateGun(int id, String name, Double caliber);
    void insertGun(String name, Double caliber);

    boolean deleteGun(int id);
    boolean deleteGun(String name);
    boolean deleteGun(Double caliber);

    void dropTable();



    default void withConnection(Consumer<Connection> connectionConsumer, Connection connection) {
        connectionConsumer.accept(connection);
    }



    default void withStatement(Consumer<Statement> statementConsumer, Connection reallyConnection) {
        withConnection(connection -> {
            try (Statement statement = connection.createStatement()) {
                statementConsumer.accept(statement);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        },reallyConnection);
    }



    default void withPreparedStatement(Consumer<PreparedStatement> preparedStatement, Connection connection) {
        //TODO
    }

    default void withStatementResultSet(Consumer<ResultSet> resultSetConsumer, Connection connection, String SQL) {
        withStatement(statement ->  {
            try {
                statement.execute(getInitSql());
            } catch (SQLException e) {
                e.printStackTrace();
            }

           ResultSet resultSet = null;
            try {
                resultSet = statement.executeQuery(SQL);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            resultSetConsumer.accept(resultSet);

        }, connection);
    }




    default String getInitSql() {
        try (Stream<String> lines = Files.lines(
                Paths.get("./src/main/resources/h2.sql"),
                StandardCharsets.UTF_8)) {
            return lines.collect(Collectors.joining());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    default void showDB(ResultSet resultSet) {

        System.out.println("GUN BASE: ");
        try {
            while(resultSet.next()) {
                System.out.printf("%d %s %f", resultSet.getInt(1), resultSet.getString(2),
                        resultSet.getDouble(3));
                System.out.println();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
