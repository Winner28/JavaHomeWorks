package Module_8_JDBC.Task_One;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface jdbcOperations {

     String updateRow = "UPDATE Gun SET name=?,caliber=? WHERE id=?";
     String insertRow = "INSERT INTO Gun (name,caliber) VALUES (?, ?)";
     String SQLshow   = "SELECT * FROM Gun";
     String dropBase  = "DROP TABLE Gun";


    void updateRow(int id, String gunName, Double clr);
    void showDB();
    void insert(String gunName, Double clr);
    void dropTable();


    default String getInitSql() {
        try (Stream<String> lines = Files.lines(
                Paths.get("./src/main/resources/h2.sql"),
                StandardCharsets.UTF_8)) {
            return lines.collect(Collectors.joining());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



}
