package com.bizblock.user;

import com.bizblock.user.util.DateTimeUtil;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Praise
 */
public class LoginUserServlet extends HttpServlet
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
            String userNameOrEmail = request.getParameter("userNameOrEmail");
            String password = request.getParameter("password");
            String rememberMe = request.getParameter("rememberMe");
            User user = UserDAO.loginUser(userNameOrEmail, password);
            if(user != null)
            {
                UserToken userToken = UserTokenDAO.getUserTokenByUserName(user.getUserName());
                if(rememberMe != null)
                    if(userToken == null)
                    {
                        Timestamp timestamp = DateTimeUtil.getTodayTimeZone();
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTimeInMillis(timestamp.getTime());
                        calendar.add(Calendar.DAY_OF_MONTH, 7);
                        Timestamp newTimestamp = new Timestamp(calendar.getTimeInMillis());

                        userToken = new UserToken();
                        userToken.setUserName(user.getUserName());
                        userToken.setToken(UserTokenDAO.generateUniqueUserToken());
                        userToken.setLifeSpan(104300);
                        userToken.setExpiryDate(newTimestamp);
                        UserTokenDAO.registerNewUserToken(userToken);
                    }
                    else
                    {
                        Timestamp timestamp = DateTimeUtil.getTodayTimeZone();
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTimeInMillis(timestamp.getTime());
                        calendar.add(Calendar.DAY_OF_MONTH, 7);
                        Timestamp newTimestamp = new Timestamp(calendar.getTimeInMillis());

                        userToken.setExpiryDate(newTimestamp);
                        userToken.setLifeSpan(104300);
                        UserTokenDAO.updateUserTokenExpiryDateAndLifeSpan(userToken);
                    }
                else if(userToken == null)
                {
                    Timestamp timestamp = DateTimeUtil.getTodayTimeZone();
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTimeInMillis(timestamp.getTime());
                    calendar.add(Calendar.DAY_OF_MONTH, 1);
                    Timestamp newTimestamp = new Timestamp(calendar.getTimeInMillis());

                    userToken = new UserToken();
                    userToken.setUserName(user.getUserName());
                    userToken.setToken(UserTokenDAO.generateUniqueUserToken());
                    userToken.setLifeSpan(1443);
                    userToken.setExpiryDate(newTimestamp);
                    UserTokenDAO.registerNewUserToken(userToken);
                }
                else
                {
                    Timestamp timestamp = DateTimeUtil.getTodayTimeZone();
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTimeInMillis(timestamp.getTime());
                    calendar.add(Calendar.DAY_OF_MONTH, 1);
                    Timestamp newTimestamp = new Timestamp(calendar.getTimeInMillis());

                    userToken.setExpiryDate(newTimestamp);
                    userToken.setLifeSpan(1443);
                    UserTokenDAO.updateUserTokenExpiryDateAndLifeSpan(userToken);
                }

                JSONObject jsono = new JSONObject();
                jsono.put("status", "success");
                jsono.put("user", new JSONObject(user));
                jsono.put("userToken", userToken.getToken());
                out.print(jsono);
            }
            else
            {
                JSONObject jsono = new JSONObject();
                jsono.put("status", "error");
                jsono.put("message", "Invalid username or password.");
                out.print(jsono);
            }
        }
        catch(Exception xcp)
        {
            try
            {
                JSONObject jsono = new JSONObject();
                jsono.put("status", "error");
                jsono.put("message", xcp.getMessage());
                out.print(jsono);
            }
            catch(JSONException jsone)
            {
                throw new RuntimeException(jsone);
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
