<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${sessionScope.userList}" var="user">
    <h1>User : ${user.username}</h1>
</c:forEach>
<br><br>




<form action="login.do" method="post">
    <input type="text" name="username" value="${cookie.username.value}" required>
    <input type="text" name="password" value="${cookie.password.value}" required>
    <label>
        Remember Me <input type="checkbox" name="rememberMe">
    </label>
    <input type="submit" value="login"></form>


</body>
</html>
