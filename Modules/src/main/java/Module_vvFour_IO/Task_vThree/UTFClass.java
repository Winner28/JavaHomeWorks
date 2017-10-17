package Module_vvFour_IO.Task_vThree;

import java.io.*;
import java.nio.CharBuffer;

public class UTFClass implements UTFOperations {

    private String utfString;

    public UTFClass() {
    }

    @Override
    public void readUTF8(String frFile) {
        int bufferSize = 1024;
        CharBuffer charBuffer = CharBuffer.allocate(bufferSize);
        try (Reader reader = new BufferedReader(new InputStreamReader(new FileInputStream(frFile), "UTF-8"))) {
           reader.read(charBuffer);
           charBuffer.flip();
           setUtfString(charBuffer.toString());
       } catch (IOException e) {
           setUtfString("EXCEPTION");
           e.printStackTrace();
       } finally {
            charBuffer.clear();
        }
    }



    @Override
    public void writeUTF16(String tFile) {
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(tFile), "UTF-16"))) {
            writer.write(utfString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    private void setUtfString(String utfString) {
        this.utfString = utfString;
    }


}
