package javaio.fileio;

import java.io.FileNotFoundException;
import java.io.IOException;

public class MainClass {

    public static void main(String[] args) {
        FileReaderTest fileReaderTest = new FileReaderTest();
        try {
            System.out.println(fileReaderTest.readFileByCharacters(".//src//main//java//javaio//fileio//sample_input_file.txt"));
        } catch (FileNotFoundException fe) {
            System.out.println("File is not found." + fe.getMessage());
        } catch (IOException ie) {
            System.out.println("IO Exception. " + ie.getMessage());
        }
    }
}
