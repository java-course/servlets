/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.javacourse.edu;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author gb
 */
public class JSPUsageServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");


        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/index.jsp");
        dispatcher.forward(request, response);
    }


}
