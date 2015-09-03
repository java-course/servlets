package ru.javacourse.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Georgy Gobozov on 5/28/2015.
 */
@WebServlet(urlPatterns = {"/login", "/welcome"})
public class LoginServlet extends HttpServlet{


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        if (login.equals("admin") && password.equals("admin")){
            request.getSession(true).setAttribute("token", 1);

            response.sendRedirect("/welcome");

        } else {
            response.sendRedirect("/login.html");
        }

    }


    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        PrintWriter out = httpServletResponse.getWriter();
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Filter Example</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Welcome to secured area</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }

    }
}
