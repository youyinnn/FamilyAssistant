<%@ page import="db.Table_User" %><%--
  Created by IntelliJ IDEA.
  User: youyinnn
  Date: 2017/2/17
  Time: 20:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ChangeUserInformation</title>
</head>
<body>

    <form action="<%=request.getContextPath()%>/us/cgUserInfo" method="post">
        Id:<input type="text" name="<%=Table_User.COLUMN_ID%>" value="50"><br>
        Age:<input type="text" name="<%=Table_User.COLUMN_AGE%>" value="20"><br>
        Gender:<input type="text" name="<%=Table_User.COLUMN_GENDER%>" value="男">
        PhoneNumber:<input type="text" name="<%=Table_User.COLUMN_PHONE_NUMBER%>" value="123456798987"><br>
        Name:<input type="text" name="<%=Table_User.COLUMN_NAME%>" value="testname"><br>
        Career:<input type="text" name="<%=Table_User.COLUMN_CAREER%>" value="testcareer"><br>
        Address:<input type="text" name="<%=Table_User.COLUMN_ADDRESS%>" value="testaddress"><br>
        Birthday:<input type="text" name="<%=Table_User.COLUMN_BIRTHDAY%>" value="847025979758"><br>
        <input type="submit" value="ChangeInfo">
        <input type="hidden" name="equip" value="NewThreadAndroid">
    </form>

</body>
</html>
