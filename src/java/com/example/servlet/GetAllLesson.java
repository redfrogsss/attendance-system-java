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

public class GetAllLesson extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            User currentUser = (User) request.getSession().getAttribute("active-user");
            int user_id = currentUser.getId();
            List<Lesson> l = new LessonModelImp().getLessonByTeacherId(user_id);
            out.print("[");

            if (l != null) {
                for (int i = 0; i < l.size(); i++) {
                    out.print("{");
                    out.print("\"id\" : \"" + l.get(i).getId() + "\",");
                    out.print("\"lesson_name\" : \"" + l.get(i).getLessonName() + "\",");
                    out.print("\"course_id\" : \"" + l.get(i).getCourseId() + "\",");
                    out.print("\"time_started\" : \"" + l.get(i).getTimeStarted() + "\",");
                    out.print("\"time_ended\" : \"" + l.get(i).getTimeEnded() + "\",");
                    out.print("\"lesson_date\" : \"" + l.get(i).getLessonDate() + "\"");
                    out.print("}");
                    if (i != (l.size() - 1)) {
                        out.print(',');
                    }
                }
            }
            out.print("]");

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
