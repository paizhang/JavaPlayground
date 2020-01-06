package network;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;
import java.util.Enumeration;

public class NetworkInterfaceTest {
    /*
        This example show how to list all the network interfaces we are currently have in the local machine.
        Good video explaining what network interface is: https://www.youtube.com/watch?v=PYTG7bvpvRI
     */
    public static void main(String[] args) {
        displayAllInterfacesInformation();
    }

    static void displayAllInterfacesInformation() {
        try {
            Enumeration<NetworkInterface> nets = NetworkInterface.getNetworkInterfaces();
            for (NetworkInterface netint : Collections.list(nets))
                displayInterfaceInformation(netint);
        } catch (SocketException se) {
            se.printStackTrace();
        }
    }

    /*
        Display IP address info within each network interface.
     */
    static void displayInterfaceInformation(NetworkInterface netint) throws SocketException {
        System.out.printf("Display name: %s\n", netint.getDisplayName());
        System.out.printf("Name: %s\n", netint.getName());
        Enumeration<InetAddress> inetAddresses = netint.getInetAddresses();
        for (InetAddress inetAddress : Collections.list(inetAddresses)) {
            System.out.printf("InetAddress: %s\n", inetAddress);
        }
        System.out.printf("\n");
    }

    private static void displayInterfacesAndSubInterfaces() {
        try {
            Enumeration<NetworkInterface> nets = NetworkInterface.getNetworkInterfaces();

            for (NetworkInterface netIf : Collections.list(nets)) {
                System.out.printf("Display name: %s\n", netIf.getDisplayName());
                System.out.printf("Name: %s\n", netIf.getName());
                displaySubInterfaces(netIf);
                System.out.printf("\n");
            }
        } catch (SocketException se) {
            se.printStackTrace();
        }
    }

    private static void displaySubInterfaces(NetworkInterface netIf) throws SocketException {
        Enumeration<NetworkInterface> subIfs = netIf.getSubInterfaces();

        for (NetworkInterface subIf : Collections.list(subIfs)) {
            System.out.printf("\tSub Interface Display name: %s\n", subIf.getDisplayName());
            System.out.printf("\tSub Interface Name: %s\n", subIf.getName());
        }
    }
}
