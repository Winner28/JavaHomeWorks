package Module_vvFour_IO.Task_One_Two;

public interface OperReader {

    String [] keyWords =  {"byte" , "short" , "int", "if", "else", "switch", "break", "continue", "for"};

    void readFile(String frFile);
    void writetoFile(String tFile);
    void writetoFileByte(String tFile);

}
