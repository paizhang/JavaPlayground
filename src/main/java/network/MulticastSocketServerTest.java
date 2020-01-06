package network;

import java.io.IOException;
import java.net.*;

public class MulticastSocketServerTest {

    private static final String MULTICAST_GROUP_ADDRESS = "224.0.0.0";
    private static final int MULTICAST_CLIENT_PORT = 6666;

    private static void launchServer() throws SocketException, UnknownHostException, IOException {
        System.out.println("Lauch server...");
        try (DatagramSocket datagramSocket = new DatagramSocket()) {
            for (int i = 1; i <= 5; i++) {
                String message = "This is No." + i + "message.";
                System.out.println("Sending message: " + message);
                byte[] buff = message.getBytes();
                InetAddress groupAddress = InetAddress.getByName(MULTICAST_GROUP_ADDRESS);
                DatagramPacket packet = new DatagramPacket(buff, buff.length, groupAddress, MULTICAST_CLIENT_PORT);
                datagramSocket.send(packet);
            }
        }
    }

    public static void main(String[] args) {
        try {
            launchServer();
        } catch (SocketException se) {
            se.printStackTrace();
        } catch (UnknownHostException uhe) {
            uhe.printStackTrace();
        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }
}
