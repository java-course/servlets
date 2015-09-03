package ru.javacourse.servlet;

import org.codehaus.jackson.map.ObjectMapper;
import ru.javacourse.servlet.model.Address;
import ru.javacourse.servlet.model.Person;
import ru.javacourse.servlet.model.Phone;
import ru.javacourse.servlet.util.PersonStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

/**
 * Created by Georgy Gobozov on 9/3/2015.
 */
@WebServlet(name = "JsonServlet", urlPatterns = "/json")
public class JsonServlet extends HttpServlet{


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Person> persons = PersonStorage.getPersons();

        StringBuffer buffer = new StringBuffer();

        buffer.append("{\"persons \": [");
        int p =0 ;
        for (Person person : persons) {
            p++;
            buffer.append("{").
                    append("\"name\" : ").append("\"").append(person.getFirstName()).append("\",").
                    append("\"surname\" : ").append("\"").append(person.getLastName()).append("\",").
                    append("\"age\" : ").append(person.getAge()).append(",");

            Address a = person.getAddress();

            buffer.append("\"address\": {").
                    append("\"city\" : ").append("\"").append(a.getCity()).append("\",").
                    append("\"street\" : ").append("\"").append(a.getStreet()).append("\",").
                    append("\"zip\" : ").append(a.getZip()).append("},");

            List<Phone> phones = person.getNumbers();

            buffer.append("\"phoneNumbers\": [ " );

            int i = 0;
            for (Phone phone : phones) {
                i++;
                buffer.append("{\"type\" : ").append("\"").append(phone.getType()).append("\",").
                        append("\"number\" : ").append("\"").append(phone.getNumber()).append("\"}");

                if (i != persons.size())
                    buffer.append(",");

            }
            buffer.append("]");
            buffer.append("}");
            if (p != persons.size())
                buffer.append(",");



        }
        buffer.append("]}");


        response.setContentType("application/json");
        Writer writer = response.getWriter();

        writer.write(buffer.toString());
        writer.flush();
        writer.close();

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Person> persons = PersonStorage.getPersons();

        ObjectMapper mapper = new ObjectMapper();
        String result = mapper.writeValueAsString(persons);

        response.setContentType("application/json");
        Writer writer = response.getWriter();

        writer.write(result);
        writer.flush();
        writer.close();


    }
}
