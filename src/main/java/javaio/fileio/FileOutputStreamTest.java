package javaio.fileio;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest {

    public void writeByBytes(String outputFile, String content) throws IOException {
        byte[] bytes = content.getBytes();
        try (FileOutputStream fileOutputStream = new FileOutputStream(outputFile)) {
            fileOutputStream.write(bytes);
        }
    }
}
