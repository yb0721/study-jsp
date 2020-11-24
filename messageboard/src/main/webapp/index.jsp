<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>

<html>
    <head>
        <title>留言(过滤字眼)</title>
    </head>

    <body>
        <h2>请在下方留言</h2>
        <form name = "mes" action = "MessageServlet" method = "post">
           标题：<input type = "text" name = "ftitle" /><br/>
           内容：<textarea name = "fcontent" row = "10"></textarea>
            <input type = "submit" name = "submit" value = "发表留言"/>
        </form>
    </body>
</html>