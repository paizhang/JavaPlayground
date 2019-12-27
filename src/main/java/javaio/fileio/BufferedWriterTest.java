package javaio.fileio;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterTest {

    public void writeText(String filePath, String content) throws FileNotFoundException, IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))){
            bufferedWriter.write(content);
            bufferedWriter.flush();
        }
    }
}
