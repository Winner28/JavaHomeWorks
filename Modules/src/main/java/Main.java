import Module_8_JDBC.Task_Two.DAO.GunDAO;
import Module_8_JDBC.Task_Two.model.Gun;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

public interface Main {
    static void main(String[] args) throws InterruptedException, IOException, ClassNotFoundException, SQLException {
        GunDAO gunDAO = new GunDAO();

        Set<Gun> gunHashSet = gunDAO.getAllGuns().get();
        System.out.println(gunHashSet);

        System.out.println(gunDAO.getGunById(3).get());


    }


    static Map<String, Long> counter(List<String> stringList) {
        return stringList.stream()
                .collect(Collectors.groupingBy(str -> str,Collectors.counting()));
    }

}
