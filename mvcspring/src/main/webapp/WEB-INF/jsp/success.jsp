<%--
  Created by IntelliJ IDEA.
  User: ason
  Date: 2016/12/14
  Time: 10:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    success<br>
    names:${ requestScope.names }
    <br>
    request user:${requestScope.user}<br>
    session user:${sessionScope.user}
    <br>
    <fmt:message key="username"></fmt:message>
    <br>
    <fmt:message key="password"></fmt:message>


</body>
</html>
