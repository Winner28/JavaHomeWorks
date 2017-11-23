package Module_7_Threads.Task_Two;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

public class PropertyReader {


    private Properties properties;
    FileInputStream fileInputStream;


    public PropertyReader() {
        properties = new Properties();
    }



    private boolean propFileExists(String nameOfFile) {
        try {
            String realName = "./src/main/resources/" + nameOfFile.trim() + ".properties";
            fileInputStream = new FileInputStream(realName);
            properties.load(fileInputStream);

        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found");
        } catch (IOException e) {
            throw new RuntimeException("Properties failed");
        }


        return true;
    }


    public void read(String nameOfFile) {
        propFileExists(nameOfFile);

        Set set = properties.keySet();
        Iterator iterator = set.iterator();

        while(iterator.hasNext()) {
            String key = String.valueOf(iterator.next());
            System.out.println(Thread.currentThread() + " Key: " + key + " Value: " + properties.getProperty(key));
        }

    }


}
