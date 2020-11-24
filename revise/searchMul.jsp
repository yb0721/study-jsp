<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>

<html>
    <head>
        <title>搜索任意表单</title>
    </head>

    <body>
        <form name = "form1" action = "doSearchMul.jsp" method = "get">
            姓名：<input type = "text" name = "fname"/><br/>
            密码：<input type = "text" name = "fpws"/><br/>
            简介：<input type = "text" name = "fdes"/><br/>
            <input type = "submit" name = "submit" value = "搜一搜"/>
        </form>
    </body>
</html>