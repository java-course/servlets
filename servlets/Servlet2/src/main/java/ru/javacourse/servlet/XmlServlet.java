package ru.javacourse.servlet;

import ru.javacourse.servlet.model.Person;
import ru.javacourse.servlet.util.PersonStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.IOException;

/**
 * Created by Georgy Gobozov on 9/3/2015.
 */
@WebServlet(name = "XmlServlet", urlPatterns = "/xml")
public class XmlServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {

        Person person = PersonStorage.getPersons().get(0);

        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(Person.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(person, httpServletResponse.getWriter());

        } catch (JAXBException e) {
            e.printStackTrace();
        }


    }
}
