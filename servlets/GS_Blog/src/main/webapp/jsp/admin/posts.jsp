<%@page contentType="text/html" pageEncoding="UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>

<jsp:include page="index.jsp"/>

        <table>

            <c:forEach items="${posts}" var="post">
                <tr>
                    <td style="background: #e6e6fa; width: 50%;">${post.title}</td>
                    <td style="background: #6495ed;"><a href="/admin?action=edit&post=${post.id}">Edit post</a></td>
                    <td style="background: #f08080;"><a href="/admin?action=delete&post=${post.id}">Delete post</a></td>
                </tr>
            </c:forEach>

        </table>

        <jsp:include page="../newPost.jsp"/>



</body>
</html>