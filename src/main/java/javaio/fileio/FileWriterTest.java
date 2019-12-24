package javaio.fileio;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest {

    public void write(String filePath, String content) throws IOException {
        File file = new File(filePath);
        /*
        FileWriter inherits its parent classes which implement AutoClosable. So we can use try-with-resource to close
        the file automatically.
         */
        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(content);
        }
    }
}
