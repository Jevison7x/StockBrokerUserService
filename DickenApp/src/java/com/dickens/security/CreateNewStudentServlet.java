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
package com.dickens.security;

import com.dickens.users.Student;
import com.dickens.users.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author BLAZE
 */
public class CreateNewStudentServlet extends HttpServlet
{

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        try
        {
            Student user = validateUser(request);
            System.out.println("Validated user.................");
            UserDAO.registerNewStudent(user);
            System.out.println("Regitered user.................");
            JSONObject jsono = new JSONObject();
            jsono.put("message", "success");
            out.print(jsono);
        }
        catch(Exception xcp)
        {
            if(xcp instanceof IllegalArgumentException)
            {
                xcp.printStackTrace(System.err);
                try
                {
                    JSONObject jsono = new JSONObject();
                    jsono.put("message", xcp.getMessage());
                    out.print(jsono);
                }
                catch(JSONException jsone)
                {
                    throw new RuntimeException(jsone);
                }
            }
            else
                throw new RuntimeException(xcp);
        }
        finally
        {
            out.close();
        }
    }

    private Student validateUser(HttpServletRequest request) throws Exception
    {
        String name = request.getParameter("name").trim();
        String matNumber = request.getParameter("matNumber").trim();
        String password = request.getParameter("password");
        String faculty = request.getParameter("faculty").trim();
        String departtment = request.getParameter("departtment").trim();
        String level = request.getParameter("level").trim();

        if(UserDAO.getStudentByMatricNumber(matNumber) != null)
            throw new IllegalArgumentException("An account with matric Number: " + matNumber + " already exists.");
        else if(password.isEmpty())
            throw new IllegalArgumentException("Please enter a password.");
        else if(password.length() < 6)
            throw new IllegalArgumentException("Password should be at least 6 characters.");
        else
        {
            Digester digester = new Digester();
            String hashedPassword = digester.doDigest(password);
            Student user = new Student();
            user.setDepartment(departtment);
            user.setMatricNumber(matNumber);
            user.setName(name);
            user.setFaculty(faculty);
            user.setLevel(level);
            user.setUserId(UserDAO.generateUniqueStudentId());
            user.setVotingPin(UserDAO.generateUniqueStudentVotingPin());
            user.setEncrytedPassword(hashedPassword);
            return user;
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

}
