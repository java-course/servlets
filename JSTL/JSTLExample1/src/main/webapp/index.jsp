<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <h3>JSTL EXPRESSION 2 + 2</h3>

        ${2+2}

        <h3>JSTL IF</h3>

        <c:if test="${3 > 2}">
            3 > 2
        </c:if>


        <br/>

        <h3>JSTL SET AND FOREACH</h3>
        <c:set var="t" value="1"/>

        <c:forEach begin="${t}" end="10">
            <c:set var="t" value="${t+1}"/>
            ${t}
        </c:forEach>

        <br/>

        <%
            String [] array = new String[]{"one", "two", "three"};
            pageContext.setAttribute("array", array);

        %>


        <c:forEach items="${array}" var="s">
            ${s}
        </c:forEach>

         <br/>

         <h3>JSTL URL</h3>
        <c:url var="url" value="index.jsp">
            <c:param name="param1" value="test"/>
            <c:param name="param2" value="hello"/>
        </c:url>

        <a href="${url}">Link</a>

        <h3>JSTL PARAM</h3>
        param1 = ${param.param1}<br/>
        param2 = ${param.param2}

        <br/>

        



    </body>

</html>
