package Module_5_Exceptions.Task_One;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.io.*;
import java.util.*;


@SuppressWarnings("uncecked")
public class FileSystem implements ProcessSystem {


    private HashMap<File, List<File>> fileSystem;

    public FileSystem() {
        int stand_size = 10;
        fileSystem = new HashMap<>(stand_size);

    }



    private void runIntoFileSystem(File fromFolder) {
        if (fromFolder == null) {
            return;
        }


        File [] folderEntries = fromFolder.listFiles();
        List<File> fileList = new ArrayList<>();

        for (File file : folderEntries) {

            fileList.add(file);
            if (file.isDirectory()) {
                runIntoFileSystem(file);
            }
        }

        fileSystem.put(fromFolder,fileList.subList(0, fileList.size()));


    }

    public void start() {
        System.out.println("Enter a absolute path to start directory, please");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String directory = "";
        try {
             directory = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (directory.equals("")) {
            throw new RuntimeException("Bad directory!");
        }

        File file = new File(directory);

        if (!(file.exists())) {
            throw new RuntimeException("Bad directory!");
        }

        runIntoFileSystem(file);

    }




    @Override
    public void deleteFileInCatalogy() {

    }

    @Override
    public void createFileInCatalogy() {
        getInfo();
        String dirQuest = "In what directory you want to create a file";
        String fileQuest = "Enter name of File";
        String directory = userInput(dirQuest);
        String fileName = userInput(fileQuest);
        File file = new File(directory + "\\" + fileName);
        if ((file.exists())) {
            throw new RuntimeException("File already exists");
        }

        System.out.println("File created!");
    }

    @Override
    public void writeInFile() {

    }

    @Override
    public void addToFile() {

    }


    @Override
    public void getInfo() {
        Iterator iterator = fileSystem.entrySet().iterator();
        while (iterator.hasNext()) {
            System.out.println("*****************");
            Map.Entry pair = (Map.Entry) iterator.next();
            System.out.println("Directory: " + pair.getKey());

            System.out.println("--- Files --- ");
            for (Object file: (List) pair.getValue()) {
                System.out.println(((File)file).getName());
            }

            System.out.println("*****************");
            System.out.println("\n");

        }
    }


    private String userInput(String message) {
        System.out.println(message);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = null;
        try {
            input = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return input.trim();
    }
}
