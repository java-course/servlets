package ru.javacourse.session;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GetInfo1 extends HttpServlet {

    public static final String PARAMETER_SESSION = "paremeterSession";
    public static final String PARAMETER_CONTEXT = "paremeterContext";


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // Получаем параметр из запроса
        String param = request.getParameter("parameter");
        // Запоминаем параметр в сессии

        HttpSession session = request.getSession(true);
        session.setAttribute(PARAMETER_SESSION, param);

        getServletContext().setAttribute(PARAMETER_CONTEXT, param);

        PrintWriter out = response.getWriter();
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet GetInfo1</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet GetInfo1</h1>");
            out.println("<a href='GetInfo2'>Show parameter</a>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    } 
}
