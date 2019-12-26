package javaio.fileio;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOutputStreamTest {

    public void writeBytes(String filePath, String content) throws FileNotFoundException, IOException {
        try (BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(filePath))){
            byte[] bytes = content.getBytes();

            bufferedOutputStream.write(bytes);
            bufferedOutputStream.flush();
        }
    }
}
