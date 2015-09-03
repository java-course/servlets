<%@ page import="java.util.List"%>
<%@ page import="ru.javacourse.edu.Person" %>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <%
            List<Person> persons = (List<Person>)request.getAttribute("persons");
        %>

        Employee list:
        <ul>
        <%for (Person p: persons){%>

        <li><%=p.getName() + " " + p.getSurname()%> <a href="FormServlet?delete=<%=p.getName()%>">Удалить</a></li>

        <%}%>
        </ul>



        <form action="FormServlet" method="POST">
            Имя: <input type="text" name="name"> <br/>
            Фамилия: <input type="text" name="surname"> <br/>
            <input type="submit" name="submit"/>
        </form>
    </body>
</html>
