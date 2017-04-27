<%--
  Created by IntelliJ IDEA.
  User: youyinnn
  Date: 2017/4/3
  Time: 23:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>FamilyAssistant Test</title>
</head>
<body>

    <%="Session_id :"+session.getId()%>
    <br>

    test 4.6.9
    <br>
    LoginService:<br>
    <a href="login.jsp">Login</a><br>
    <a href="signIn.jsp">SignIn</a><br>
    <a href="verify.jsp">Verify</a><br>
    <br>
    FriendService:<br>
    <a href="addFriend.jsp">AddFriend</a><br>
    <a href="deleteFriend.jsp">DeleteFriend</a><br>
    <a href="schUserInfo.jsp">SearchUser</a><br>
    <br>
    UserService:<br>
    <a href="cgPassword.jsp">ChangePassword</a><br>
    <a href="cgUserInformation.jsp">ChangeUserInfo</a><br>
    <a href="cgFriendInfo.jsp">ChangeFriendInfo</a><br>
    <a href="cgPortrait.jsp">ChangePortrait</a><br>
    <a href="soFriendInfo.jsp">ShowFriendInfo</a><br>
    <a href="location.jsp">Location</a><br>
    <a href="cgCare.jsp">Care</a><br>
    <a href="removeCare.jsp">RemoveCare</a><br>
    <a href="soCareBy.jsp">ShowCareBy</a><br>
    <a href="getFriendList.jsp">GetFriendList</a><br>
    <a href="getFriendsInfo.jsp">GetFriendsInfo</a><br>
    <br>
    <br>
    <br>
    <a href="<%=request.getContextPath()%>/ss/getAllUserInfo">ShowAllUserInfo</a>
    <a href="<%=request.getContextPath()%>/ss/getAllFriendInfo">ShowAllFriendInfo</a>
    <a href="<%=request.getContextPath()%>/ss/getAllLocation">ShowAllUseLocation</a>
    <br>
    <br>
    <br>
    <form action="<%=request.getContextPath()%>/index.jsp" method="post">
        <input name="submit" type="submit" value="Logout">
    </form>


</body>
</html>
