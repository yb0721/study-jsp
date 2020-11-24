<%@ page import="java.util.*" contentType="text/html;charset=utf-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>显示所有用户</title>
        <style>
            body {
                background-image: url(img/Sms.jpg);
                background-repeat: no-repeat;
                background-size: 100% 100%;
                
            }

            #all {
                width: 330px;
                margin-top: 100px;
                margin-left: 100px;
            }

            tr td {
                text-align: center;
                padding-bottom: 10px;
                font-size: 20px;
                padding-right: 20px;

            }

            a {
                color: black;
                text-decoration: none;
            }

            a:hover {
                color: gray;
            }
        </style>
    </head>

    <body>
        <div id = "all">
            <table>
                <tr>
                    <td>用户账号</td>
                    <td>用户密码</td>
                    <td>操作</td>
                </tr>

                <c:forEach var="lbb" items="${requestScope.lbbs}">
                <tr>
                    <td>${lbb.name}</td>
                    <td>${lbb.pwd}</td>
                    
                    <td>
                        <a href="SMSUpdate?name=${lbb.name}">修改</a>
                        <a href="SMSDelete?name=${lbb.name}">删除</a>
                    </td>
                </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>