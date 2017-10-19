package Module_3_Strings.Task_One;

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
            stringBuilder.append(simpleDateFormat.format(rDate)).append(" - ").append(message);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void writeLog(String message) {
        Date today = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm");
        stringBuilder.append(simpleDateFormat.format(today)).append(" - ").append(message).append("\n");
    }


    @Override
    public String getLogByMessage(String message) {
        StringBuilder result = new StringBuilder();
        String[] msg = stringBuilder.toString().split("\n");
        for (String s : msg) {
            if (s.contains(message)) {
                result.append(s).append("\n");
            }
        }

        return result.toString();
    }


    @Override
    public String getLogsByMonth(int month) {
        if (month  > 12 || month < 1) throw new RuntimeException("Incorrect month");
        StringBuilder result = new StringBuilder();
        String[] msg = stringBuilder.toString().split("\n");
        for (String s : msg) {
            if (monthChecker(s, month)) {
                result.append(s).append("\n");
            }
        }
        return result.toString();
    }

    @Override
    public String getLogsByYear(int year) {
        if (String.valueOf(year).length() < 4) return "Incorrect year";
        StringBuilder result = new StringBuilder();
        String[] msg = stringBuilder.toString().split("\n");
        for (String s : msg) {
            if (yearChecker(s, year)) {
                result.append(s).append("\n");
            }
        }
        return result.toString();
    }


    @Override
    public void flushToFile(String filename) {
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(filename))) {
            printWriter.write(stringBuilder.toString());
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void readFromFile(String filename) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
            String read;
            this.stringBuilder.setLength(0);
            while ((read = bufferedReader.readLine()) != null) {
                this.stringBuilder.append(read).append("\n");
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private boolean monthChecker(String message, int month) {
        if (month < 10) {
            return Integer.parseInt(String.valueOf(message.charAt(4))) == month;
        }

        return Integer.valueOf(message.charAt(3) + String.valueOf(message.charAt(4))) == month;
    }


    private boolean yearChecker(String message, int year) {
        return Integer.valueOf(message.charAt(6) + String.valueOf(message.charAt(7))
                + message.charAt(8) + String.valueOf(message.charAt(9))) == year;
    }

    @Override
    public int hashCode() {
        int res = 31;
        res = res * 31 + stringBuilder.hashCode();
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