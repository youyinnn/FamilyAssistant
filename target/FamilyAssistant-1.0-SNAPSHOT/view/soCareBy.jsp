<%@ page import="db.Table_User" %><%--
  Created by IntelliJ IDEA.
  User: youyinnn
  Date: 2017/2/19
  Time: 21:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <form action="<%=request.getContextPath()%>/us/showCareBy" method="post">
        ID:<input type="text" name="<%=Table_User.COLUMN_ID%>">
        <input type="hidden" name="equip" value="NewThreadAndroid">
        <input type="submit" value="ShowCareBy">
    </form>

</body>
</html>
