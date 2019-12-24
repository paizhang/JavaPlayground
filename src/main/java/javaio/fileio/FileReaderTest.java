package javaio.fileio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {

    public String readFile(String filePath) throws FileNotFoundException, IOException {
        // System.out.println(new File(".").getAbsolutePath());  // Find out what the root of the search path
        File file = new File(filePath);
        FileReader fileReader = null;
        StringBuilder sb = new StringBuilder();
        try {
            fileReader = new FileReader(file);

            int ch;
            while ((ch = fileReader.read()) != -1) {
                sb.append((char) ch);
            }
        } catch (IOException io) {
            System.out.println("IO exception. ");
            throw io;
        } finally {
            /*
                We use finally here to close the resource explicitly. In case some exceptions happens, some files
                remaining unclosed will cause memory leak.
             */
            System.out.println("Finally is called.");
            if (fileReader != null) {
                System.out.println("File closed!");
                fileReader.close();
            }
        }
        return sb.toString();
    }
}
