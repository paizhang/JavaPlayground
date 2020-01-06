package network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

/*
    MulticastSocket is used for client to listen multicast messages from the server. Each client registers to a group IP
    address and a specific port. The server sends packets to the group IP and port. All clients who are listening to
    the group IP and port will receive the multicasting messages from the server.

    TODO: Investigate how multicast actually works.
 */
public class MulticastSocketClientTest {

    // Multicast IP must be within a specific range from 224.0.0.0 to 239.255.255.255. Otherwise it will throw
    // SocketException. See: https://stackoverflow.com/questions/33946043/java-net-socketexception-not-a-multicast-address
    private static final String MULTICAST_GROUP_ADDRESS = "224.0.0.0";
    private static final int MULTICAST_CLIENT_PORT = 6666;

    public static void main(String[] args) {
        try (MulticastSocket multicastSocket = new MulticastSocket(MULTICAST_CLIENT_PORT)) {
            InetAddress groupAddress = InetAddress.getByName(MULTICAST_GROUP_ADDRESS);
            // Join the multicast group
            multicastSocket.joinGroup(groupAddress);

            DatagramPacket datagramPacket;
            System.out.println("Listening messages from server...");
            for (int i = 0; i < 5; i++) {
                byte[] buff = new byte[256];
                datagramPacket = new DatagramPacket(buff, buff.length);
                multicastSocket.receive(datagramPacket);

                String receivedMessage = new String(datagramPacket.getData(), 0, datagramPacket.getLength());
                System.out.println("Received message from the server:" + receivedMessage);
            }
        } catch (UnknownHostException uhe) {
            uhe.printStackTrace();
        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }
}
