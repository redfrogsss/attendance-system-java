package com.example.models;
import com.example.beans.Lesson;

import java.util.List;

public interface LessonModel {
    
    public Lesson getLessonById (int id);
    
    public List<Lesson> getLessonByTeacherId(int teacher_id);
    
    public int createLesson (int course_id);
    
    public boolean updateLesson (Lesson l);
    
}
