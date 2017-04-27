<%@ page import="db.Table_User" %><%--
  Created by IntelliJ IDEA.
  User: youyinnn
  Date: 2017/2/17
  Time: 18:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ChangePassword</title>
</head>
<body>

    <form action="<%=request.getContextPath()%>/us/cgPassword" method="post">
        Username:<input type="text" name="<%=Table_User.COLUMN_USERNAME%>"><br>
        NewPassword:<input type="text" name="<%=Table_User.COLUMN_PASSWORD%>">
        <input type="submit" value="ChangePassword">
        <input type="hidden" name="equip" value="NewThreadAndroid">
    </form>

</body>
</html>
