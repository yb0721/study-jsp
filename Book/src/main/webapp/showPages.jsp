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

            <c:forEach var="lbb" items="${requestScope.m.lbbs}">
            <tr>
                <td>${lbb.id}</td>
                <td>${lbb.bookname}</td>
                <td>${lbb.bookauthor}</td>
                <td>${lbb.bookdes}</td>
            </tr>
            </c:forEach>
        </table>

        <div id="p">
            <a href="PageShowServlet?pageCurrent=1">首页</a>
            <c:if test="${requestScope.m.pb.pageCurrent>1}">
            <a href="PageShowServlet?pageCurrent=${requestScope.m.pb.pageCurrent-1 }">上一页</a>
            </c:if>
            <a href="PageShowServlet?pageCurrent=${requestScope.m.pb.pageCurrent}">${requestScope.m.pb.pageCurrent}</a>/${requestScope.m.pb.pages}
            <c:if test="${requestScope.m.pb.pageCurrent<requestScope.m.pb.pages}">
            <a href="PageShowServlet?pageCurrent=${requestScope.m.pb.pageCurrent+1 }">下一页</a>
            </c:if>
            <a href="PageShowServlet?pageCurrent=${requestScope.m.pb.pages }">尾页</a>
        </div>

    </body>
</html>