package io.javanio;

import java.io.FileNotFoundException;
import java.io.IOException;

public class MainClass {

    private static final String FILE_PATH = ".//src//main//java//io//javanio//nio_test_input.txt";

    public static void main(String[] args) {

        FileChannelTest fileChannelTest = new FileChannelTest();
        try {
            System.out.println(fileChannelTest.readFileToString(FILE_PATH));
        } catch (FileNotFoundException fe) {
            System.out.println("File not found!");
            fe.printStackTrace();
        } catch (IOException ie) {
            System.out.println("IO Exception.");
            ie.printStackTrace();
        }
    }

}
