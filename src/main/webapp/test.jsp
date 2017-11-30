<%@ page import="java.util.Enumeration" %><%--
  Created by IntelliJ IDEA.
  User: youyinnn
  Date: 2017/5/21
  Time: 16:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <%

        response.setHeader("Access-Control-Allow-Origin","*");

        String a = request.getParameter("a");
        String b = request.getParameter("b");

        String id = session.getId();

        if (a.equals("asd") && b.equals("123")){
            response.getWriter().println("{\"msg\":\"success\",\"userId\":\"asd123\",\"sessionId\":\""+id+"\"}");
            response.addCookie(new Cookie("userId",a+b));
        }

    %>

</body>
</html>
