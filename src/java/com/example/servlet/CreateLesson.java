package com.example.servlet;

import com.example.beans.Lesson;
import com.example.beans.User;
import com.example.models.LessonModelImp;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateLesson extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            int course_id = Integer.parseInt(request.getParameter("course_id"));
            int l_id = new LessonModelImp().createLesson(course_id);
            Lesson l = new LessonModelImp().getLessonById(l_id);

            if (l != null) {
                out.print("{");
                out.print("\"id\" : \"" + l.getId() + "\",");
                out.print("\"lesson_name\" : \"" + l.getLessonName() + "\",");
                out.print("\"course_id\" : \"" + l.getCourseId() + "\",");
                out.print("\"time_started\" : \"" + l.getTimeStarted() + "\",");
                out.print("\"time_ended\" : \"" + l.getTimeEnded() + "\",");
                out.print("\"lesson_date\" : \"" + l.getLessonDate() + "\"");
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
