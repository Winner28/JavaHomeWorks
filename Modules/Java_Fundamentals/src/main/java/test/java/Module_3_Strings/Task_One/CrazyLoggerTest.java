package test.java.Module_3_Strings.Task_One;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CrazyLoggerTest {


    //format : dd-MM-yyyy hh:mm


    @Test
    void Simple_Tests()  {

        String message = "A new logg!";

        CrazyLogger crazyLogger = new CrazyLogger();

        crazyLogger.writeLog(message);

        StringBuilder testBuilder = new StringBuilder().append(message);
        //passed
        assertNotEquals(testBuilder, crazyLogger.getStringBuilder());
        //passed
        assertEquals(crazyLogger.getStringBuilder().toString().trim(), crazyLogger.getLogByMessage(message).trim());

        ////

        crazyLogger.writeLog("10-05-1997 19:35", "Greetings");

        //passed
        assertEquals("10-05-1997 07:35 - Greetings\n", crazyLogger.getLogByMessage("Greetings"));


        //passed
        assertEquals("10-05-1997 07:35 - Greetings\n", crazyLogger.getLogsByMonth(5));


        //passed
        assertEquals("10-05-1997 07:35 - Greetings\n", crazyLogger.getLogsByYear(1997));
    }



   @Test
    void Testing_File_IO() {

       String filename = "your_file_path";
       CrazyLogger crazyLogger = new CrazyLogger();
       String message = "I`m IO test!";
       crazyLogger.writeLog(message);
       crazyLogger.flushToFile(filename);
       StringBuilder stringBuilder = crazyLogger.getStringBuilder();
       crazyLogger.readFromFile(filename);
       assertEquals(stringBuilder, crazyLogger.getStringBuilder());

   }



}