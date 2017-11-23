package Module_4_IO.Task_One_Two;

public interface OperReader {

    String [] keyWords =   {"abstract", "assert", "boolean", "break", "byte",
            "case", "catch", "char", "class", "const",
            "continue", "default", "do", "double", "else",
            "enum", "extends", "final", "finally", "float",
            "for", "goto", "if", "implements", "import",
            "instanceof", "int", "interface", "long", "native",
            "new", "package", "private", "protected", "public",
            "return", "short", "static", "strictfp", "super",
            "switch", "synchronized", "this", "throw", "throws",
            "transient", "try", "void", "volatile", "while"
    };


    void readFile(String frFile);
    void writetoFile(String tFile);
    void writetoFileByte(String tFile);
    void readFileByte(String frFile);

}
