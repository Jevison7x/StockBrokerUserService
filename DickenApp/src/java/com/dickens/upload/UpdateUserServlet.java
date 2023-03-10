/*
 * Copyright (c) 2018, Xyneex Technologies. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * You are not meant to edit or modify this source code unless you are
 * authorized to do so.
 *
 * Please contact Xyneex Technologies, #1 Orok Orok Street, Calabar, Nigeria.
 * or visit www.xyneex.com if you need additional information or have any
 * questions.
 */
package com.dickens.upload;

import com.dickens.users.Candidate;
import com.dickens.users.ElecoAdmin;
import com.dickens.users.Student;
import com.dickens.users.UserDAO;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author BLAZE
 */
@MultipartConfig
public class UpdateUserServlet extends HttpServlet
{

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @SuppressWarnings("fallthrough")
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try
        {
            String criteria = request.getParameter("criteria");
            switch(criteria)
            {
                case "edit-candidate":
                {
                    CandidateUpdate(request);
                    out.println("u did it for the candidate");
                }
                case "change-cand-password":
                {
                    UpdateCandidatePassword(request);
                    out.println(":keep going boy, the password is updated");;
                }
                case "edit-student":
                {
                    StudentUpdate(request);
                    out.println("yh boy, student details done");
                }
                case "change-stud-password":
                {
                    UpdateStudentPassword(request);
                    out.println("you did the student update password");
                }
                case "change-admin-password":
                {
                    UpdateElecoAdminPassword(request);
                    out.println("omo u baddd");
                }
                case "edit-eleco":
                {
                    UpdateElecoAdminPicture(request);
                    out.print("good boy");
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace(System.err);
            throw new RuntimeException(e);
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
            throws ServletException, IOException
    {
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
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo()
    {
        return "Short description";
    }// </editor-fold>

    private void CandidateUpdate(HttpServletRequest request) throws IOException, ServletException, Exception

    {
        Part file = request.getPart("formFile");
        String imageFileName = file.getSubmittedFileName();
        String uploadPath = "C:/Users/BLAZE/Documents/NetBeansProjects/DickenApp/web/img/" + imageFileName;

        String name = request.getParameter("canId");
        String manifesto = request.getParameter("manifesto");
        if("".equals(manifesto))
            throw new IllegalArgumentException("Manifesto shouldn't be empty");

        try
        {

            FileOutputStream fos = new FileOutputStream(uploadPath);
            InputStream is = file.getInputStream();

            byte[] data = new byte[is.available()];
            is.read(data);
            fos.write(data);
            fos.close();
            Candidate can = UserDAO.getCandidateByName(name);
            UserDAO.updateCandidateDetails(can, imageFileName, manifesto);

        }
        catch(IOException e)
        {
            e.printStackTrace(System.err);
            throw new RuntimeException(e);
        }

    }

    private void UpdateCandidatePassword(HttpServletRequest request) throws Exception
    {
        try
        {
            String oldPassword = request.getParameter("password");
            Candidate can = UserDAO.getCandidateByName(request.getParameter("candName"));
            String newPassword = request.getParameter("newpassword");
            String conPassword = request.getParameter("conpassword");
            if(newPassword == null ? conPassword != null : !newPassword.equals(conPassword))
                throw new IllegalArgumentException("hey the new passwword doesn't match the confirm,atory password");
            else if("".equals(newPassword))
                throw new IllegalArgumentException("hey password shouldn't be empty");
            else if(UserDAO.loginCandidate(can.getName(), oldPassword) == null)
                throw new IllegalArgumentException("omo i don tire");
            else
                UserDAO.updateCandidatePassword(can, newPassword);
        }
        catch(IllegalArgumentException e)
        {
            e.printStackTrace(System.err);
            throw new RuntimeException(e);
        }
    }

    private void StudentUpdate(HttpServletRequest request) throws IOException, ServletException, Exception
    {
        Part file = request.getPart("file");
        String imageFileName = file.getSubmittedFileName();
        String uploadPath = "C:/Users/BLAZE/Documents/NetBeansProjects/DickenApp/web/img/" + imageFileName;

        String name = request.getParameter("studentId");
        String faculty = request.getParameter("faculty");
        String department = request.getParameter("department");
        String level = request.getParameter("level");
        String matNumber = request.getParameter("matNumber");
        if("".equals(matNumber))
            throw new IllegalArgumentException("MatricNumber shouldn't be empty");
        else if("".equals(faculty))
            throw new IllegalArgumentException("Faculty shouldn't be empty");
        else if("".equals(department))
            throw new IllegalArgumentException("department shouldn't be empty");
        else if("".equals(level))
            throw new IllegalArgumentException("level shouldn't be empty");
        else if(UserDAO.getStudentByMatricNumber(matNumber) != null)
            throw new IllegalArgumentException("matNumber already exists");
        else
            try
        {

            FileOutputStream fos = new FileOutputStream(uploadPath);
            InputStream is = file.getInputStream();

            byte[] data = new byte[is.available()];
            is.read(data);
            fos.write(data);
            fos.close();
            Student stu = UserDAO.getStudentByName(name);
            UserDAO.updateStudentDetails(stu, imageFileName, faculty, department, level, matNumber);
        }
        catch(IOException e)
        {
            e.printStackTrace(System.err);
            throw new RuntimeException(e);
        }
    }

    private void UpdateStudentPassword(HttpServletRequest request) throws Exception
    {
        try
        {
            String oldPassword = request.getParameter("currentPassword");
            Student student = UserDAO.getStudentByName(request.getParameter("studentId"));
            String newPassword = request.getParameter("newpassword");
            String conPassword = request.getParameter("renewpassword");
            if(newPassword == null ? conPassword != null : !newPassword.equals(conPassword))
                throw new IllegalArgumentException("hey the new passwword doesn't match the confirm,atory password");
            else if("".equals(newPassword))
                throw new IllegalArgumentException("hey password shouldn't be empty");
            else if(UserDAO.loginStudent(student.getName(), oldPassword) == null)
                throw new IllegalArgumentException("omo i don tire");
            else
                UserDAO.updateStudentPassword(student, newPassword);
        }
        catch(IllegalArgumentException e)
        {
            e.printStackTrace(System.err);
            throw new RuntimeException(e);
        }
    }

    private void UpdateElecoAdminPassword(HttpServletRequest request) throws Exception
    {
        try
        {
            String oldPassword = request.getParameter("currentPassword");
            ElecoAdmin admin = UserDAO.getElecoAdminByUsername(request.getParameter("adminId"));
            String newPassword = request.getParameter("newpassword");
            String conPassword = request.getParameter("renewpassword");
            if(newPassword == null ? conPassword != null : !newPassword.equals(conPassword))
                throw new IllegalArgumentException("hey the new passwword doesn't match the confirm,atory password");
            else if("".equals(newPassword))
                throw new IllegalArgumentException("hey password shouldn't be empty");
            else if(UserDAO.loginAdmin(admin.getUsername(), oldPassword) == null)
                throw new IllegalArgumentException("omo i don tire");
            else
                UserDAO.updateElecoAdminPassword(admin, newPassword);
        }
        catch(IllegalArgumentException e)
        {
            e.printStackTrace(System.err);
            throw new RuntimeException(e);
        }
    }

    private void UpdateElecoAdminPicture(HttpServletRequest request) throws IOException, ServletException, Exception
    {
        Part file = request.getPart("formFile");
        String imageFileName = file.getSubmittedFileName();
        String uploadPath = "C:/Users/BLAZE/Documents/NetBeansProjects/DickenApp/web/img/" + imageFileName;

        String name = request.getParameter("adminId");

        try
        {

            FileOutputStream fos = new FileOutputStream(uploadPath);
            InputStream is = file.getInputStream();

            byte[] data = new byte[is.available()];
            is.read(data);
            fos.write(data);
            fos.close();
            ElecoAdmin admin = UserDAO.getElecoAdminByUsername(name);
            UserDAO.updateAdminPicture(admin, imageFileName);
        }
        catch(IOException e)
        {
            e.printStackTrace(System.err);
            throw new RuntimeException(e);
        }

    }
}
