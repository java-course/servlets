package ru.javacourse.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/HelloWorld", "/url2"}, name = "HelloWorldServlet")
public class HelloWorld extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
        try {
            // И пишем в него обычный HTML
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HelloWorld</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HelloWorld for Java course</h1>");

            // Здесь мы вставляем ссылку на картинку, которую получаем с помощью сервлета HelloImage
            out.println("<img src='/HelloImage'/>");

            out.println("</body>");
            out.println("</html>");
        } finally {
            // И закрываем поток
            out.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
