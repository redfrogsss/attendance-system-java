package com.example.beans;

public class Attendance {

    int id, student_id, lesson_id;
    String attendance_time, attendance_date, attendance_status;

    public Attendance() {

    }

    public Attendance(int id, int student_id, int lesson_id, String attendance_time, String attendance_date, String attendance_status) {
        this.id = id;
        this.student_id = student_id;
        this.lesson_id = lesson_id;
        this.attendance_time = attendance_time;
        this.attendance_date = attendance_date;
        this.attendance_status = attendance_status;
    }

    public int getId() {
        return id;
    }

    public int getStudentId() {
        return student_id;
    }

    public int getLessonId() {
        return lesson_id;
    }

    public String getAttendanceTime() {
        return attendance_time;
    }

    public String getAttendanceDate() {
        return attendance_date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStudentId(int student_id) {
        this.student_id = student_id;
    }

    public void setLessonId(int lesson_id) {
        this.lesson_id = lesson_id;
    }

    public void setAttendanceTime(String attendance_time) {
        this.attendance_time = attendance_time;
    }

    public void setAttendanceDate(String attendance_date) {
        this.attendance_date = attendance_date;
    }
    
    public String getAttendanceStatus (){
        return attendance_status;
    }
    
    public void setAttendanceStatus (String attendance_status){
        this.attendance_status = attendance_status;
    }

}
