package javaio.fileio;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DataInputStreamTest {

    public void readData(String filePath) throws FileNotFoundException, IOException {
        try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream(filePath))) {
            int a = dataInputStream.readInt();
            float b = dataInputStream.readFloat();
            boolean c = dataInputStream.readBoolean();

            System.out.println("Read data from file: a = " + a + ", b = " + b + ", c = " + c);
        }
    }
}
