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
package com.dickens.election;

import com.dickens.users.Candidate;
import com.dickens.users.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;

/**
 *
 * @author BLAZE
 */
public class HandleElectionServlet extends HttpServlet
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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try
        {
            String canId = request.getParameter("canId");
            String votingPin = request.getParameter("votingPin");
            Candidate can = UserDAO.getCandidateByName(canId);

            String positionOfCandidate = can.getPosition();
            if(votingPin.isEmpty())
            {
                JSONObject jsono = new JSONObject();
                jsono.put("message", "Opps Login to continue");
                out.print(jsono);
            }
            else
                switch(positionOfCandidate)
                {
                    case "president":
                        if(ElectionDAO.votingPinExistsInPresido(votingPin) != true)
                        {
                            PresidentRun presido = new PresidentRun();
                            presido.setCanId(canId);
                            presido.setVotingPin(votingPin);
                            presido.setId(ElectionDAO.generateUniquePresidoID());
                            ElectionDAO.registerNewPresido(presido);
                            JSONObject jsono = new JSONObject();
                            jsono.put("message", "success");
                            out.print(jsono);
                        }
                        else
                        {
                            JSONObject jsono = new JSONObject();
                            jsono.put("message", "You have already voted");
                            out.print(jsono);
                        }
                        break;
                    case "vp":
                        if(ElectionDAO.votingPinExistsInVP(votingPin) != true)
                        {
                            VPRun vp = new VPRun();
                            vp.setCanId(canId);
                            vp.setId(ElectionDAO.generateUniqueVpID());
                            vp.setVotingPin(votingPin);
                            ElectionDAO.registerNewVP(vp);
                            JSONObject jsono = new JSONObject();
                            jsono.put("message", "success");
                            out.print(jsono);
                        }
                        else
                        {
                            JSONObject jsono = new JSONObject();
                            jsono.put("message", "You have already voted");
                            out.print(jsono);
                        }
                        break;
                    case "sg":
                        if(ElectionDAO.votingPinExistsInSG(votingPin) != true)
                        {
                            SGRun sg = new SGRun();
                            sg.setCanId(canId);
                            sg.setId(ElectionDAO.generateUniqueSGID());
                            sg.setVotingPin(votingPin);
                            ElectionDAO.registerNewSG(sg);
                            JSONObject jsono = new JSONObject();
                            jsono.put("message", "success");
                            out.print(jsono);
                        }
                        else
                        {
                            JSONObject jsono = new JSONObject();
                            jsono.put("message", "You have already voted");
                            out.print(jsono);
                        }
                        break;
                    case "dos":
                        if(ElectionDAO.votingPinExistsInDOS(votingPin) != true)
                        {
                            DOSRun dos = new DOSRun();
                            dos.setCanId(canId);
                            dos.setId(ElectionDAO.generateUniqueDOSID());
                            dos.setVotingPin(votingPin);
                            ElectionDAO.registerNewDOS(dos);
                            JSONObject jsono = new JSONObject();
                            jsono.put("message", "success");
                            out.print(jsono);
                        }
                        else
                        {
                            JSONObject jsono = new JSONObject();
                            jsono.put("message", "You have already voted");
                            out.print(jsono);
                        }
                        break;
                    case "dosp":
                        if(ElectionDAO.votingPinExistsInDOSp(votingPin) != true)
                        {
                            DOSpRun dosp = new DOSpRun();
                            dosp.setCanId(canId);
                            dosp.setId(ElectionDAO.generateUniqueDOSpID());
                            dosp.setVotingPin(votingPin);
                            ElectionDAO.registerNewDOSp(dosp);
                            JSONObject jsono = new JSONObject();
                            jsono.put("message", "success");
                            out.print(jsono);

                        }
                        else
                        {
                            JSONObject jsono = new JSONObject();
                            jsono.put("message", "You have already voted");
                            out.print(jsono);
                        }
                        break;
                    case "dow":
                        if(ElectionDAO.votingPinExistsInDOW(votingPin) != true)
                        {
                            DOWRun dow = new DOWRun();
                            dow.setCanId(canId);
                            dow.setId(ElectionDAO.generateUniqueDOSpID());
                            dow.setVotingPin(votingPin);
                            ElectionDAO.registerNewDOW(dow);
                            JSONObject jsono = new JSONObject();
                            jsono.put("message", "success");
                            out.print(jsono);
                        }
                        else
                        {
                            JSONObject jsono = new JSONObject();
                            jsono.put("message", "You have already voted");
                            out.print(jsono);
                        }
                        break;
                    case "doi":
                        if(ElectionDAO.votingPinExistsInDOI(votingPin) != true)
                        {
                            DOIRun doi = new DOIRun();
                            doi.setCanId(canId);
                            doi.setId(ElectionDAO.generateUniqueDoiID());
                            doi.setVotingPin(votingPin);
                            ElectionDAO.registerNewDOI(doi);
                            JSONObject jsono = new JSONObject();
                            jsono.put("message", "success");
                            out.print(jsono);
                        }
                        else
                        {
                            JSONObject jsono = new JSONObject();
                            jsono.put("message", "You have already voted");
                            out.print(jsono);
                        }
                        break;
                    case "fs":
                        if(ElectionDAO.votingPinExistsInFS(votingPin) != true)
                        {
                            FSRun fs = new FSRun();
                            fs.setCanId(canId);
                            fs.setId(ElectionDAO.generateUniqueFSID());
                            fs.setVotingPin(votingPin);
                            ElectionDAO.registerNewFS(fs);
                            JSONObject jsono = new JSONObject();
                            jsono.put("message", "success");
                            out.print(jsono);
                        }
                        else
                        {
                            JSONObject jsono = new JSONObject();
                            jsono.put("message", "You have already voted");
                            out.print(jsono);
                        }
                        break;
                    default:
                    {
                        JSONObject jsono = new JSONObject();
                        jsono.put("message", "Opps no position");
                        out.print(jsono);
                    }
                    break;
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

}
