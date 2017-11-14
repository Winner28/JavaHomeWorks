package Module_8_JDBC.Task_Two.DAO;

import Module_8_JDBC.Task_Two.model.Gun;
import lombok.SneakyThrows;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

interface GunDAOINT {


    String deleteById      = "DELETE FROM Gun WHERE id=?";
    String deleteByCaliber = "DELETE FROM Gun WHERE caliber=?";
    String deleteByName    = "DELETE FROM Gun WHERE name=?";

    String updateRow       = "UPDATE Gun SET name=?,caliber=? WHERE id=?";
    String insertRow       = "INSERT INTO Gun (name,caliber) VALUES (?, ?)";

    String showBase        = "SELECT * FROM Gun";
    String dropBase        = "DROP TABLE Gun";

    String getById         = "SELECT * FROM Gun WHERE id=?";
    String getByCaliber    = "SELECT * FROM Gun WHERE caliber=?";
    String getByName       = "SELECT * FROM Gun WHERE name=?";


    /**
     *
     * Methods
     *
     */

    Optional<Set<Gun>> getAllGuns();
    Optional<Gun> getGunById(int id);
    Optional<List<Gun>> getGunsByName(String name);
    Optional<List<Gun>> getGunsByCaliber(Double caliber);

    void updateGun(int id, String name, Double caliber);
    void insertGun(String name, Double caliber);

    void deleteGun(int id);
    void deleteGun(String name);
    void deleteGun(Double caliber);

    void dropTable();




    default void withConnection(Consumer<Connection> connectionConsumer, Connection connection) {
        connectionConsumer.accept(connection);
    }


    default <T> T mapConnection(Function<Connection, T> connectionTFunction, Connection connection) {
        return connectionTFunction.apply(connection);
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

    default <T> T mapStatement(Function<Statement, T> statementTFunction, Connection reallyConnection) {
        return mapConnection(connection -> {
            try(Statement statement = connection.createStatement()) {
                return statementTFunction.apply(statement);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }, reallyConnection);
    }


    default void withPreparedStatement(Consumer<PreparedStatement> preparedStatement, Connection reallyConnection, String SQL) {
        withConnection(connection -> {
            // Bez etogo bloka try ne xo4et rabotat, po4emy???
            try (Statement statement = connection.createStatement()) {
                statement.execute(getInitSql());
            } catch (SQLException e) {
                e.printStackTrace();
            }


            try(PreparedStatement ps = connection.prepareStatement(SQL)) {
                preparedStatement.accept(ps);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }, reallyConnection);
    }

    default <T> T mapPreparedStatement(Function<PreparedStatement, T> preparedStatement, Connection reallyConnection, String SQL) {
        return mapStatement(statement -> {
            try {
                statement.execute(getInitSql());
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try (PreparedStatement ps = reallyConnection.prepareStatement(SQL)) {
                return preparedStatement.apply(ps);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }, reallyConnection);
    }



    default <T> T mapStatementResultSet(Function<ResultSet, T> resultSetTFunction, Connection reallyConnection, String SQL) {
        return mapStatement(statement -> {
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

            return resultSetTFunction.apply(resultSet);
        }, reallyConnection);
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


    default Set<Gun> getGuns(ResultSet resultSet) {
        Set<Gun> gunSet = new HashSet<>();
        try {
            while(resultSet.next()) {
                gunSet.add(new Gun().setId(resultSet.getInt(1))
                        .setName(resultSet.getString(2))
                        .setCaliber(resultSet.getDouble(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gunSet;
    }



    default Gun getGun(ResultSet resultSet) {
        Gun gun = new Gun();
        try {
            while(resultSet.next()) {
                gun.setId(resultSet.getInt(1))
                        .setName(resultSet.getString(2))
                        .setCaliber(resultSet.getDouble(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gun;
    }

    default List<Gun> getGunsByParam(ResultSet resultSet) {
        List<Gun> gunList = new ArrayList<>();
        try {
            while(resultSet.next()) {
                gunList.add(new Gun().setId(resultSet.getInt(1))
                        .setName(resultSet.getString(2))
                        .setCaliber(resultSet.getDouble(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return gunList;
    }



}
