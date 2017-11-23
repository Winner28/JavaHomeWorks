package Module_5_Exceptions.Task_One;

import Module_2_OOP.Task_ZSix_Seven.About;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.io.*;
import java.util.*;


@About(
        info =  "FileSystem",
        author = "vlaDey",
        date = "24 of october 2017"
)

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
            throw new UserInputException("Bad directory!");
        }

        File file = new File(directory);

        if (!(file.exists())) {
            throw new UserInputException("Bad directory!");
        }

        runIntoFileSystem(file);

    }




    @Override
    public void deleteFileInCatalogy()  {

        System.out.println("Deleting file");
        String input = userInput("Path to file: ");

        File file = new File(input);
        if (!(file.exists())) {
            throw new UserInputException("Bad directory");
        }

        if (file.delete()) {
            System.out.println("Deleted");
        } else {
            throw new RuntimeException("Smth wrong!");
        }

    }

    @Override
    public void createFileInKnownCatalogy() {
        System.out.println("In what directory you want to create File: ");
        for (File file : fileSystem.keySet()) {
            System.out.println(file.getName());
        }
        String dir = userInput("Choose a directory");
        File dirFile = null;
        for (File file : fileSystem.keySet()) {
            if (file.getName().equals(dir)) {
                dirFile = file;
                break;
            }
        }
        if (dirFile == null) {
            throw new UserInputException("Bad directory name!");
        }

        String fileName = userInput("Enter name of File");
        try {

            File newFile = new File(dirFile.getAbsolutePath() + "/" + fileName);
            if (!(newFile.createNewFile())) {
                throw new IOException("Smth is bad");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void createFileInYourCatalogy() {
        getInfo();
        String dirQuest = "In what directory you want to create File";
        String fileQuest = "Enter name of File";
        String directory = userInput(dirQuest);
        String fileName = userInput(fileQuest);
        File file = new File(directory + "\\" + fileName);
        if ((file.exists())) {
            throw new UserInputException("File already exists!");
        }

        System.out.println("File created!");
    }

    @Override
    public void writeInFile() {
        String file = userInput("Path to file: ");
        File fileCheck = new File(file);
        if (!(fileCheck.exists() && !(fileCheck.isDirectory()))) {
            throw new UserInputException("File not exists || It`s a directory!");
        }

        try (PrintWriter fileWriter = new PrintWriter(new FileWriter(file, true))) {
                String operation = userInput("What you want to write in file?\n 1 - Another file \n 2 - Your msg\n");
                switch (operation) {
                    case "1":
                        String choseFile = userInput("Enter a file path, please: ");
                        File fileCheck2 = new File(choseFile);
                        if (!(fileCheck2.exists() && !(fileCheck2.isDirectory()))) {
                            throw new UserInputException("File not exists || It`s a directory!");
                        }
                        StringBuilder fileread = new StringBuilder();
                        BufferedReader bufferedReader = new BufferedReader(new FileReader(choseFile));
                        String line;
                        while ((line = bufferedReader.readLine())!=null) {
                            fileread.append(line + "\n");
                        }

                        fileWriter.write(fileread.toString());

                        break;
                    case "2":
                        String msg = userInput("Input a msg");
                        fileWriter.write(msg);
                        fileWriter.close();
                        break;
                    default:
                        throw new UserInputException("Bad input");
                }
        } catch (IOException e) {
            e.printStackTrace();
        }
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
