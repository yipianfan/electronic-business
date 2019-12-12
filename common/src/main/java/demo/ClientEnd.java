package demo;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class ClientEnd {
    private static final String SERVER_IP = "127.0.0.1";
    private static final int PORT = 2019;

    public static void main(String[] args) throws Exception {
        SocketAddress serverAddress = new InetSocketAddress(SERVER_IP, PORT);
        SocketChannel channel = SocketChannel.open(serverAddress);
        channel.configureBlocking(false);
        while(!channel.finishConnect()) {}
        System.out.println("完成TCP三次握手,开始传输数据");
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.put("Hello Sex Girl".getBytes());
        buffer.flip();
        channel.write(buffer);
        channel.shutdownOutput();
    }
}