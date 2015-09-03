package ru.javacourse.jstl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Georgy Gobozov on 6/1/2015.
 */
public class BookServlet extends HttpServlet {


    private List<Book> books;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        books = new ArrayList<Book>();
        books.add(new Book("Book1", "Author1", 10));
        books.add(new Book("Book2", "Author2", 20));
        books.add(new Book("Book3", "Author3", 30));
        books.add(new Book("Book4", "Author4", 40));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        request.setAttribute("books", books);

        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);


    }
}
