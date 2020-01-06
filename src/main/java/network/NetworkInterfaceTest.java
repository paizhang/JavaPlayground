package network;

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
