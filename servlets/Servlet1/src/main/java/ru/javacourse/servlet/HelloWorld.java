package ru.javacourse.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorld extends HttpServlet {


    @Override
     public void init(ServletConfig servletConfig) throws ServletException {
        super.init(servletConfig);
        System.out.println("Start...");

    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        // Теперь получаем поток символов для записи

        try (PrintWriter out = response.getWriter();){
            // И пишем в него обычный HTML
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HelloWorld</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HelloWorld for Java course</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }



    @Override
    public void destroy() {
        super.destroy();
        System.out.println("Finish...");
    }


}
