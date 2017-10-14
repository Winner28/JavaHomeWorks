package Module_vThree_Strings.Task_One;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class CrazyLoggerTest {


    @Test
    void test_one()  {

        CrazyLogger crazyLogger = new CrazyLogger();
        String message = "A new logg!";
        crazyLogger.writeLog(message);


    }



   @Test
    void Testing_File_IO() {
       CrazyLogger crazyLogger = new CrazyLogger();
       String message = "I`m IO test!";
       crazyLogger.writeLog(message);
       crazyLogger.flushToFile("/home/vladey/Desktop/text.txt");
       StringBuilder stringBuilder = crazyLogger.getStringBuilder();
       crazyLogger.readFromFile("/home/vladey/Desktop/text.txt");
       assertEquals(stringBuilder, crazyLogger.getStringBuilder());

   }



}