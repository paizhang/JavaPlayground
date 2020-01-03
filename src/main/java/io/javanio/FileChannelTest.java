package io.javanio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/*
    FileChannel is used to read and write data from or to a file through a Buffer.
    Nice article explaining FileChannel: http://tutorials.jenkov.com/java-nio/file-channel.html
 */

public class FileChannelTest {

    public String readFileToString(String filePath) throws FileNotFoundException, IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(filePath, "rw");
        // Nice article explaining java Buffer: http://tutorials.jenkov.com/java-nio/buffers.html
        ByteBuffer byteBuffer = ByteBuffer.allocate(32);
        FileChannel fileChannel = randomAccessFile.getChannel();
        int readBytes = 0;
        StringBuilder sb = new StringBuilder();
        // Keep reading bytes from file into ByteBuffer.
        while ((readBytes = fileChannel.read(byteBuffer)) != -1) {
            byteBuffer.flip();
            // We shouldn't create a fix size byte array here. Because it will cause java.nio.BufferUnderflowException
            // when the number of bytes remaining in the buffer is less than the size of the array.
            byte[] bytes = new byte[readBytes];
            // Write bytes from ByteBuffer to temporary byte array.
            byteBuffer.get(bytes);
            String str = new String(bytes, 0, readBytes);
            sb.append(str);
            // We need to clear the buffer every time we want to reuse it. Otherwise there may not be enough space for
            // next write operation.
            byteBuffer.clear();
        }
        return sb.toString();
    }

    public void writeDataToFile(String outputFilePath, String content) throws FileNotFoundException, IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(outputFilePath, "rw");
        // FileChannel fileChannel = randomAccessFile.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(content.length());
        byteBuffer.put(content.getBytes());
        byteBuffer.flip();

        // Because Channel class(super class of FileChannel) implements Closable, so we can apply try-with-resource here.
        try (FileChannel fileChannel = randomAccessFile.getChannel()) {
            while (byteBuffer.hasRemaining()) {
                fileChannel.write(byteBuffer);
            }
        }

    }
}
