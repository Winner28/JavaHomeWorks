package main.java.Module_3_Strings.Task_One;

public interface CrazyLoggerApi {

    String getLogByMessage(String message);

    String getLogsByMonth(int month);
    String getLogsByYear(int year);

    void writeLog(String date, String message);
    void writeLog(String message);

    void flushToFile(String filename);
    void readFromFile(String filename);

}

