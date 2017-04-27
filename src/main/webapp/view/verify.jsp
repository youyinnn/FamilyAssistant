<%@ page import="db.Table_User" %><%--
  Created by IntelliJ IDEA.
  User: youyinnn
  Date: 2017/2/16
  Time: 9:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Verify</title>
</head>
<body>

    <form action="<%=request.getContextPath()%>/lg/verify" method="post">
        Username:<input type="text" name="<%=Table_User.COLUMN_USERNAME%>">
        <input type="hidden" name="equip" value="NewThreadAndroid">
        <input type="submit" value="Verify!">
    </form>
</body>
</html>
