<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>

<html>
    <head>  
        <title></title>
    </head>
<body>
    <form name = "form1" action = "doRegPre.jsp" method = "get">
    *学号:<input type = "text" name = "fid" required placeholder = "学号必须是整数，范围是1-1000"/><br/>
    *姓名:<input type = "text" name = "fname" required placeholder = "姓名只能10位或5个汉字" maxlength = "10"/><br/>
    *密码:<input type = "text" name = "fpwd" required placeholder = "密码只能10位或5个汉字" maxlength = "10"/><br/>
    简介：<input type = "text" name = "fdes" required placeholder = "个人简介只能50个汉字" maxlength = "50"/><br/>
    <input type = "submit" name ="submit" value = "注册新会员"/>
    </form>
</body>
</html>