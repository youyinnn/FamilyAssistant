<%--
  Created by IntelliJ IDEA.
  User: youyinnn
  Date: 2017/2/18
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <form action="<%=request.getContextPath()%>/fs/deleteFriend" method="post">
         UserID:<input type="text" name="u_id"><br>
         FriendID:<input type="text" name="f_id">
         <input type="submit" value="DeleteFriend">
        <input type="hidden" name="equip" value="NewThreadAndroid">
    </form>

</body>
</html>
