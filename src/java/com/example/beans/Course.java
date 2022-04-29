package com.example.beans;

public class Course {

    int id;
    String course_name, course_code;

    public Course() {

    }

    public Course(int id, String course_name, String course_code) {
        this.id = id;
        this.course_name = course_name;
        this.course_code = course_code;
    }

    public int getId() {
        return id;
    }

    public String getCourseName() {
        return course_name;
    }

    public String getCourseCode() {
        return course_code;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCourseName(String course_name) {
        this.course_name = course_name;
    }

    public void setCourseCode(String course_code) {
        this.course_code = course_code;
    }

}
