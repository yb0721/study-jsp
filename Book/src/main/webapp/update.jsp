<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
    <head>
        <title>显示某个会员的注册信息并接收修改记录</title>
    </head>

    <body>
        <form name = "updaForm" action = "doUpdateServlet" method = "get">
        书籍序号：<input type = "text" name = "fid" value = "${bb.id}" readonly/><br/>
        书籍名称：<input type = "text" name = "fbookname" value = "${bb.bookname}"/><br/>
        书籍作者：<input type = "text" name = "fbookauthor" value = "${bb.bookauthor}"/><br/>
        书籍简介：<input type = "text" name = "fbookdes" value = "${bb.bookdes}"/><br/>
        <input type = "submit" name = "submit" value = "修改会员信息"/>
        </form>
    </body>
</html>