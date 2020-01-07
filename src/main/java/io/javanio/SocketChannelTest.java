package io.javanio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/*
    This is a sample client using SocketChannel to communicate with the ServerSocketChannel.
 */
public class SocketChannelTest {

    public void readDataFromTCPSocket(String url, int port) throws IOException {
        // Open the channel and connect with the socket server
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress(url, port));

        // Sending data to socket server using created SocketChannel
        ByteBuffer byteBuffer = ByteBuffer.allocate(256);
        System.out.println("Sending message to socket server...");
        String testMsg = "This is the test message.";
        byteBuffer.put(testMsg.getBytes());
        byteBuffer.flip();
        socketChannel.write(byteBuffer);

        // Receive response from the socket server
        byteBuffer.clear();
        System.out.println("Receiving message from server...");
        int readBytes = socketChannel.read(byteBuffer);
        byteBuffer.flip();
        byte[] bytes = new byte[readBytes];
        byteBuffer.get(bytes);
        System.out.println("Received from server: " + new String(bytes, 0, readBytes));
    }
}
