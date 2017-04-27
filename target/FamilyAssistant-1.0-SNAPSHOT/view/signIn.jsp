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
    <title>SignIn</title>
</head>
<body>

    <form action="<%=request.getContextPath()%>/lg/signIn" method="post" enctype="multipart/form-data">
        Username:<input type="text" name="<%=Table_User.COLUMN_USERNAME%>" value="testname"><br>
        Password1:<input type="text" name="<%=Table_User.COLUMN_PASSWORD%>" value="testvalue"><br>
        Gender:<input type="text" name="<%=Table_User.COLUMN_GENDER%>" value="g"><br>
        Birthday:<input type="text" name="<%=Table_User.COLUMN_BIRTHDAY%>" value="847025979758"><br>
        Address:<input type="text" name="<%=Table_User.COLUMN_ADDRESS%>" value="testaddress"><br>
        Career:<input type="text" name="<%=Table_User.COLUMN_CAREER%>" value="testcareer"><br>
        PhoneNumber:<input type="text" name="<%=Table_User.COLUMN_PHONE_NUMBER%>" value="123456789"><br>
        HeadPortrait<input type="file" name="portrait"><br>
        <input type="hidden" name="equip" value="NewThreadAndroid">
        <input type="submit" value="SignIn">
    </form>
</body>
</html>
