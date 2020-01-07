package io.javanio;

import java.io.FileNotFoundException;
import java.io.IOException;

/*
    Nice article explaning how nio implements non-blocking io and what the benefits are.
    http://tutorials.jenkov.com/java-nio/nio-vs-io.html
 */
public class MainClass {

    private static final String INPUT_FILE_PATH = ".//src//main//java//io//javanio//nio_test_input.txt";

    private static final String OUTPUT_FILE_PATH = ".//src//main//java//io//javanio//nio_test_output.txt";

    private static void readStringFromFile() {
        FileChannelTest fileChannelTest = new FileChannelTest();
        try {
            System.out.println(fileChannelTest.readFileToString(INPUT_FILE_PATH));
        } catch (FileNotFoundException fe) {
            System.out.println("File not found!");
            fe.printStackTrace();
        } catch (IOException ie) {
            System.out.println("IO Exception.");
            ie.printStackTrace();
        }
    }
    private static void writeStringFromFile(String content) {
        FileChannelTest fileChannelTest = new FileChannelTest();
        try {
            fileChannelTest.writeDataToFile(OUTPUT_FILE_PATH, content);
        } catch (FileNotFoundException fe) {
            System.out.println("FileNotFoundException");
            fe.printStackTrace();
        } catch (IOException ie) {
            System.out.println("IO Exception. ");
            ie.printStackTrace();
        }
    }

    private static void readDataFromSocketChannel(String url, int port) {
        SocketChannelTest socketChannelTest = new SocketChannelTest();
        try {
            socketChannelTest.readDataFromTCPSocket(url, port);
        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // writeStringFromFile("This is the text written using FileChannel.");
        readDataFromSocketChannel("localhost", 8888);
    }

}
