<%@ page import="db.Table_User" %><%--
  Created by IntelliJ IDEA.
  User: youyinnn
  Date: 2017/2/19
  Time: 22:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <form action="<%=request.getContextPath()%>/us/getFriendList" method="post">
        ID:<input type="text" name="<%=Table_User.COLUMN_ID%>">
        <input type="submit" value="GetFriendList">
        <input type="hidden" name="equip" value="NewThreadAndroid">
    </form>

</body>
</html>
