import Module_8_JDBC.Task_One.JdbcHelloWorld;
import Module_8_JDBC.Task_Two.DAO.GunDAO;

import java.io.FilterReader;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

public interface Main {
    static void main(String[] args) throws InterruptedException, IOException, ClassNotFoundException, SQLException {
        GunDAO gunDAO = new GunDAO();
        gunDAO.getAllGuns();

    }


    public static Map<String, Long> counter(List<String> stringList) {
        return stringList.stream()
                .collect(Collectors.groupingBy(str -> str,Collectors.counting()));
    }

}
