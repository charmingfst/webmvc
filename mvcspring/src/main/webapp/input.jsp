<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ason
  Date: 2016/12/15
  Time: 14:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<!--
    modelAttribute属性指定该form绑定的是哪个Model，当指定了对应的Model后就可以在form标签内部其它表单标签上通过为path指定Model属性的名称来绑定Model中的数据了
-->
<form:form method="get" action="/data/testValidate" modelAttribute="user">
    <form:errors path="*"></form:errors><br>
    username:<form:input path="username"/><br>
    password:<form:input path="password"/><br>
    age:<form:input path="age" /><br>
    province:<input type="text" name="address.province" /><br>
    city:<input type="text" name="address.city"><br>
    birthday:<input type="text" name="birthday"><br>
    <input type="submit" value="Submit"><br>
</form:form>
</body>
</html>
