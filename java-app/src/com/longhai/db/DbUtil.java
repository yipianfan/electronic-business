package com.longhai.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtil {
    private static final String USER = "root";
    private static final String PASSWORD = "Engineer8000";

    public static Connection conn() {
        Connection conn;
        String url = "jdbc:mysql://127.0.0.1:3306/electronic_business";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, USER, PASSWORD);
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static Connection conn(String db) {
        Connection conn;
        String url = "jdbc:mysql://127.0.0.1:3306/" + db;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, USER, PASSWORD);
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}