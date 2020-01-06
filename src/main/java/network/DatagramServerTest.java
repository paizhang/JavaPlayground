package network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/*
    This is a sample echo server using DatagramSocket.
    The main difference between DatagramSocket and Socket is that DatagramSocket do not need to establish a connection
    with the server before sending packets. The client address and port info will be contained inside the packet. Each
    packet is independent. No order guaranteed for DatagramPackets.
    Steps for receiving Datagram packets from client:
    1. Create a DatagramSocket object binding to a specific port for listening client traffic;
    2. Receive client packet by calling receive() method;
    3. Sending response packet by calling send() method.

    Reference: https://docs.oracle.com/javase/tutorial/networking/datagrams/clientServer.html

    TODO: Modify the server code to handle multiple request simultaneously by using multiple threading.
    TODO: Investigate in what cases the SocketException will be thrown and how to handle those cases.
 */
public class DatagramServerTest {

    private static final int PORT = 8888;

    private static void launch() throws SocketException, IOException {
        System.out.println("Launch server...");
        DatagramSocket datagramSocket = new DatagramSocket(PORT);
        while (true) {
            // Received packet from client
            System.out.println("Receiving message from client...");
            byte[] buff = new byte[256];
            DatagramPacket packet = new DatagramPacket(buff, buff.length);
            datagramSocket.receive(packet);

            // Prepare response message
            System.out.println("Preparing response...");
            String response = new String(packet.getData(), 0, packet.getLength()) + " -- Received by Server. ";
            buff = response.getBytes();

            // Send response back to client
            System.out.println("Sending response back to client...");
            InetAddress inetAddress = packet.getAddress();
            int clientPort = packet.getPort();
            packet = new DatagramPacket(buff, buff.length, inetAddress, clientPort);
            datagramSocket.send(packet);

            System.out.println("Done\n");
        }
    }

    public static void main(String[] args) {
        try {
            launch();
        } catch (SocketException se) {
            se.printStackTrace();
        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }
}
