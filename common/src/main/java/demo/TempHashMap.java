package demo;

import java.util.HashMap;

public class TempHashMap {

    public static void fun(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Chinese", "1");
        map.put("American", "2");
        map.put("English", "3");
        map.put("Japan", "4");

        map.put("Korea", "5");
        map.put("Canada", "6");
        map.put("Korea", "115");
        map.put("India", "7");
        map.put("French", "8");

        map.put("Germany", "9");
        map.put("Holland", "10");
        map.put("Finland", "11");
        map.put("Switzerland", "12");

        map.put("Russia", "13");
        map.put("Spain", "14");
        map.put("Portugal", "15");
        map.put("Brazil", "16");
    }
}