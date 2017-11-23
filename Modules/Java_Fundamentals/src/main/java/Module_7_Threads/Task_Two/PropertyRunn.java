package Module_7_Threads.Task_Two;

public class PropertyRunn implements Runnable {


    private PropertyReader propertyReader;
    private String nameOfFile;

    public PropertyRunn(String nameOfFile) {
        this.propertyReader = new PropertyReader();
        this.nameOfFile = nameOfFile;
    }



    @Override
    public void run() {
        propertyReader.read(this.nameOfFile);
    }
}
