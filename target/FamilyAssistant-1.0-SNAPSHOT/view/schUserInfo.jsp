<%@ page import="db.Table_User" %><%--
  Created by IntelliJ IDEA.
  User: youyinnn
  Date: 2017/2/18
  Time: 18:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <form action="<%=request.getContextPath()%>/fs/searchUser" method="post">
        Username:<input type="text" name="<%=Table_User.COLUMN_USERNAME%>">
        <input type="hidden" name="equip" value="NewThreadAndroid">
        <input type="submit" value="Search">
    </form>
</body>
</html>
