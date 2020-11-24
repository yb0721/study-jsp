<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
    <head>
        <title>显示所有书籍信息(表格形式)</title>
    </head>

    <body>
        <table border="1"> 
            <tr>
                <td>序号</td>
                <td>书籍名</td>
                <td>简介</td>
            </tr>
            <c:forEach var="llb" items="${requestScope.book}">
            <tr>
                <td>${llbs.id}</td>
                <td>${llbs.Bname}</td>
                <td>${llbs.Bdes}</td>
            </tr>
            </c:forEach>
        </table>
    </body>
</html>