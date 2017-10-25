package Module_5_Exceptions.Task_Two;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

public class PropertyManager {

    private Properties properties;
    FileInputStream fileInputStream;


    public PropertyManager() {
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


    public void showPropFile(String nameOfFile) {
        propFileExists(nameOfFile);
        Enumeration enumeration = properties.propertyNames();
        Enumeration enumeration1 = properties.keys();
        while(enumeration.hasMoreElements()) {
            System.out.println("Key: " + enumeration1 + " Value: " + enumeration);
        }
    }




    public String showValueByKey(String nameOfFile, String key) {
        propFileExists(nameOfFile);
        String value = properties.getProperty(key);
        if (value == null) {
            throw new NoSuchKeyException("No key");
        }

        return "Key: " + key + " Value: " + value;
    }


    public boolean searchForKey(String nameOfFile,String key) {
        propFileExists(nameOfFile);
        Enumeration keyRation = properties.keys();
        while(keyRation.hasMoreElements()) {
            if (keyRation.nextElement().equals(key)) {
                System.out.println("Existst");
                return true;
            }
        }


        return false;
    }


}
