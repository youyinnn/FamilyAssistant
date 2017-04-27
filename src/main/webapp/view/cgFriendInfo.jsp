<%@ page import="db.Table_Friend_List" %><%--
  Created by IntelliJ IDEA.
  User: youyinnn
  Date: 2017/2/18
  Time: 19:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <form action="<%=request.getContextPath()%>/us/changeFriendInfo" method="post">
        ID:<input type="text" name="<%=Table_Friend_List.COLUMN_ID%>"><br>
        FriendID:<input type="text" name="<%=Table_Friend_List.COLUMN_FRIEND_ID%>"><br>
        Relationship:<input type="text" name="<%=Table_Friend_List.COLUMN_RELATIONSHIP%>"><br>
        Remark:<input type="text" name="<%=Table_Friend_List.COLUMN_REMARK%>"><br>
        <input type="submit" value="Change">
        <input type="hidden" name="equip" value="NewThreadAndroid">
    </form>

</body>
</html>
