package javaio.fileio;

import java.io.FileNotFoundException;
import java.io.IOException;

public class MainClass {

    public static void readFile(String filePath) {
        FileReaderTest fileReaderTest = new FileReaderTest();
        try {
            System.out.println(fileReaderTest.readFileByCharacters(filePath));
        } catch (FileNotFoundException fe) {
            System.out.println("File is not found." + fe.getMessage());
        } catch (IOException ie) {
            System.out.println("IO Exception. " + ie.getMessage());
        }
    }

    public static void writeFile(String filePath, String content) {
        FileWriterTest fileWriterTest = new FileWriterTest();
        try {
            fileWriterTest.writeByCharacters(filePath, content);
        } catch (FileNotFoundException fe) {
            System.out.println("File not found " + fe.getMessage());
        } catch (IOException ie) {
            System.out.println("IO exception " + ie.getMessage());
        }
    }

    public static void main(String[] args) {
        // readFile(".//src//main//java//javaio//fileio//sample_input_file.txt");
        writeFile(".//src//main//java//javaio//fileio//test_output_file.txt", "This is test output " +
                "message.\nThis is the second line. ");
    }
}
