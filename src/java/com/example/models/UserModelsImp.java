package com.example.models;

import com.example.beans.User;
import com.example.setting.DBSetting;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserModelsImp implements UserModels {

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    ResultSetMetaData meta = null;

    @Override
    public User login(String email, String pwd) {
        User result = null;
        conn = new DBSetting().getConnection();
        try {
            pstmt = conn.prepareStatement("select * from user where email=? and pwd=?");
            pstmt.setString(1, email);
            pstmt.setString(2, pwd);
            if (pstmt.execute()) {
                rs = pstmt.getResultSet();
            };
            if (rs.next()) {
                int u_id = rs.getInt("id");
                String u_user_name = rs.getString("user_name");
                String u_email = rs.getString("email");
                String u_pwd = rs.getString("pwd");
                String u_role = rs.getString("user_role");

                result = new User(u_id, u_user_name, u_email, u_pwd, u_role);
            }
        } catch (Exception E) {
        }

        return result;
    }

    @Override
    public User getUserById(int id) {
        User result = null;
        conn = new DBSetting().getConnection();
        try {
            pstmt = conn.prepareStatement("select * from user where id=?");
            pstmt.setInt(1, id);
            if (pstmt.execute()) {
                rs = pstmt.getResultSet();
            };
            if (rs.next()) {
                int u_id = rs.getInt("id");
                String u_user_name = rs.getString("user_name");
                String u_email = rs.getString("email");
                String u_pwd = rs.getString("pwd");
                String u_role = rs.getString("user_role");

                result = new User(u_id, u_user_name, u_email, u_pwd, u_role);
            }
        } catch (Exception E) {
        }

        return result;
    }

    @Override
    public List<User> getAllStudents() {
        List<User> result = null;
        conn = new DBSetting().getConnection();
        try {
            pstmt = conn.prepareStatement("select * from user where user_role=?");
            pstmt.setString(1, "student");
            if (pstmt.execute()) {
                rs = pstmt.getResultSet();
            };
            while (rs.next()) {
                if(result == null){
                    result = new ArrayList<>();
                }
                int u_id = rs.getInt("id");
                String u_user_name = rs.getString("user_name");
                String u_email = rs.getString("email");
                String u_pwd = rs.getString("pwd");
                String u_role = rs.getString("user_role");

                User u = new User(u_id, u_user_name, u_email, u_pwd, u_role);
                result.add(u);
            }
        } catch (Exception E) {
        }

        return result;
    }

}
