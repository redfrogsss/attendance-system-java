package com.example.beans;

public class Lesson {

    int id, course_id;
    String lesson_name, time_started, time_ended, lesson_date;

    public Lesson() {

    }

    public Lesson(int id, String lesson_name, int course_id, String time_started, String time_ended, String lesson_date) {
        this.id = id;
        this.lesson_name = lesson_name;
        this.course_id = course_id;
        this.time_started = time_started;
        this.time_ended = time_ended;
        this.lesson_date = lesson_date;
    }

    public int getId() {
        return id;
    }

    public String getLessonName() {
        return lesson_name;
    }

    public int getCourseId() {
        return course_id;
    }

    public String getTimeStarted() {
        return time_started;
    }

    public String getTimeEnded() {
        return time_ended;
    }

    public String getLessonDate() {
        return lesson_date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLessonName(String lesson_name) {
        this.lesson_name = lesson_name;

    }

    public void setCourseId(int course_id) {
        this.course_id = course_id;

    }

    public void setTimeStarted(String time_started) {
        this.time_started = time_started;
    }

    public void setTimeEnded(String time_ended) {
        this.time_ended = time_ended;
    }

    public void setLessonDate(String lesson_date) {
        this.lesson_date = lesson_date;
    }

}
