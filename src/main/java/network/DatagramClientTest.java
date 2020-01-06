package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class DatagramClientTest {

    private static final String SERVER_ADDRESS = "localhost";

    private static final int PORT = 8888;

    public static void main(String[] args) {
        try (
                DatagramSocket datagramSocket = new DatagramSocket();
                BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
                ) {
            String input;
            DatagramPacket datagramPacket;
            InetAddress serverAddress = InetAddress.getByName(SERVER_ADDRESS);
            while (!(input = stdIn.readLine()).equals("Bye")) {
                // Prepare packet to send
                System.out.println("Message from standard input: " + input);
                byte[] buff = input.getBytes();
                datagramPacket = new DatagramPacket(buff, buff.length, serverAddress, PORT);

                // Send packet to server
                System.out.println("Sending message to server...");
                datagramSocket.send(datagramPacket);

                // Received response from server
                buff = new byte[256];
                datagramPacket = new DatagramPacket(buff, buff.length);
                datagramSocket.receive(datagramPacket);
                String receivedMessage = new String(datagramPacket.getData(), 0, datagramPacket.getLength());
                System.out.println("Message received from server: " + receivedMessage);
            }
        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }
}
