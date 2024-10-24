<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
</head>
<body>
<a href="/admin/adminPanel.do">Admin Panel</a>

<%--<c:forEach var="i" begin="1" end="10" step="1">--%>

<%--    <c:choose>--%>
<%--        <c:when test="${i% 3==0}">--%>
<%--            <h1>three${i}</h1>--%>
<%--        </c:when>--%>
<%--        <c:when test="${i%2==0}">--%>
<%--            <h1>two${i}</h1>--%>
<%--        </c:when>--%>
<%--        <c:otherwise>--%>
<%--            <h1>sayer</h1>--%>

<%--        </c:otherwise>--%>
<%--    </c:choose>--%>
<%--</c:forEach>--%>

<c:forEach items="${adminList}" var="admin">
    <h1>${admin.name}</h1>
</c:forEach>
</body>
</html>