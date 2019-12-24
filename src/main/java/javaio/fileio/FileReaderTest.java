package javaio.fileio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {

    // https://codescracker.com/java/java-automatically-close-files.htm
    public String readFileByCharacter(String filePath) throws FileNotFoundException, IOException {
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

    public String readFileByCharacters(String filePath) throws FileNotFoundException, IOException {
        StringBuilder sb = new StringBuilder();
        try (FileReader fileReader = new FileReader(filePath)) {
            char[] chs = new char[6];
            int cnt = 0;  // How many characters that we get back from the read method.
            while ((cnt = fileReader.read(chs)) != -1) {
                // Only append the number of characters that returns from read(). Note that in the last read, there may be
                // some remaining characters in the buffer that we don't want.
                sb.append(chs, 0, cnt);
            }
        }
        return sb.toString();
    }
}
