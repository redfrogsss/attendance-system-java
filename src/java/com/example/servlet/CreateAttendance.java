package com.example.servlet;

import com.example.beans.Attendance;
import com.example.beans.User;
import com.example.models.AttendanceModelImp;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateAttendance extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            User currentUser = (User) request.getSession().getAttribute("active-user");
            int user_id = currentUser.getId();
            int lesson_id = Integer.parseInt(request.getParameter("lesson_id"));
            String attendance_time = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm"));
            String attendance_date = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            String attendance_status = "Present";

            Attendance a = new Attendance();
            a.setStudentId(user_id);
            a.setLessonId(lesson_id);
            a.setAttendanceTime(attendance_time);
            a.setAttendanceDate(attendance_date);
            a.setAttendanceStatus(attendance_status);

            int a_id = new AttendanceModelImp().createAttendance(a);
            Attendance result = new AttendanceModelImp().getAttendanceById(a_id);

            if (result != null) {
                out.print("{");
                out.print("\"id\" : \"" + result.getId() + "\",");
                out.print("\"student_id\" : \"" + result.getStudentId() + "\",");
                out.print("\"lesson_id\" : \"" + result.getLessonId() + "\",");
                out.print("\"attendance_time\" : \"" + result.getAttendanceTime() + "\",");
                out.print("\"attendance_date\" : \"" + result.getAttendanceDate() + "\",");
                out.print("\"attendance_status\" : \"" + result.getAttendanceStatus() + "\"");
                out.print("}");
            }

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
