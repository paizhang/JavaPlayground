package javaio.fileio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {

    // https://codescracker.com/java/java-automatically-close-files.htm
    public String readFile(String filePath) throws FileNotFoundException, IOException {
        // System.out.println(new File(".").getAbsolutePath());  // Find out what the root of the search path
        File file = new File(filePath);

        StringBuilder sb = new StringBuilder();
        /*
        Using try-with-resource will help automatically manage the resource. We do not need to close the resource
        explicitly in the finally block which will make the code concisely.
         */
        try (FileReader fileReader = new FileReader(file)) {
            int ch;
            while ((ch = fileReader.read()) != -1) {
                sb.append((char) ch);
            }
        }
        return sb.toString();
    }
}
