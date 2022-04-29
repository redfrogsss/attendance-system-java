package com.example.models;

import com.example.beans.Course;
import com.example.beans.User;
import com.example.setting.DBSetting;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

public class CourseModelImp implements CourseModel {

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    ResultSetMetaData meta = null;

    @Override
    public Course getCourseById(int id) {
        Course result = null;
        conn = new DBSetting().getConnection();
        try {
            pstmt = conn.prepareStatement("select * from course where id=?");
            pstmt.setInt(1, id);
            if (pstmt.execute()) {
                rs = pstmt.getResultSet();
            };
            if (rs.next()) {
                int c_id = rs.getInt("id");
                String c_course_name = rs.getString("course_name");
                String c_course_code = rs.getString("course_code");
                Course c = new Course(c_id, c_course_name, c_course_code);
                result = c;
            }
        } catch (Exception E) {
        }

        return result;
    }

    @Override
    public List<Integer> getTeacherIdByCourseId(int course_id) {
        List<Integer> result = null;
        conn = new DBSetting().getConnection();
        try {
            pstmt = conn.prepareStatement("select * from teach where course_id=?");
            pstmt.setInt(1, course_id);
            if (pstmt.execute()) {
                rs = pstmt.getResultSet();
            };
            while (rs.next()) {
                if (result == null) {
                    result = new ArrayList<>();
                }
                int t = rs.getInt("teacher_id");
                result.add(t);
            }
        } catch (Exception E) {
        }

        return result;
    }

    @Override
    public List<Course> getCourseByTeacherId(int teacher_id) {
        List<Course> result = null;
        conn = new DBSetting().getConnection();
        try {
            pstmt = conn.prepareStatement("select course.id, course.course_name, course.course_code from teach left join course on course.id = teach.course_id where teacher_id = ?");
            pstmt.setInt(1, teacher_id);
            if (pstmt.execute()) {
                rs = pstmt.getResultSet();
            };
            while (rs.next()) {
                if (result == null) {
                    result = new ArrayList<>();
                }
                int c_id = rs.getInt("id");
                String c_course_name = rs.getString("course_name");
                String c_course_code = rs.getString("course_code");
                Course c = new Course(c_id, c_course_name, c_course_code);
                result.add(c);
            }
        } catch (Exception E) {
        }

        return result;
    }

}
