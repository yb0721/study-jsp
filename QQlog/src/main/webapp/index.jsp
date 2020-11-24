<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>

<html>
    <head>
        <title>发布说说表单(过滤违规字眼)</title>
    </head>

    <body>
        <form name = "qq" action = "LogServlet" method = "post">
           标题：<input type = "text" name = "ftitle" /><br/>
           内容：<textarea name = "fcontent" row = "10"></textarea>
            <input type = "submit" name = "submit" value = "说说"/>
        </form>
    </body>
</html>