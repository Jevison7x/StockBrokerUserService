package com.bizblock.user;

import com.bizblock.library.company.CompanyStock;
import com.bizblock.library.company.CompanyStockDAO;
import com.bizblock.library.user.UserStock;
import com.bizblock.library.user.UserStockDAO;
import com.bizblock.library.user.UserTokenDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
public class ListOfUserStockServlet extends HttpServlet
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
        JSONObject jsono = new JSONObject();
        try
        {
            String username = request.getParameter("username");
            String token = request.getParameter("token");
            if(UserTokenDAO.tokenIsValid(username, token))
            {
                List<UserStock> userStocks = UserStockDAO.getAllUserStockByUserName(username);
                List<CompanyStock> companyStocks = CompanyStockDAO.getAllCompanyStocks();
                jsono.put("status", "success");
                jsono.put("userStockArray", userStocks);
                jsono.put("companyStocks", companyStocks);
                out.print(jsono);
            }
            else
            {
                jsono.put("status", "expiredSession");
                jsono.put("message", "Your session has expired, please login.");
                out.print(jsono);
            }
        }
        catch(Exception e)
        {
            try
            {
                jsono.put("status", "error");
                jsono.put("message", e.getMessage());
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
