package io.javanio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/*
    This is a simple example for showing how to use Selector for processing multiple Channel using single thread.
    Nice article explaining Selector: https://zhuanlan.zhihu.com/p/36930888
 */
public class SelectorServerTest {

    private static final int PORT = 8888;

    private static void launchServer() {
        try {
            System.out.println("Launching server...");
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.socket().bind(new InetSocketAddress(PORT));
            serverSocketChannel.configureBlocking(false);

            Selector selector = Selector.open();
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

            ByteBuffer readBuffer = ByteBuffer.allocate(256);
            ByteBuffer writeBuffer = ByteBuffer.allocate(256);
            writeBuffer.put("Message from server...".getBytes());
            writeBuffer.flip();

            while (true) {
                /*
                    select() method will block until there are at least one SelectionKey is ready.
                 */
                int numReadyKeys = selector.select(1000);
                System.out.println("Select " + numReadyKeys + " channels.");
                if (numReadyKeys == 0) {
                    continue;
                }
                Set<SelectionKey> keys = selector.selectedKeys();
                Iterator<SelectionKey> iter = keys.iterator();
                while (iter.hasNext()) {
                    SelectionKey key = iter.next();
                    iter.remove();

                    if (key.isAcceptable()) {
                        System.out.println("Accept connection from client...");
                        SocketChannel socketChannel = serverSocketChannel.accept();
                        socketChannel.configureBlocking(false);
                        socketChannel.register(selector, SelectionKey.OP_READ);
                    } else if (key.isReadable()) {
                        SocketChannel socketChannel = (SocketChannel) key.channel();
                        readBuffer.clear();
                        socketChannel.read(readBuffer);

                        readBuffer.flip();
                        byte[] bytes = new byte[readBuffer.remaining()];
                        readBuffer.get(bytes);
                        System.out.println("Received from client: " + new String(bytes));

                        writeBuffer.rewind();
                        socketChannel.write(writeBuffer);
                        // We need to cancel registration after the channel has done its job. Otherwise, even though
                        // we called Iterator.remove(), key.isAcceptable() is still always be true.
                        // https://stackoverflow.com/questions/7132057/why-the-key-should-be-removed-in-selector-selectedkeys-iterator-in-java-ni
                        key.cancel();
                    }
                    /*
                    // isWritable() always return true which makes it always in the ready SelectionKey set.
                    // So usually we do not register the writable() operation.
                    else if (key.isWritable()) {
                        System.out.println("Writing message to client...");
                        SocketChannel socketChannel = (SocketChannel) key.channel();
                        writeBuffer.rewind();
                        socketChannel.write(writeBuffer);
                        key.interestOps(SelectionKey.OP_READ);
                    }
                    */

                }
            }
        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launchServer();
    }
}
