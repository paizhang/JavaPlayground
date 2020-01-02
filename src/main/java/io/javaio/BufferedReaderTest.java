package io.javaio;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderTest {

    /*
    The purpose of using BufferedReader is that pre loading a big chunk of characters into memory.
    The default buffer size is 8KB.
     */
    public String readTextByCharacters(String filePath) throws FileNotFoundException, IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            char[] chs = new char[5];
            int readCount = 0;
            while ((readCount = bufferedReader.read(chs)) != -1) {
                sb.append(chs, 0, readCount);
            }
        }

        return sb.toString();
    }

    public void readTextByLines(String filePath) throws FileNotFoundException, IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String str = null;
            int lineCount = 0;
            while ((str = bufferedReader.readLine()) != null) {
                System.out.println("Line " + lineCount + ":");
                System.out.println(str);
                lineCount++;
            }
        }
    }
}
