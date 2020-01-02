package io.javaio;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
The purpose of using DataOutputStream is to read primitive types from the OutputStream instead of raw bytes.
Be aware that we identify the end of the file by checking whether the return value is equal to -1.
So we need to know what data we will read and when it comes to the end.
 */
public class DataOutputStreamTest {

    public void writeData(String filePath) throws FileNotFoundException, IOException {
        try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(filePath))) {
            dataOutputStream.writeInt(123);
            dataOutputStream.writeFloat(0.5F);
            dataOutputStream.writeBoolean(true);

            dataOutputStream.flush();
        }
    }
}
