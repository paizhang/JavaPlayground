package io.javanio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/*
    This is the sample echo server using ServerSocketChannel.
 */
public class ServerSocketChannelTest {

    private static final int PORT = 8888;

    private static void launchServer() throws IOException {
        try (ServerSocketChannel serverSocketChannel = ServerSocketChannel.open()) {
            // Binding to specific port
            serverSocketChannel.socket().bind(new InetSocketAddress(PORT));
            System.out.println("Waiting for client connection...");
            while (true) {
                // Waiting for a client connection
                SocketChannel socketChannel = serverSocketChannel.accept();

                // Read data from the client and display
                ByteBuffer byteBuffer = ByteBuffer.allocate(256);
                int readBytes = socketChannel.read(byteBuffer);
                byte[] bytes = new byte[readBytes];
                // Flip into read mode before reading data from the buffer.
                byteBuffer.flip();
                byteBuffer.get(bytes);
                System.out.println("Received from client:" + new String(bytes, 0, readBytes));

                // Writing response back to client
                byteBuffer.clear();
                byteBuffer.put("Message from server".getBytes());
                // Flip into read mode before writing the buffer data into channel
                byteBuffer.flip();
                // Read data from buffer into channel
                socketChannel.write(byteBuffer);
            }
        }
    }

    public static void main(String[] args) {
        try {
            launchServer();
        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }
}
