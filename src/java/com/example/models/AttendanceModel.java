package com.example.models;

import com.example.beans.Attendance;

import java.util.List;

public interface AttendanceModel {

    public List<Attendance> getAttendanceByUserId(int userId);

    public Attendance getAttendanceById(int id);

    public List<Attendance> getAttendanceByLessonId(int lesson_id);
    
    public int createAttendance(Attendance a);
    
    public List<Attendance> getUserAttendanceByLessonId(int lesson_id, int student_id);
    
    public boolean updateAttendance(Attendance a);
    
    public boolean removeAttendanceById(int id);

}
