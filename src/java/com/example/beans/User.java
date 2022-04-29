package com.example.beans;

public class User {
    int id;
    String user_name, email, pwd, user_role;

    public User() {

    }

    public User(String email, String pwd) {
        this.email = email;
        this.pwd = pwd;
    }

    public User(int id, String user_name, String email, String pwd, String user_role) {
        this.id = id;
        this.user_name = user_name;
        this.email = email;
        this.pwd = pwd;
        this.user_role = user_role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return user_name;
    }

    public void setUserName(String user_name) {
        this.user_name = user_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getUserRole() {
        return user_role;
    }

    public void setUserRole(String user_role) {
        this.user_role = user_role;
    }

}
