package com.example.servlet;

import com.example.beans.User;
import com.example.beans.Attendance;
import com.example.models.AttendanceModelImp;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetAttendanceById extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            int a_id = Integer.parseInt((String) request.getParameter("attendance_id"));
            Attendance c = new AttendanceModelImp().getAttendanceById(a_id);
            if (c != null) {
                out.print("{");
                out.print("\"id\" : \"" + c.getId() + "\",");
                out.print("\"student_id\" : \"" + c.getStudentId() + "\",");
                out.print("\"lesson_id\" : \"" + c.getLessonId() + "\",");
                out.print("\"attendance_time\" : \"" + c.getAttendanceTime() + "\",");
                out.print("\"attendance_date\" : \"" + c.getAttendanceDate() + "\",");
                out.print("\"attendance_status\" : \"" + c.getAttendanceStatus() + "\"");

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
