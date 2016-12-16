<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
    <meta charset="utf-8">
<body>
<h2>Hello World!</h2>

    <form method="get" action="/springmvc/testPojo">
        username:<input type="text" name="username"/><br>
        password:<input type="text" name="password"/><br>
        age:<input type="text" name="age"><br>
        province:<input type="text" name="address.province" /><br>
        city:<input type="text" name="address.city"><br>
        birthday:<input type="text" name="birthday"><br>
        <input type="submit" value="Submit"><br>
    </form>

    <br><br>
    <a href="/springmvc/testMap">test Map</a>
    <br>
    <a href="/attribute/testSessionAttribute">test SessionAttribute</a>
    <br><br>
    <!--
        不能修改密码
    -->

    <form method="post" action="/attribute/testModelAttribute">
        <input type="hidden" name="id" value="1">
        username:<input type="text" name="username" value="tom"><br>
        age:<input type="text" name="age" value="23">
        <input type="submit" value="submit">
    </form>
    <br>

    <a href="/view/testView">test view</a>
    <a href="/view/testRedirect">test redirect</a>

    <br><br>

    <%--<form:form action="/data/test/Converter" method="get">--%>
        <%--<form:errors path="*"></form:errors>--%>
    <%--</form:form>--%>
    <form:form action="/data/testConverter" method="get">
        <form:errors path="*"></form:errors>
        user:<input type="text" name="user">
        <input type="submit" name="submit">
    </form:form>

    <form method="get" action="/data/testValidate">
        username:<input type="text" name="username"/><br>
        password:<input type="text" name="password"/><br>
        age:<input type="text" name="age"><br>
        province:<input type="text" name="address.province" /><br>
        city:<input type="text" name="address.city"><br>
        birthday:<input type="text" name="birthday"><br>
        <input type="submit" value="Submit"><br>
    </form>

    <a href="/internat/testLocal">test local</a>

    <br>
    <form action="/internat/testFile" method="post" enctype="multipart/form-data">
        file:<input type="file" name="file"><br>
        desc:<input type="text" name="desc">
        <input type="submit" value="提交">
    </form>
    <br>
    <a href="internat/testDown">test file down</a>
    <a href="exception/testException?num=10">test exception</a>
</body>
</html>
