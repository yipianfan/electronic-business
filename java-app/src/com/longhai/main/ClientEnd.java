package com.longhai.main;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public class ClientEnd {
    public static final int PORT = 2019;

    public static void main(String[] args) throws Exception {
        SocketChannel channel = SocketChannel.open(new InetSocketAddress(PORT));
        channel.configureBlocking(false);
        System.out.println("Socket channel boot completed.");

        Scanner scanner = new Scanner(System.in);
        String content = scanner.nextLine();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.put(content.getBytes());
        buffer.flip();
        channel.write(buffer);
        channel.shutdownOutput();
    }
}