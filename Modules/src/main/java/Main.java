import Module_8_JDBC.Task_One.JdbcHelloWorld;

import java.io.FilterReader;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

public interface Main {
    static void main(String[] args) throws InterruptedException, IOException, ClassNotFoundException, SQLException {
        JdbcHelloWorld helloWorld = new JdbcHelloWorld();
        helloWorld.insert("asdad",123.3);

        helloWorld.updateRow(6, "YBIVATOR", 13.13);
        helloWorld.showDB();

    }


    public static Map<String, Long> counter(List<String> stringList) {
        return stringList.stream()
                .collect(Collectors.groupingBy(str -> str,Collectors.counting()));
    }

}
