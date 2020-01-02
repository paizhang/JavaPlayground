package io.javaio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamTest {

    private static final int BYTE_SIZE = 4;

    public void readFileByBytes(String filePath) throws FileNotFoundException, IOException {
        try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
            byte[] bytes = new byte[BYTE_SIZE];
            int i = 0;
            // Read specified size of bytes
            while ((i = fileInputStream.read(bytes)) != -1) {
                System.out.println(new String(bytes, 0, i));
            }
        }
    }

}
