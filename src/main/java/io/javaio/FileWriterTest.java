package io.javaio;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/*
Nice article: https://www.journaldev.com/20891/java-filewriter-example
 */
public class FileWriterTest {

    public void writeByString(String filePath, String content) throws IOException {
        File file = new File(filePath);
        /*
        FileWriter inherits its parent classes which implement AutoClosable. So we can use try-with-resource to close
        the file automatically.
         */
        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(content);
        }
    }

    public void writeByCharacters(String filePath, String content) throws IOException {
        char[] chs = content.toCharArray();
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            fileWriter.write(chs, 0, 10);
        }
    }
}
