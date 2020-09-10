package com.canoe.eb.account;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Menu {

    public static void main(String[] args) throws Exception {
        String file = "C:/Users/lihailen/Desktop/menu.xlsx";
        OutputStream out = new FileOutputStream(file);
        XSSFWorkbook book = new XSSFWorkbook();
        XSSFSheet sheet = book.createSheet();
        sheet.setColumnWidth(0, 20 * 256);
        sheet.setColumnWidth(1, 30 * 256);

        Connection conn = conn();
        String sql = "select `code`,`name`,description from  sys_menu";
        PreparedStatement statement = conn.prepareStatement(sql);
        ResultSet set = statement.executeQuery();
        int i = 0;
        while(set.next()) {
            XSSFRow row = sheet.createRow(i++);
            row.createCell(0, 3).setCellValue(set.getString("code"));
            row.createCell(1, 3).setCellValue(set.getString("name"));
            row.createCell(2, 3).setCellValue(set.getString("description"));
        }
        book.write(out);
        out.close();
    }

    private static Connection conn() throws Exception {
        String url = "jdbc:mysql://47.113.93.90:3306/esport";
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(url, "root", "Hunt");
        return conn;
    }
}
