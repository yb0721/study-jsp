<%@ page import="java.util.*" contentType="text/html;charset=utf-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>显示所有书籍信息</title>
        <style>
            #all {
                font-family: Roboto, "Helvetica Neue", sans-serif;
            }

            table {
                margin: auto;
                text-align: center;
            }

            td {
                border-bottom: 1px solid gray;
                width: 500px;
                padding-bottom: 10px;
            }

            a {
                color: black;
                text-decoration: none;
                margin: auto;
                font-family: Roboto, "Helvetica Neue", sans-serif;
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
                    <td>书籍序号</td>
                    <td>书籍名称</td>
                    <td>书籍作者</td>
                    <td>书籍简介</td>
                    <td>操作</td>
                </tr>
    
                <c:forEach var="lbb" items="${requestScope.lbbs}">
                <tr>
                    <td>${lbb.id}</td>
                    <td>${lbb.bookname}</td>
                    <td>${lbb.bookauthor}</td>
                    <td>${lbb.bookdes}</td>
    
                    <td>
                        <a href="UpdateServlet?id=${lbb.id}">修改</a>
                        <a href="deleteServlet?id=${lbb.id}">删除</a>
                    </td>
    
                </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>