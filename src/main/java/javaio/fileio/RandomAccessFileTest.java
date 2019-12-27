package javaio.fileio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/*
RandomAccessFile can be used to access any byte location of the file. The most helpful method is the seek() method.
This is a bidirectional class. It uses a mode parameter to determine the permission for read and write operation.
TODO: Investigate the use cases for "rws" mode and "rw" mode.
Note that write operation will override the original data instead of inserting.
 */
public class RandomAccessFileTest {

    public void readData(String filePath, String mode) throws FileNotFoundException, IOException {
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(filePath, mode)) {
            byte[] bytes = new byte[5];
            randomAccessFile.read(bytes);
            System.out.println(new String(bytes));

            randomAccessFile.seek(0);

            randomAccessFile.read(bytes);
            System.out.println(new String(bytes));
        }
    }

    public void writeData(String filePath, String mode, long offset, String content) throws FileNotFoundException, IOException {
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(filePath, mode)) {
            randomAccessFile.seek(offset);
            randomAccessFile.write(content.getBytes());
        }
    }
}
