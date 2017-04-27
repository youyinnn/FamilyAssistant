<%@ page import="db.Table_User" %><%--
  Created by IntelliJ IDEA.
  User: youyinnn
  Date: 2017/2/16
  Time: 8:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

    <form action="<%=request.getContextPath()%>/lg/login" method="post">
        Username:<input type="text" name="<%=Table_User.COLUMN_USERNAME%>">
        <br>
        Password:<input type="password" name="<%=Table_User.COLUMN_PASSWORD%>">
        <input type="submit" value="Login">
        <input type="hidden" name="equip" value="NewThreadAndroid">
    </form>

</body>
</html>
