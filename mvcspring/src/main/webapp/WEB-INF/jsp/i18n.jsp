<%--
  Created by IntelliJ IDEA.
  User: ason
  Date: 2016/12/15
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    ${requestScope.username}
    <a href="/internat/testLocal?locale=zh_CN">中文</a>
    <a href="/internat/testLocal?locale=en_US">英文</a>
</body>
</html>
