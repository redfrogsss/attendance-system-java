package com.example.models;

import com.example.beans.Course;
import java.util.List;

public interface CourseModel {
    
    public Course getCourseById(int id);
    
    public List<Integer> getTeacherIdByCourseId(int course_id);
    
    public List<Course> getCourseByTeacherId(int teacher_id);
    
}
