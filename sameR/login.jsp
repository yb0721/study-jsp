<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>

<html>
    <head>  
        <title>登录表单</title>
    </head>
<body>
    <form name = "form1" action = "dologinPre.jsp" method = "get">
    学号：<input type = "text" name = "fid"/><br/>
    密码：<input type = "text" name = "fpwd"/><br/>
    <input type = "submit" name = "submit" value = "登录"/><br/>
    </form>
</body>
</html>