<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
    <head>
        <title>用户信息的修改</title>
        <style>
            body {
                background-image: url(img/Sms.jpg);
                background-repeat: no-repeat;
                background-size: 100% 100%;
            }
            
            #all {
                width: 330px;
                font-size: 17px;
                margin-top: 100px;
                margin-left: 150px;
            }

            .sub {
                text-align: center;
                width: 220px;
                padding-top: 5px;
            }
        </style>
    </head>

    <body>
        <div id = "all">
            <form name = "updaForm" action = "doUpdate" method = "get">
                <p>用户名：<input type = "text" name = "fname" value = "${bb.name}"/></p>
                <p>密码：&nbsp;&nbsp;&nbsp;<input type = "password" name = "fpwd" value = "${bb.pwd}"/></p>
            <p class = "sub"><input type = "submit" name = "submit" value = "修改会员信息"/></p>
        </form>
        </div>
    </body>
</html>