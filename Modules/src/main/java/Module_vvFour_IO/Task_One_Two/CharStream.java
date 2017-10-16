package Module_vvFour_IO.Task_One_Two;

import java.io.*;
import java.util.ArrayList;

public class CharStream implements OperReader {


    private int counter;
    private String fromFile;
    private ArrayList<String> stringList;

    public CharStream() {
        stringList = new ArrayList<>();
    }


    @Override
    public void readFile(String frFile) {
       try (BufferedReader bufferedReader = new BufferedReader(new FileReader(frFile))) {
            this.fromFile = frFile;
            String line;
            while ((line = bufferedReader.readLine())!=null) {
                for (String s: OperReader.keyWords) {
                    if (line.contains(s)) {
                       if (wordChecker(s)) {
                           stringList.add(s);
                           counter++;
                       }
                    }
                }
            }
       } catch (IOException e) {
           fromFile = "";
           e.printStackTrace();
       }



    }

    @Override
    public void writetoFile(String tFile) {
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(tFile))) {
            printWriter.write("Reading from file: " + fromFile + "\n");
            printWriter.write("Total key words: " + counter + "\n");
            for (String word : stringList) {
                printWriter.write(word+ "   ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private boolean wordChecker(String word) {
        return !stringList.contains(word);
    }


}
