<%@ page import="java.util.*" contentType="text/html;charset=utf-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>显示所有书籍信息</title>
    </head>

    <body>
        <table border="1">
            <tr>
                <td>书籍序号</td>
                <td>书籍名称</td>
                <td>书籍作者</td>
                <td>书籍简介</td>
            </tr>

            <c:forEach var="lbb" items="${requestScope.lbbs}">
            <tr>
                <td>${lbb.id}</td>
                <td>${lbb.bookname}</td>
                <td>${lbb.bookauthor}</td>
                <td>${lbb.bookdes}</td>

                <td><a href="deleteServlet?id=${lbb.id}">删除</a>
                    <a href="UpdateServlet?id=${lbb.id}">修改</a>
                </td>

            </tr>
            </c:forEach>
        </table>
    </body>
</html>