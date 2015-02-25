/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.javacourse.edu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gb
 */
public class FormServlet extends HttpServlet {
   
    private List<Person> persons;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        persons = new ArrayList<Person>();
        persons.add(new Person("Ivan", "Ivanov"));
        persons.add(new Person("Petr", "Petrov"));
        persons.add(new Person("Igor", "Antonov"));
    }




    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        if (request.getParameter("submit") != null){

            String name = request.getParameter("name");
            String surname = request.getParameter("surname");
            persons.add(new Person(name, surname));
        }


        if (request.getParameter("delete") != null){
            String deletedName = request.getParameter("delete");
            Iterator<Person> iter = persons.iterator();
            while (iter.hasNext()) {
                Person person = iter.next();
                if (person.getName().equals(deletedName)) {
                    iter.remove();
                }

            }
            
        }

        request.setAttribute("persons", persons);
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


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
