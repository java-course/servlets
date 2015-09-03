<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="my" uri="http://javacourse.ru/jsp/tlds/mytags"%>



<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>

Today <my:ruDate/>
<br/>
Formatted date <my:formatDate format="MM/dd/yyyy"/>



<ul>

    <c:forEach items="${books}" var="b">

        <c:set var="color"/>

        <c:choose>

            <c:when test="${b.price < 20}">
                <c:set var="color" value="red"/>
            </c:when>

            <c:otherwise>
                <c:set var="color" value="blue"/>
            </c:otherwise>

        </c:choose>


        <li style="color:${color};">${fn:toUpperCase(b.name)} ${b.author}   </li>


    </c:forEach>

</ul>


</body>
</html>
