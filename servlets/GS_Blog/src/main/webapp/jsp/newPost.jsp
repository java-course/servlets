<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>

<jsp:include page="header.jsp"/>

<form action="/blog" method="POST">


    <c:choose>
        <c:when test="${post ne null}">
            <c:set var="isEdit" value="true"/>
            <h1>Edit blog post ${post.title}</h1>
        </c:when>
        <c:otherwise>
            <h1>Create new blog post</h1>
        </c:otherwise>
    </c:choose>


    <table>

        <c:if test="${isEdit}">
            <input type="hidden" name="id" value="${post.id}"/>
        </c:if>

        <tr>
            <td>Title</td>
            <td><input type="text" name="title"
                       <c:if test="${isEdit}">value="${post.title}"</c:if> ></td>
        </tr>
        <tr>
            <td>Summary</td>
            <td><textarea name="summary" rows="10" cols="60"> <c:if test="${isEdit}">${post.summary}</c:if></textarea>
            </td>
        </tr>
        <tr>
            <td>Body</td>
            <td><textarea name="body" rows="30" cols="60"> <c:if test="${isEdit}">${post.body}</c:if></textarea></td>
        </tr>
        <tr>
            <td>Category</td>
            <td>

                <select name="category">
                    <c:forEach items="${categories}" var="cat">
                        <option
                                <c:if test="${isEdit && cat.id == post.id}">selected="selected"</c:if>
                                value="${cat.id}">${cat.name}</option>
                    </c:forEach>
                </select>


            </td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Submit"></td>
        </tr>
    </table>


</form>


</body>
</html>
