package com.example.models;

import com.example.beans.Lesson;
import com.example.setting.DBSetting;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class LessonModelImp implements LessonModel {

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    ResultSetMetaData meta = null;

    @Override
    public Lesson getLessonById(int id) {
        Lesson result = null;
        conn = new DBSetting().getConnection();
        try {
            pstmt = conn.prepareStatement("select * from lesson where id=?");
            pstmt.setInt(1, id);
            if (pstmt.execute()) {
                rs = pstmt.getResultSet();
            };
            if (rs.next()) {
                int l_id = rs.getInt("id");
                String l_lesson_name = rs.getString("lesson_name");
                int l_course_id = rs.getInt("course_id");
                String l_time_started = rs.getString("time_started");
                String l_time_ended = rs.getString("time_ended");
                String l_lesson_date = rs.getString("lesson_date");
                Lesson l = new Lesson(l_id, l_lesson_name, l_course_id, l_time_started, l_time_ended, l_lesson_date);
                result = l;
            }
        } catch (Exception E) {
        }

        return result;
    }

    @Override
    public List<Lesson> getLessonByTeacherId(int teacher_id) {
        List<Lesson> result = null;
        conn = new DBSetting().getConnection();
        try {
            pstmt = conn.prepareStatement("select lesson.* from lesson left join teach on teach.course_id = lesson.course_id where teacher_id=?");
            pstmt.setInt(1, teacher_id);
            if (pstmt.execute()) {
                rs = pstmt.getResultSet();
            };
            while (rs.next()) {
                if (result == null) {
                    result = new ArrayList<>();
                }
                int l_id = rs.getInt("id");
                String l_lesson_name = rs.getString("lesson_name");
                int l_course_id = rs.getInt("course_id");
                String l_time_started = rs.getString("time_started");
                String l_time_ended = rs.getString("time_ended");
                String l_lesson_date = rs.getString("lesson_date");
                Lesson l = new Lesson(l_id, l_lesson_name, l_course_id, l_time_started, l_time_ended, l_lesson_date);
                result.add(l);
            }
        } catch (Exception E) {
        }

        return result;
    }

    @Override
    public int createLesson(int course_id) {
        int result = -1;

        Lesson l = new Lesson();
        l.setLessonName("New Lesson");
        l.setCourseId(course_id);

        l.setTimeStarted(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm")));
        l.setTimeEnded(LocalTime.now().plusHours(1).format(DateTimeFormatter.ofPattern("HH:mm")));
        l.setLessonDate(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));

        conn = new DBSetting().getConnection();
        try {
            pstmt = conn.prepareStatement("INSERT INTO Lesson (lesson_name, course_id, time_started, time_ended, lesson_date) value (?, ?, ?, ?, ?);", pstmt.RETURN_GENERATED_KEYS);
            pstmt.setString(1, l.getLessonName());
            pstmt.setInt(2, l.getCourseId());
            pstmt.setString(3, l.getTimeStarted());
            pstmt.setString(4, l.getTimeEnded());
            pstmt.setString(5, l.getLessonDate());
            int row = pstmt.executeUpdate();

            if (row != 0) {
                try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        result = generatedKeys.getInt(1);
                    }
                }
            }

        } catch (Exception E) {
        }

        return result;
    }

    public boolean updateLesson(Lesson l) {
        boolean result = false;
        conn = new DBSetting().getConnection();
        try {
            pstmt = conn.prepareStatement("update lesson set lesson_name = ?, time_started = ?, time_ended = ?, lesson_date = ? where id = ?");
            pstmt.setString(1, l.getLessonName());
            pstmt.setString(2, l.getTimeStarted());
            pstmt.setString(3, l.getTimeEnded());
            pstmt.setString(4, l.getLessonDate());
            pstmt.setInt(5, l.getId());
            int row = pstmt.executeUpdate();

            if (row != 0) {
                result = true;
            }

        } catch (Exception E) {
        }

        return result;
    }

}
