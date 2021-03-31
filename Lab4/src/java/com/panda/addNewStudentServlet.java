package com.panda;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Привет
 */
@WebServlet(urlPatterns = {"/addNewStudentServlet"})
public class addNewStudentServlet extends HttpServlet {

    private HttpServletResponse response;
    private HttpServletRequest request;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.response=response;
        this.request=request;
        try{
        String FirstNameStudent =request.getParameter("FirstNameStudent");
        String LastNameStudent =request.getParameter("LastNameStudent");
        String numberRecordBook =request.getParameter("numberRecordBook");
        String  NameFaculty =request.getParameter("AddNewStudent");
        String  AverageScore =request.getParameter("AverageScore");
        
        int numberRecordBookInt= Integer.parseInt(numberRecordBook);
        
        int AverageScoreInt =Integer.parseInt(AverageScore);
        
        Student student = new Student(FirstNameStudent,LastNameStudent,numberRecordBookInt);
        student.setAverageScore(AverageScoreInt);
        
        for (Faculty f :Institute.getFaculties() ){
        if (f.getName() == null ? NameFaculty == null : f.getName().equals(NameFaculty)){
         f.addStudent(student);
         request.setAttribute("facultyListStudents",f.getStudents() );
          break;
            }
        }
        
        
       request.setAttribute("facultyName",NameFaculty );
        
        
        
        } catch (Exception e){
            RequestDispatcher rd  = request.getRequestDispatcher("Error.jsp");
       rd.forward(request, response);
        }
        
       RequestDispatcher rd  = request.getRequestDispatcher("Stud.jsp");
       rd.forward(request, response);
        
        
 
        
   
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