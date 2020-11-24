<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>

<html>
    <head>
        <title>体重测试</title>
    </head>

    <body>
        <form name = "form1" action = "body" method = "get">
            身高：<input type = "text" name = "fheight" value = "${bd.h}"/>cm<br/>
            体重：<input type = "text" name = "fweight" value = "${bd.w}"/>公斤<br/>
            性别：<input type = "radio" name = "fsex1" value = "${bd.man}"/> 男
                  <input type = "radio" name = "fsex2" value = "${bd.woman}"/> 女 <br/>
            信息：<input type = "text" name = "fmes" value = "${bd.mess}"/><br/>
            <input type = "submit" name = "submit" value = "查询"/>
        </form>
    </body>
</html>