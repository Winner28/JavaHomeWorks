package Module_4_IO.Task_wFour;

import Module_4_IO.Task_wFour.Hollywood.Hollywood;
import Module_4_IO.Task_wFour.Hollywood.PictureCreator;

import java.io.*;

public class Serialize {
    private PictureCreator hollywood;

    public Serialize() {
        hollywood = new Hollywood();
    }


    public PictureCreator getHollywood() {
        return hollywood;
    }

    public Serialize setHollywood(PictureCreator hollywood) {
        this.hollywood = hollywood;
        return this;
    }


    public void serialize(String filename) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
            objectOutputStream.writeObject(hollywood);
            objectOutputStream.flush();
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void deserialize(String filename) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filename))) {
            Hollywood fileHollywood = (Hollywood)objectInputStream.readObject();
            setHollywood(fileHollywood);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
