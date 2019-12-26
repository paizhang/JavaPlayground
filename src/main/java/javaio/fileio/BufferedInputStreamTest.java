package javaio.fileio;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BufferedInputStreamTest {

    public void readBytes(String filePath) throws FileNotFoundException, IOException {
        /*
        We set the buffer size as 1024 here(in real world scenario, we may need to tune this number for better
        performance. ) Each time, BufferedInputStream will load 1024 bytes into memory.
         */
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(filePath), 1024)) {
            byte[] bytes = new byte[512];
            int readCount = 0;
            while ((readCount = bufferedInputStream.read(bytes)) != -1) {
                System.out.println(new String(bytes, 0, readCount));
            }
        }
    }

    /*
    TODO: The readlimit for mark seems not working. Per documentation, readlimit here means that "the maximum limit of
    bytes that can be read before the mark position becomes invalid.". As I set the readlimit to 1 and continue to read
    4 characters before I reset it, the mark is still valid.
     */
    public void markAndReset(String filePath) throws FileNotFoundException, IOException {
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(filePath))) {
            System.out.println((char)bufferedInputStream.read());
            System.out.println((char)bufferedInputStream.read());

            bufferedInputStream.mark(1);
            System.out.println((char)bufferedInputStream.read());
            System.out.println((char)bufferedInputStream.read());
            System.out.println((char)bufferedInputStream.read());

            System.out.println((char)bufferedInputStream.read());

            bufferedInputStream.reset();

            System.out.println((char)bufferedInputStream.read());
            System.out.println((char)bufferedInputStream.read());
            System.out.println((char)bufferedInputStream.read());
            System.out.println((char)bufferedInputStream.read());
            System.out.println((char)bufferedInputStream.read());
            System.out.println((char)bufferedInputStream.read());
        }
    }
}
