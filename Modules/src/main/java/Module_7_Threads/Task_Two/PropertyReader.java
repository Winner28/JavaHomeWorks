package Module_7_Threads.Task_Two;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

public class PropertyReader {


    private Properties properties;
    FileInputStream fileInputStream;


    public PropertyReader() {
        properties = new Properties();
    }



    private boolean propFileExists(String nameOfFile) {
        try {
            String realName = "./src/main/resources/" + nameOfFile.trim();
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
        Enumeration enumeration = properties.propertyNames();
        Enumeration enumeration1 = properties.keys();
        while(enumeration.hasMoreElements()) {
            System.out.println(Thread.currentThread() + "   Key: " + enumeration1 + " Value: " + enumeration);
        }

    }


}
