<%@ page import="java.util.*" contentType="text/html;charset=utf-8" pageEncoding="UTF-8"%>

<html>
    <head>
        <title>登录</title>
    </head>

    <body>
        <form name="form1" action="login" method="post">
            账号：<input type="text" name="fid"  value="${user}"/><br/>
            密码：<input type="password" name="fpwd"  value="${upwd}"/><br/>
            <input type="submit" name="submit" value="登录"/><br/>
        </form>
    </body>
</html>