package com.example.models;

import com.example.beans.Attendance;
import com.example.beans.Lesson;
import com.example.models.AttendanceModel;
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

public class AttendanceModelImp implements AttendanceModel {

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    ResultSetMetaData meta = null;

    @Override
    public List<Attendance> getAttendanceByUserId(int userId) {
        List<Attendance> result = null;
        conn = new DBSetting().getConnection();
        try {
            pstmt = conn.prepareStatement("select * from attendance where student_id=?");
            pstmt.setInt(1, userId);
            if (pstmt.execute()) {
                rs = pstmt.getResultSet();
            };
            while (rs.next()) {
                if (result == null) {
                    result = new ArrayList<>();
                }
                int a_id = rs.getInt("id");
                int a_student_id = rs.getInt("student_id");
                int a_lesson_id = rs.getInt("lesson_id");
                String a_attendance_time = rs.getString("attendance_time");
                String a_attendance_date = rs.getString("attendance_date");
                String a_attendance_status = rs.getString("attendance_status");
                Attendance a = new Attendance(a_id, a_student_id, a_lesson_id, a_attendance_time, a_attendance_date, a_attendance_status);
                result.add(a);
            }
        } catch (Exception E) {
        }

        return result;
    }

    @Override
    public Attendance getAttendanceById(int id) {
        Attendance result = null;
        conn = new DBSetting().getConnection();
        try {
            pstmt = conn.prepareStatement("select * from attendance where id=?");
            pstmt.setInt(1, id);
            if (pstmt.execute()) {
                rs = pstmt.getResultSet();
            };
            if (rs.next()) {
                int a_id = rs.getInt("id");
                int a_student_id = rs.getInt("student_id");
                int a_lesson_id = rs.getInt("lesson_id");
                String a_attendance_time = rs.getString("attendance_time");
                String a_attendance_date = rs.getString("attendance_date");
                String a_attendance_status = rs.getString("attendance_status");
                Attendance a = new Attendance(a_id, a_student_id, a_lesson_id, a_attendance_time, a_attendance_date, a_attendance_status);
                result = a;
            }
        } catch (Exception E) {
        }

        return result;
    }

    @Override
    public List<Attendance> getAttendanceByLessonId(int lesson_id) {
        List<Attendance> result = null;
        conn = new DBSetting().getConnection();
        try {
            pstmt = conn.prepareStatement("select * from attendance where lesson_id=?");
            pstmt.setInt(1, lesson_id);
            if (pstmt.execute()) {
                rs = pstmt.getResultSet();
            };
            while (rs.next()) {
                if (result == null) {
                    result = new ArrayList<>();
                }
                int a_id = rs.getInt("id");
                int a_student_id = rs.getInt("student_id");
                int a_lesson_id = rs.getInt("lesson_id");
                String a_attendance_time = rs.getString("attendance_time");
                String a_attendance_date = rs.getString("attendance_date");
                String a_attendance_status = rs.getString("attendance_status");
                Attendance a = new Attendance(a_id, a_student_id, a_lesson_id, a_attendance_time, a_attendance_date, a_attendance_status);
                result.add(a);
            }
        } catch (Exception E) {
        }

        return result;
    }

    @Override
    public int createAttendance(Attendance a) {
        int result = -1;

        conn = new DBSetting().getConnection();
        try {
            pstmt = conn.prepareStatement("INSERT INTO Attendance (student_id, lesson_id, attendance_time, attendance_date, attendance_status) value (?, ?, ?, ?, ?);", pstmt.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, a.getStudentId());
            pstmt.setInt(2, a.getLessonId());
            pstmt.setString(3, a.getAttendanceTime());
            pstmt.setString(4, a.getAttendanceDate());
            pstmt.setString(5, a.getAttendanceStatus());
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

    @Override
    public List<Attendance> getUserAttendanceByLessonId(int lesson_id, int student_id) {
        List<Attendance> result = null;
        conn = new DBSetting().getConnection();
        try {
            pstmt = conn.prepareStatement("select * from attendance where lesson_id=? and student_id=?");
            pstmt.setInt(1, lesson_id);
            pstmt.setInt(2, student_id);
            if (pstmt.execute()) {
                rs = pstmt.getResultSet();
            };
            while (rs.next()) {
                if (result == null) {
                    result = new ArrayList<>();
                }
                int a_id = rs.getInt("id");
                int a_student_id = rs.getInt("student_id");
                int a_lesson_id = rs.getInt("lesson_id");
                String a_attendance_time = rs.getString("attendance_time");
                String a_attendance_date = rs.getString("attendance_date");
                String a_attendance_status = rs.getString("attendance_status");
                Attendance a = new Attendance(a_id, a_student_id, a_lesson_id, a_attendance_time, a_attendance_date, a_attendance_status);
                result.add(a);
            }
        } catch (Exception E) {
        }

        return result;
    }

    @Override
    public boolean updateAttendance(Attendance a) {
        boolean result = false;
        conn = new DBSetting().getConnection();
        try {
            pstmt = conn.prepareStatement("update attendance set student_id = ?, lesson_id = ?, attendance_time = ?, attendance_date = ?, attendance_status=? where id = ?");
            pstmt.setInt(1, a.getStudentId());
            pstmt.setInt(2, a.getLessonId());
            pstmt.setString(3, a.getAttendanceTime());
            pstmt.setString(4, a.getAttendanceDate());
            pstmt.setString(5, a.getAttendanceStatus());
            pstmt.setInt(6, a.getId());
            int row = pstmt.executeUpdate();

            if (row != 0) {
                result = true;
            }

        } catch (Exception E) {
        }

        return result;
    }

    @Override
    public boolean removeAttendanceById(int id) {
        boolean result = false;
        conn = new DBSetting().getConnection();
        try {
            pstmt = conn.prepareStatement("DELETE FROM attendance WHERE id=?");
            pstmt.setInt(1, id);
            int row = pstmt.executeUpdate();

            if (row != 0) {
                result = true;
            }

        } catch (Exception E) {
        }

        return result;
    }

}
