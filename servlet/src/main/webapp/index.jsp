<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ page import="java.sql.*" %>

<html>
    <head>
        <title>登录界面</title>
    </head>

    <body>
        <form name = "form1" action = "login" method = "get">
            账号：<input type = "text" name = "fuser" value = "${user}"/><br/>
            密码：<input type = "text" name = "fpwd" value = "${upwd}"/><br/>
            验证码：<input type = "text" name = "fcode" value = "${ucode}"/><br/>
            <input type = "submit" name = "submit" value = "登录" /><br/>
            报错信息：<input type = "text" name = "fmes" value = "${umes}"/><br/>
        </form>  
    </body>
</html>