package com.longhai.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtil {

    public static Connection conn(String db) {
        Connection conn;
        String url = "jdbc:mysql://127.0.0.1:3306/" + db;
        String user = "root";
        String password = "Engineer8000";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return conn;
    }
}