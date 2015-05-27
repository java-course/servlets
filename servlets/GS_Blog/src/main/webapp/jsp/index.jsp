<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
    <body>

    <fmt:setLocale value="<%=request.getLocale()%>"/>
    <fmt:bundle basename="messages">


       <jsp:include page="header.jsp"/>


        <table width="100%">
            <tr>
                <td colspan="2" align="right"><a href="/newpost">Create Post</a></td>
            </tr>

            <tr>
                <td width="70%" valign="top">
                    <h2>Posts</h2>

                    <c:forEach items="${posts}" var="post">
                        <h1>${post.title}</h1>
                        <p>${post.summary}</p>
                        <a href="/blog?post=${post.id}">Read more...</a>
                        <hr/>
                    </c:forEach>

                </td>


                <td  valign="top" style="background-color: lightgoldenrodyellow">
                    <h2>Categories:</h2>
                    <ul>
                    <c:forEach items="${categories}" var="cat">
                        <li><a href="/blog?category=${cat.id}">${cat.name}</a></li>
                    </c:forEach>
                    </ul>
                </td>
            </tr>

        </table>

        <hr/>
        <fmt:message key="page"/>
    </fmt:bundle>

    </body>
</html>
