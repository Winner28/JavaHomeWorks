package Module_6_Collections.Task_One;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class PropertyMap {

    private HashMap<String, String> propertyMap;
    private Properties properties;
    private File file;


    public PropertyMap() {
        propertyMap = new HashMap<>();
        properties = new Properties();
    }



    private boolean propFileExists(String nameOfFile) {
        try {

            String realName = "./src/main/resources/" + nameOfFile.trim() + ".properties";
            FileInputStream fileInputStream = new FileInputStream(realName);
            properties.load(fileInputStream);

        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found");
        } catch (IOException e) {
            throw new RuntimeException("Properties failed");
        }


        return true;
    }



    public HashMap<?, ?> writeInMap(String propName) {
        propFileExists(propName);

        Set set = properties.keySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()) {
            String key = String.valueOf(iterator.next());
            propertyMap.put(key, properties.getProperty(key));
        }

        return propertyMap;
    }

}
