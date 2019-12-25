package javaio.fileio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectInputStreamTest {

    public void readObject(String filePath) throws FileNotFoundException, IOException, ClassNotFoundException {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath))) {
            TestObject testObject = (TestObject) objectInputStream.readObject();
            System.out.println("Loaded object name:" + testObject.getName());
            System.out.println("Loaded object age:" + testObject.getAge());
        }
    }
}
