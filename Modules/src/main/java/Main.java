import Module_4_IO.Task_wFour.Actor.Actor;
import Module_4_IO.Task_wFour.Hollywood.Hollywood;
import Module_4_IO.Task_wFour.Hollywood.PictureCreator;
import Module_4_IO.Task_wFour.Serialize;
import Module_5_Exceptions.Task_One.FileSystem;

public interface Main {

     static void main(String[] args) throws Throwable {
         FileSystem fileSystem = new FileSystem();
         fileSystem.createFileInCatalogy();

    }
}
