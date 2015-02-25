/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.gemini.edu;

import java.io.IOException;
import java.io.PrintWriter;
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
                if (person.getName().equals(deletedName))
                    iter.remove();
            }
            
        }

        request.setAttribute("persons", persons);



        RequestDispatcher dispatcher =  getServletContext().getRequestDispatcher("/persons.jsp");
        dispatcher.forward(request, response);

    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
