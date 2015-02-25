<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <%
            String name = request.getAttribute("name").toString();
            String surname = request.getAttribute("surname").toString();

        %>

        <h3>Name is <%=name%></h3><br/>
        <h3>Surname is <% out.println(surname);%></h3>
    </body>
</html>
