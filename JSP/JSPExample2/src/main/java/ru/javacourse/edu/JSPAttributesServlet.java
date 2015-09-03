/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.javacourse.edu;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gb
 */
public class JSPAttributesServlet extends HttpServlet {
   

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String name = request.getParameter("name");
        String surname= request.getParameter("surname");

        request.setAttribute("name", name != null ? name : "");
        request.setAttribute("surname", surname != null ? surname : "");

        RequestDispatcher dispatcher =  getServletContext().getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);

    } 


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }


}
