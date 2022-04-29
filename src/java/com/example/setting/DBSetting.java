package com.example.setting;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBSetting {

    public static Connection getConnection() {
        Connection conn = null;

        while (conn == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/sams?useSSL=false",
                        "root",
                        "root");
            } catch (Exception E) {
            }
        }

        return conn;
    }

}
