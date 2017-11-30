<%@ page import="web.PageManager" %>
<%@ page import="model.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: youyinnn
  Date: 2017/5/13
  Time: 22:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        .title{
            margin-top:4px;
            text-align:center;
        }
        div{
            width:800px;
            margin: 10px auto auto auto;
        }
        .butt{
            text-align: center;
        }
        form{
            float:right;
            margin-right:50px;
        }
    </style>
</head>
<body>
<div>
    <br>
    <h2 class="title">用户表</h2>
    <hr>
    <%
        PageManager<User> pageManager = (PageManager<User>) session.getAttribute("pageManager");

        int totalItemPageNumbers = pageManager.getTotalItemPageNumbers();

        int currentPageGroup = pageManager.getCurrentPageGroup();

        int pageGroupSize = pageManager.getPageGroupSize();

        int pageGroupNumber = pageManager.getPageGroupNumber();

        PageManager<User>.Page<User> currentPage = pageManager.getCurrentPage();

        List<User> list = currentPage.getList();

        for (User user : list) {
    %>
    <div align="center">
        <%=user%><br>
    </div>
    <%
        }
    %>
    <hr>
    <div class="butt">
        <%
            if (!pageManager.isLowLimit()){
        %>
        <a href="<%=request.getContextPath()%>/pg/usPg?pageTo=<%=1%>">首页</a>&nbsp;&nbsp;
        <a href="<%=request.getContextPath()%>/pg/usPg?pageTo=<%=currentPage.getPageNo()-1%>">上一页</a>&nbsp;&nbsp;
        <%
        }else {
        %>
        首页&nbsp;&nbsp;上一页
        <%
            }
        %>
        <%
            if ( currentPageGroup != 1){
        %>
        <a href="<%=request.getContextPath()%>/pg/usPg?pageTo=<%=(currentPageGroup-1)*pageGroupSize%>">...</a>
        <%
            }
        %>
        <%
            for (int i = (currentPageGroup-1) * pageGroupSize + 1 ; i <= currentPageGroup * pageGroupSize ; ++i){
                if ( i != currentPage.getPageNo()){
        %>
        <a href="<%=request.getContextPath()%>/pg/usPg?pageTo=<%=i%>">&nbsp;<%=i%>&nbsp;</a>
        <%
        }else {
        %>
        <%=i%>
        <%
                }
            }
        %>
        <%
            if ( currentPageGroup != pageGroupNumber){
        %>
        <a href="<%=request.getContextPath()%>/pg/usPg?pageTo=<%=(currentPageGroup*pageGroupSize)+1%>">...</a>
        <%
            }
        %>
        <%
            if (!pageManager.isHighLimit()){
        %>
        <a href="<%=request.getContextPath()%>/pg/usPg?pageTo=<%=currentPage.getPageNo()+1%>">下一页</a>&nbsp;&nbsp;
        <a href="<%=request.getContextPath()%>/pg/usPg?pageTo=<%=totalItemPageNumbers%>">尾页</a>
        <%
        }else {
        %>
        下一页&nbsp;&nbsp;尾页
        <%
            }
        %>
    </div>

    <div class="title">
        总共<%=totalItemPageNumbers%>页&nbsp;&nbsp;当前在第<%=currentPage.getPageNo()%>页&nbsp;&nbsp;第<%=pageManager.getCurrentPageGroup()%>页组
        <a href="<%=request.getContextPath()%>/view/list.jsp">返回</a>
    </div>
</div>
</body>
</html>
