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

    public static void readFileUsingFileInputStream(String filePath) {
        FileInputStreamTest fileInputStreamTest = new FileInputStreamTest();
        try {
            fileInputStreamTest.readFileByBytes(filePath);
        } catch (FileNotFoundException fe) {
            System.out.println("File not found " + fe.getMessage());
        } catch (IOException ie) {
            System.out.println("IO exception " + ie.getMessage());
        }
    }

    public static void writeFileUsingFileOutputStream(String filePath, String content) {
        FileOutputStreamTest fileOutputStreamTest = new FileOutputStreamTest();
        try {
            fileOutputStreamTest.writeByBytes(filePath, content);
        } catch (FileNotFoundException fe) {
            System.out.println("File not found " + fe.getMessage());
        } catch (IOException ie) {
            System.out.println("IO exception " + ie.getMessage());
        }
    }

    public static void writeObjectUsingObjectOutputStream(Object object, String filePath) {
        ObjectOutStreamTest objectOutStreamTest = new ObjectOutStreamTest();
        try {
            objectOutStreamTest.writeObject(object, filePath);
        } catch (FileNotFoundException fe) {
            System.out.println("File not found " + fe.getMessage());
        } catch (IOException ie) {
            //System.out.println("IO exception " + ie.printStackTrace());
            ie.printStackTrace();
        }
    }

    public static void readObjectUsingObjectInputStream(String filePath) {
        ObjectInputStreamTest objectInputStreamTest = new ObjectInputStreamTest();
        try {
            objectInputStreamTest.readObject(filePath);
        } catch (FileNotFoundException fe) {
            System.out.println("FileNotFoundExeption caught. ");
            fe.printStackTrace();
        } catch (IOException ie) {
            System.out.println("IOException caught. ");
            ie.printStackTrace();
        } catch (ClassNotFoundException ce) {
            /*
                ClassNotFoundException is thrown when the classloader cannot find the class in all classpaths.
             */
            System.out.println("ClassNotFoundException caught. ");
            ce.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // readFile(".//src//main//java//javaio//fileio//sample_input_file.txt");
        // writeFile(".//src//main//java//javaio//fileio//test_output_file.txt", "This is test output " +
                // "message.\nThis is the second line. ");

        // readFileUsingFileInputStream(".//src//main//java//javaio//fileio//sample_input_file.txt");
        /* writeFileUsingFileOutputStream(".//src//main//java//javaio//fileio//test_output_file.txt", "This" +
                " is text writen by FileOutputStream. \nThis is the second line. \nThe end."); */
        // TestObject testObject = new TestObject("Obj2", 3);
        // writeObjectUsingObjectOutputStream(testObject, ".//src//main//java//javaio//fileio//object.bin");

        readObjectUsingObjectInputStream(".//src//main//java//javaio//fileio//object.bin");
    }
}
