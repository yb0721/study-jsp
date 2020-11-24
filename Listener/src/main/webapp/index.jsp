<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>

<html>
    <head>
        <title>创建application对象的属性和销毁它的属性</title>
    </head>

    <body>
        <%
            //jsp片段
            application.setAttribute("dog1", "小小");
            application.setAttribute("dog2", "大大");
            application.removeAttribute("dog1");
        %>
        <a href = "#">监听request对象请求</a>
    </body>
</html>