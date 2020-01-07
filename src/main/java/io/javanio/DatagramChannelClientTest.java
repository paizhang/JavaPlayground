package io.javanio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class DatagramChannelClientTest {

    private static final String SERVER_ADDRESS = "localhost";

    private static final int PORT = 8888;

    public static void main(String[] args) {
        try {
            // Create DatagramSocket object
            DatagramChannel datagramChannel = DatagramChannel.open();

            // Send data to server
            System.out.println("Sending message to server...");
            String messsage = "This is a test message from the client.";
            ByteBuffer byteBuffer = ByteBuffer.allocate(256);
            byteBuffer.put(messsage.getBytes());
            byteBuffer.flip();
            datagramChannel.send(byteBuffer, new InetSocketAddress(SERVER_ADDRESS, PORT));

            // Receive response from server
            byteBuffer.clear();
            datagramChannel.receive(byteBuffer);
            byteBuffer.flip();
            byte[] bytes = new byte[byteBuffer.remaining()];
            byteBuffer.get(bytes);
            System.out.println("Received from server: " + new String(bytes));

        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }
}
