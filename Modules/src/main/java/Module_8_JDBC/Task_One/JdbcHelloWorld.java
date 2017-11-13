package Module_8_JDBC.Task_One;

import javax.swing.plaf.nimbus.State;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.Properties;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JdbcHelloWorld implements jdbcOperations {


    private String url;

    public JdbcHelloWorld() throws ClassNotFoundException {
        Class.forName((String) properties.remove("driver"));
        this.url = (String) properties.remove("url");
    }



    private static Properties properties = new Properties() {
        public Properties load(String path) {
            try (InputStream inputStream = getClass().getResourceAsStream(path)) {
                load(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return this;
        }
    }.load("/jdbc.properties");






    @Override
    public void updateRow(int id, String gunName, Double clr) {

        try (Connection connection = DriverManager.getConnection(url, properties);
             Statement statement = connection.createStatement()){
            statement.execute(getInitSql());

            try(PreparedStatement preparedStatement = connection.prepareStatement(jdbcOperations.updateRow)) {
                preparedStatement.setString(1, gunName);
                preparedStatement.setDouble(2, clr);
                preparedStatement.setInt(3, id);
                preparedStatement.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void showDB() {
        try(Connection connection = DriverManager.getConnection(url, properties);
        Statement statement = connection.createStatement()) {
            statement.execute(getInitSql());
            try (ResultSet resultSet = statement.executeQuery(jdbcOperations.SQLshow)) {
                System.out.println("Gun Base: ");
                while(resultSet.next()) {
                    System.out.printf("%d %s %f", resultSet.getInt(1), resultSet.getString(2),
                            resultSet.getDouble(3));
                    System.out.println();

                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insert(String gunName, Double clr) {
        try (Connection connection = DriverManager.getConnection(url, properties);
             Statement statement = connection.createStatement()){
            statement.execute(getInitSql());

           try(PreparedStatement preparedStatement = connection.prepareStatement(jdbcOperations.insertRow)) {
                preparedStatement.setString(1, gunName);
                preparedStatement.setDouble(2, clr);
                preparedStatement.execute();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void dropTable() {
        try(Connection connection = DriverManager.getConnection(url, properties);
            Statement statement = connection.createStatement()) {
            statement.execute(getInitSql());
            statement.executeUpdate(jdbcOperations.dropBase);
            System.out.println("dropped");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }







}
