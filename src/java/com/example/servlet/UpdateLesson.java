package com.example.servlet;

import com.example.beans.Lesson;
import com.example.models.LessonModelImp;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateLesson extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            int lesson_id = Integer.parseInt(request.getParameter("lesson_id"));
            String lesson_name = request.getParameter("lesson_name");
            String lesson_date = request.getParameter("lesson_date");
            String time_started = request.getParameter("time_started");
            String time_ended = request.getParameter("time_ended");

            Lesson l = new LessonModelImp().getLessonById(lesson_id);
            l.setLessonName(lesson_name);
            l.setLessonDate(lesson_date);
            l.setTimeStarted(time_started);
            l.setTimeEnded(time_ended);

            boolean flag = new LessonModelImp().updateLesson(l);
            if (flag) {
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
