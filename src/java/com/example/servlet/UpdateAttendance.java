package com.example.servlet;

import com.example.beans.Attendance;
import com.example.models.AttendanceModelImp;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateAttendance extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            int lesson_id = Integer.parseInt(request.getParameter("lesson_id"));
            int student_id = Integer.parseInt(request.getParameter("student_id"));
            String status = request.getParameter("status");

            if (status.equals("Absent")) {
                //delete attendance record
                List<Attendance> la = new AttendanceModelImp().getAttendanceByLessonId(lesson_id);

                boolean hasAttendance = false;

                if (la != null) {
                    for (Attendance a : la) {
                        if (a.getStudentId() == student_id) {
                            hasAttendance = true;
                            boolean success = new AttendanceModelImp().removeAttendanceById(a.getId());
                            if (success) {
                                out.print("success");
                            } else {
                                out.print("fail deleting attendance");
                            }
                        }
                    }
                    if(!hasAttendance){
                        out.print("success");
                    }
                } else {
                    out.print("success");
                }

            } else {
                if (status.equals("Present") || status.equals("Late")) {
                    List<Attendance> la = new AttendanceModelImp().getAttendanceByLessonId(lesson_id);

                    boolean hasAttendance = false;

                    if (la != null) {
                        for (Attendance a : la) {
                            if (a.getStudentId() == student_id) {
                                hasAttendance = true;
                                //update
                                a.setStudentId(student_id);
                                a.setLessonId(lesson_id);

                                String attendance_time = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm"));
                                String attendance_date = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                                a.setAttendanceTime(attendance_time);
                                a.setAttendanceDate(attendance_date);

                                a.setAttendanceStatus(status);

                                boolean success = new AttendanceModelImp().updateAttendance(a);
                                if (success) {
                                    out.print("success");
                                } else {
                                    out.print("fail updating attendance");
                                }
                            }
                        }
                    }

                    if (!hasAttendance) {
                        //create a new attendance
                        Attendance a = new Attendance();
                        a.setStudentId(student_id);
                        a.setLessonId(lesson_id);

                        String attendance_time = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm"));
                        String attendance_date = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                        a.setAttendanceTime(attendance_time);
                        a.setAttendanceDate(attendance_date);

                        a.setAttendanceStatus(status);

                        int a_id = new AttendanceModelImp().createAttendance(a);
                        if (a_id != -1) {
                            out.print("success");
                        } else {
                            out.print("fail creating attendance");
                        }
                    }

                }
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

    private Object AttendanceModelImp() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
