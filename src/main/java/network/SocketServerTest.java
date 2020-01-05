package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/*
    This is a sample echo server using socket. There is a few steps for establish a socket server:
    1. Create a ServerSocket object and bind to a specific port;
    2. Listen to the port for any connection from client by calling accept(). accept() wait until it gets connection from
    client and it returns a Socket object for each client connection.
    3. Create input and output stream for client socket.
    4. Read message from the input stream and write message to the output stream.

    TODO: Currently this version can only handle one client at a time. Modify to support handling traffic from multiple
    client at the same time using multithreading.
 */
public class SocketServerTest {

    private static final int PORT = 8888;

    private static void launchServer(int port) throws IOException {
        System.out.println("Launch server...");
        try (
                ServerSocket serverSocket = new ServerSocket(port);
                Socket clientSocket = serverSocket.accept();
                // We need to set the second parameter to true for enabling the autoFlush. So that it will auto flush the
                // message we write through println().
                PrintWriter printWriter = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))
        ) {
            String receivedMessage;
            System.out.println("Receiving message...");
            while ((receivedMessage = bufferedReader.readLine()) != null) {
                System.out.println("Received from client: " + receivedMessage);
                printWriter.println(receivedMessage);
                if (receivedMessage.equals("Bye")) {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        try {
           launchServer(PORT);
        } catch (IOException ie) {
            System.out.println("Caught IOException.");
            ie.printStackTrace();
        }
    }
}
