<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>

<html>
    <head>
        <title> </title>
    </head>

    <body>
        <form name = "form1" action = "AreaServlet" method = "get">
            长：<input type = "text" name = "length" value = "${cb.a}"/><br/>
            宽：<input type = "text" name = "width" value = "${cb.b}"/><br/>
            面积：<input type = "text" name = "area" value = "${cb.c}"/><br/>
            <input type = "submit" name = "submit" value = "计算长方形的面积"/><br/>
        </form>
    </body>
</html>