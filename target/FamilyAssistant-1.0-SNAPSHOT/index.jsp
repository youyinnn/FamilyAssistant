<%--
  Created by IntelliJ IDEA.
  User: youyinnn
  Date: 2017/4/3
  Time: 16:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<title>FamilyAssistant</title>
<style>
    div{
        border: 1px solid #9389ff;
        padding:10px;
        width:370px;
        margin: auto auto auto auto;
        text-align: center;
    }
    h4{
        text-align:center;
    }
    input{
        width:180px;
    }
    .login{
        width:310px;
    }
</style>
</head>
<body>
<div>
    <h4>FamilyAssistant Adminstrator Login</h4>
    <hr>
    <br>
    <form action="<%=request.getContextPath()%>/view/list.jsp" method = "post">
        Adminstrator:<input type="text" name="adminstrator"/>
        <br><br>
        Password&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:<input type="password"  name="password"/>
        <br><br>
        <input class="login" type="submit" value="Login">
    </form>
    <br>
    <hr>
</div>
</body>
</html>
