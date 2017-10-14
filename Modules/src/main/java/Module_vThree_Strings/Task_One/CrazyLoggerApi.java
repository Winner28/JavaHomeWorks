package Module_vThree_Strings.Task_One;

import java.util.Date;

public interface CrazyLoggerApi {

    String getLogByMessage(String message);
    String getLogsByDay(int day);
    String getLogsByMonth(int month);
    String getLogsByYear(int year);

    void writeLog(String date, String message);
    void writeLog(String message);

    void flushToFile(String filename);
    void readFromFile(String filename);

}

