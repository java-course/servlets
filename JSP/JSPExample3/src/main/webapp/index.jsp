<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%!


    public void p(String s){
        System.out.println(s);
    }

%>


<%

    String name = request.getParameter("name");
    p(name);
    String surname = request.getParameter("surname");
    p(surname);
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
          <h3>Name is <% out.println(name);%></h3><br/>
        <h3>Surname is <% out.println(surname);%></h3>


        <form action="index.jsp" method="post">
            <input type="text" name="name">
            <input type="text" name="surname">
            <input type="submit"/>
        </form>

    </body>
</html>
