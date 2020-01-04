package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLTest {

    public static void parsingURL(URL url) {
        System.out.println("protocol = " + url.getProtocol());
        System.out.println("authority = " + url.getAuthority());
        System.out.println("host = " + url.getHost());
        System.out.println("port = " + url.getPort());
        System.out.println("path = " + url.getPath());
        System.out.println("query = " + url.getQuery());
        System.out.println("filename = " + url.getFile());
        System.out.println("ref = " + url.getRef());
    }

    /*
        Read content from the URL by calling url.openStream(). url.openStream() returns a InputStream which can be used
        construct a InputStreamReader. And a InputStreamReader can be used to construct a BufferedReader. Then we can
        read the fetched html file line by line.
     */
    public static void readFromURL(URL url) {
        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(url.openStream()))){
            String inputLine;
            while ((inputLine = in.readLine()) != null)
                System.out.println(inputLine);
        } catch (IOException ie) {
            System.out.println("Caught IOException");
            ie.printStackTrace();
        }
    }

    /*
        Read content from the URL by getting a InputStream from URLConnection object. The benefit for this instead of
        opening a InputStream directly is that we can use URLConnection to perform other tasks.
     */
    public static void readFromURLConnection(URL url) {
        try {
            URLConnection uc = url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    uc.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null)
                System.out.println(inputLine);
        } catch (IOException ie) {
            System.out.println("Caught IOException");
            ie.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            URL url = new URL("https://docs.oracle.com/javase/tutorial/networking/urls/urlInfo.html");
            // parsingURL(url);
            // readFromURL(url);
            readFromURLConnection(url);
        } catch (MalformedURLException me) {
            System.out.println("MalformedURLException");
            me.printStackTrace();
        }
    }
}
