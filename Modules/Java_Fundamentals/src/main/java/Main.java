package main.java;

import main.java.Module_8_JDBC.Task_Two.DAO.GunDAO;
import main.java.Module_8_JDBC.Task_Two.model.Gun;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

public interface Main {
    static void main(String[] args) throws InterruptedException, IOException, ClassNotFoundException, SQLException {




    }


    static Map<String, Long> counter(List<String> stringList) {
        return stringList.stream()
                .collect(Collectors.groupingBy(str -> str,Collectors.counting()));
    }

}
