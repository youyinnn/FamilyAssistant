<%@ page import="db.Table_Location" %><%--
  Created by IntelliJ IDEA.
  User: youyinnn
  Date: 2017/2/19
  Time: 11:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <form action="<%=request.getContextPath()%>/us/location" method="post">
        UserID: <input type="text" name="<%=Table_Location.COLUMN_ID%>"><br>
        Longitude:<input type="text" name="longitude" value="lon"><br>
        Latitude:<input type="text" name="latitude" value="lat"><br>
        <input type="submit" value="Submit">
        <input type="hidden" name="equip" value="NewThreadAndroid">
    </form>

</body>
</html>
