<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
    <head>
        <title>显示某个会员的注册信息并接收修改记录</title>
    </head>

    <body>
        <form name = "updaForm" action = "doUpdateServlet" method = "post">
        学号：<input type = "text" name = "fid" value = "${lb.uid}" readonly/><br/>
        姓名：<input type = "text" name = "fname" value = "${lb.uname}"/><br/>
        密码：<input type = "text" name = "fpwd" value = "${lb.upwd}"/><br/>
        简介：<input type = "text" name = "fdes" value = "${lb.udes}"/><br/>
        <input type = "submit" name = "submit" value = "修改会员信息"/>
        </form>
    </body>
</html>