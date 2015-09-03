package ru.javacourse.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Приме для демонстрации получения параметров из запроса
 *
 * @author ASaburov
 */
public class ShowParameterServlet extends HttpServlet {


     @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        // Получаем параметры из запроса по имени
        String param1 = request.getParameter("parameter1");
        String param2 = request.getParameter("parameter2");
        String param3 = request.getParameter("parameter3");

        String param4 = request.getParameter("text");
        String param5 = request.getParameter("select");
        String param6 = request.getParameter("check");

        // Вариант для просмотра всех параметров взапросе
        for(Enumeration en = request.getParameterNames(); en.hasMoreElements();) {
            String name = (String)en.nextElement();
            String value = request.getParameter(name);

            System.out.println("Name:" + name);
            System.out.println("Value:" + value);
        }

        // Также обратите внимание, что может быть вызов для получения нескольких величин
        //String[] values = request.getParameterValues("check");

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ShowParameterServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ShowParameterServlet</h1>");
            out.println("<h1>Parameter1 = " + param1 + "</h1>");
            out.println("<h1>Parameter2 = " + param2 + "</h1>");
            out.println("<h1>Parameter3 = " + param3 + "</h1>");
            out.println("<h1>Parameter4 = " + param4 + "</h1>");
            out.println("<h1>Parameter5 = " + param5 + "</h1>");
            out.println("<h1>Parameter6 = " + param6 + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }

    } 

}
