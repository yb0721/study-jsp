<%@ page import="java.util.*" contentType="text/html;charset=utf-8" pageEncoding="UTF-8"%>

<html>
    <head>
        <title>首页</title>
    </head>

    <body>
        <ul>
            <li><a href="BooksServlet">书籍表</a></li>
            <li><a href="PageShowServlet">分页显示书籍信息</a></li>
        </ul>

        <form name="search" action="findServlet" method="post">
            书籍名称：<input type="text" name="fname"/> <br/>
            <input type="submit" name="submit" value="查一查"/>
        </form>
    </body>
</html>