package demo;

import java.util.ArrayList;
import java.util.List;

public class App {
    // 101023
    public static void main(String[] args) {
        String content = "fabccbadbacjiahijklmnopqiiqponmlkj";
        String subContent = longestPalindrome(content);
        System.out.println(subContent);
    }

    public static String longestPalindrome(String s) {
        for (int size = s.length(); size > 0; size--) {
            for (int low = 0, high = low + size - 1; high < s.length(); low++, high++) {
                if (shrinkCheckPalindrome(s, low, high))
                    return s.substring(low, high + 1);
            }
        }
        return s.substring(0, 1);
    }

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