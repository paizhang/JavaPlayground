package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/*
    This is a sample socket client connected to the echo server. The client takes input from standard input stream and
    send the message to the server. Then it will listen message returned by the server and print out to the console.
    Steps for establish a client:
    1. Create a socket object and connect to the server.
    2. Create input stream and output stream for socket.
    3. Send message to the output stream or read message from the input stream.
 */
public class SocketClientTest {

    private static String SERVER_ADDRESS = "localhost";
    private static int PORT = 8888;

    public static void main(String[] args) {
        try (
                Socket socket = new Socket(SERVER_ADDRESS, PORT);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedReader inStd = new BufferedReader(new InputStreamReader(System.in));
                ) {
            String inputLine, receivedMessage;
            while ((inputLine = inStd.readLine()) != null) {
                System.out.println("Input from console: " + inputLine);
                out.println(inputLine);
                receivedMessage = in.readLine();
                System.out.println("Received from server: " + receivedMessage);
            }
        } catch (UnknownHostException uhe) {
            uhe.printStackTrace();
        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }
}
