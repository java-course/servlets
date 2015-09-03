package ru.javacourse.session;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static ru.javacourse.session.GetInfo1.*;

/**
 *
 * @author ASaburov
 */
public class GetInfo2 extends HttpServlet {
   

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Получаем параметр из сессии и покажем его на экране
        // Т.к. в сессии храняться Object - приводим к нужному типу
        String param = (String)request.getSession(true).getAttribute(PARAMETER_SESSION);

        String param2 = (String) getServletContext().getAttribute(PARAMETER_CONTEXT);

        PrintWriter out = response.getWriter();
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet GetInfo2</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Session parameter:" + param + "</h1>");
            out.println("<h1>Servlet Context parameter:" + param2 + "</h1>");
            out.println("<a href='index.html'>Go home</a>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    } 
}
