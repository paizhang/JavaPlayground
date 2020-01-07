package io.javanio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class DatagramChannelServerTest {

    private static final int PORT = 8888;

    private static void launchServer() {
        try (DatagramChannel datagramChannel = DatagramChannel.open()){
            System.out.println("Create DatagramSocket and bind to a port...");
            datagramChannel.socket().bind(new InetSocketAddress(PORT));
            while (true) {
                // Receiving packet from source client
                System.out.println("Receiving data from client...");
                ByteBuffer byteBuffer = ByteBuffer.allocate(256);
                SocketAddress srcAddress = datagramChannel.receive(byteBuffer);

                // Display message
                byteBuffer.flip();
                // Since DatagramChannel.receive() does not return the number of bytes that we read into the ByteBuffer,
                // we can get the number of remaining bytes in the ByteBuffer by calling ByteBuffer.remaining().
                byte[] bytes = new byte[byteBuffer.remaining()];
                byteBuffer.get(bytes);
                System.out.println("Received from client:" + new String(bytes));

                // Sending response back to client
                String response = "This is the response from the server.";
                byteBuffer.clear();
                byteBuffer.put(response.getBytes());
                byteBuffer.flip();
                datagramChannel.send(byteBuffer, srcAddress);

            }
        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launchServer();
    }
}
