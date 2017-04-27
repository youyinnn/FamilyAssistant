<%@ page import="db.Table_User" %><%--
  Created by IntelliJ IDEA.
  User: youyinnn
  Date: 2017/2/18
  Time: 21:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <form action="<%=request.getContextPath()%>/us/cgPortrait" method="post" enctype="multipart/form-data">
        Username:<input type="text" name="<%=Table_User.COLUMN_USERNAME%>"><br>
        NewPortrait:<input type="file" name="portrait"><br>
        <input type="submit" value="UpLoadPortrait">
        <input type="hidden" name="equip" value="NewThreadAndroid">
    </form>

</body>
</html>
