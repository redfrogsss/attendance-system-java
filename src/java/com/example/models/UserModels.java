package com.example.models;

import com.example.beans.User;
import java.util.List;

public interface UserModels {
    
    public User login(String email, String pwd);
    
    public User getUserById(int id);
    
    public List<User> getAllStudents();
    
}
