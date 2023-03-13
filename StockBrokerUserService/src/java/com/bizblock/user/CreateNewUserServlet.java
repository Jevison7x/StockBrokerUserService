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
package com.bizblock.user;

import com.bizblock.user.security.Digester;
import com.bizblock.user.util.DateTimeUtil;
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
public class CreateNewUserServlet extends HttpServlet
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
            String email = request.getParameter("email").trim();
            String userName = request.getParameter("userName").trim();
            String firstName = request.getParameter("firstName").trim();
            String password = request.getParameter("password");
            String conpassword = request.getParameter("conpassword");
            String lastName = request.getParameter("lastName").trim();
            if(UserDAO.getUserByUserNameOrEmail(email) != null)
                throw new IllegalArgumentException("An account  already exists with those details.");
            else if(password.length() < 6)
                throw new IllegalArgumentException("Password should be at least 6 characters.");
            else if(!password.equals(conpassword))
                throw new IllegalArgumentException("The passwords did not match.");
            else
            {
                Digester digester = new Digester();
                String hashedPassword = digester.doDigest(password);
                User user = new User();
                user.setUserName(userName);
                user.setEmail(email);
                user.setEncrytedPassword(hashedPassword);
                user.setDateTimeCreated(DateTimeUtil.getTodayTimeZone());
                user.setFirstName(firstName);
                user.setLastName(lastName);

                UserDAO.registerNewUser(user);

                System.out.println("Regitered user.................");
                JSONObject jsono = new JSONObject();
                jsono.put("message", "success");
                out.print(jsono);
            }
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
