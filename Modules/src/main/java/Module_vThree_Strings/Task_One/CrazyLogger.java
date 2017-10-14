package Module_vThree_Strings.Task_One;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CrazyLogger implements CrazyLoggerApi {

    private StringBuilder stringBuilder;


    public CrazyLogger() {

        stringBuilder = new StringBuilder();
    }


    @Override
    public void writeLog(String date, String message) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm");
        try {
            Date rDate = simpleDateFormat.parse(date);
            stringBuilder.append(rDate).append(" - ").append(message);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void writeLog(String message) {
        Date today = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm");
        stringBuilder.append(simpleDateFormat.format(today)).append(" - ").append(message);
    }


    @Override
    public String getLogByMessage(String message) {
        return stringBuilder.toString().contains(message) ? message : "Not contains";
    }

    @Override
    public String getLogsByDay(int day) {
        return null;
    }

    @Override
    public String getLogsByMonth(int month) {
        return null;
    }

    @Override
    public String getLogsByYear(int year) {
        return null;
    }



    @Override
    public void flushToFile(String filename) {
        try(PrintWriter printWriter = new PrintWriter(new FileWriter(filename))) {
            printWriter.write(stringBuilder.toString());
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void readFromFile(String filename) {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
            String read;
            while((read = bufferedReader.readLine())!=null) {
                this.stringBuilder.append(read);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public int hashCode() {
        int res = 31;
        res = res*31 + stringBuilder.hashCode();

        return res;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (this.getClass() != object.getClass()) return false;
        return ((CrazyLogger) object).stringBuilder.equals(this.stringBuilder);
    }

    public StringBuilder getStringBuilder() {
        return stringBuilder;
    }
}
