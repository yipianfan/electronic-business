package demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class App {
    static Charset charset = Charset.forName("UTF-8");

    public static void main(String[] args) throws IOException {
        int write = 10, read = 1;
        Selector selector = Selector.open();
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.bind(new InetSocketAddress(2019));
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        // 轮询，选择感兴趣的IO就绪事件
        while(selector.select() > 0) {
            Set<SelectionKey> selectedKeys = selector.selectedKeys();
            Iterator<SelectionKey> keyIterator = selectedKeys.iterator();
            while(keyIterator.hasNext()) {
                SelectionKey key = keyIterator.next();
                // 根据具体的IO事件进行相应的业务操作
                if(key.isAcceptable()) {

                }
            }
        }










        if(write > read)
            return;

        FileChannel fChannel = new FileInputStream("C:\\Users\\hailen\\Desktop\\nio.txt").getChannel();
        SocketChannel sChannel = SocketChannel.open();
        sChannel.configureBlocking(false);
        sChannel.connect(new InetSocketAddress("127.0.0.1", 80));
        while (!sChannel.finishConnect()) {
            // 因为是在异步模式下，所以可能还没有连接上server end,connect()方法就返回了，所以当还没有连接到server end时做一些其他的事
        }
        ByteBuffer fileNameBuffer = charset.encode("C:\\Users\\hailen\\Desktop\\nio.txt");
        sChannel.write(fileNameBuffer);
        ByteBuffer lenBuffer = ByteBuffer.allocate(10);
        lenBuffer.flip();
        sChannel.write(lenBuffer);
        lenBuffer.clear();
        int len = fChannel.read(lenBuffer);
        while(len > 0) {
            lenBuffer.flip();
            sChannel.write(lenBuffer);
            lenBuffer.clear();
        }
    }

    /**
     * 回文
     * s = fabccbadbacjiahijklmnopqiiqponmlkj
     */
    public static String longestPalindrome(String s) {
        for (int size = s.length(); size > 0; size--) {
            for (int low = 0, high = low + size - 1; high < s.length(); low++, high++) {
                if (shrinkCheckPalindrome(s, low, high))
                    return s.substring(low, high + 1);
            }
        }
        return s.substring(0, 1);
    }

    /**
     * 回文
     */
    public static boolean shrinkCheckPalindrome(String s, int low, int high) {
        while (low <= high) {
            if (s.charAt(low) == s.charAt(high)) {
                low++;
                high--;
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * 将输入的字符串反转
     */
    public static String reverse(String content) {
        StringBuilder sb = new StringBuilder();
        for (int i = content.length() - 1; i >= 0; i--)
            sb.append(content.charAt(i));
        return sb.toString();
    }

    /**
     * 判断输入的字符串是不是回文
     */
    public static boolean isPalindrome(String content) {
        StringBuilder sb = new StringBuilder();
        for (int i = content.length() - 1; i >= 0; i--)
            sb.append(content.charAt(i));
        return content.equals(sb.toString());
    }

    /**
     * 输出输入的字符串有效的ip
     * 101023
     */
    public static List<String> restore(String s) {
        List<String> ret = new ArrayList<>();
        StringBuilder ip = new StringBuilder();
        for (int a = 1; a < 4; ++a) {
            for (int b = 1; b < 4; ++b) {
                for (int c = 1; c < 4; ++c) {
                    for (int d = 1; d < 4; ++d) {
                        if (a + b + c + d == s.length()) {
                            int n1 = Integer.parseInt(s.substring(0, a));
                            int n2 = Integer.parseInt(s.substring(a, a + b));
                            int n3 = Integer.parseInt(s.substring(a + b, a + b + c));
                            int n4 = Integer.parseInt(s.substring(a + b + c));
                            if (n1 <= 255 && n2 <= 255 && n3 <= 255 && n4 <= 255) {
                                ip.append(n1).append(".").append(n2).append(".")
                                        .append(n3).append(".").append(n4);
                                if (ip.length() == s.length() + 3)
                                    ret.add(ip.toString());
                                ip.delete(0, ip.length());
                            }
                        }
                    }
                }
            }
        }
        return ret;
    }
}