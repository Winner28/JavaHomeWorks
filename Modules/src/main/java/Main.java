import Module_4_IO.Task_wFour.Actor.Actor;
import Module_4_IO.Task_wFour.Hollywood.Hollywood;
import Module_4_IO.Task_wFour.Hollywood.PictureCreator;
import Module_4_IO.Task_wFour.Serialize;
import Module_5_Exceptions.Task_One.FileSystem;
import Module_5_Exceptions.Task_Two.PropertyManager;

public interface Main {

     static void main(String[] args) throws Throwable {
         PropertyManager propertyManager = new PropertyManager();
         propertyManager.showPropFile("file1.properties");
         System.out.println(propertyManager.showValueByKey("file1.properties", "1"));
    }
}
