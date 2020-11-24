<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>

<html>
    <head>
        <title>首页</title>
    </head>

    <body>
        <ul>
            <li><a href="showVIPServlet"></a>会员表</li>
            <li>商品表</li>
            <li>分类表</li>
            <li>购物车</li>
            <li>订单</li>
            <li><a href = "allShowPage">分页显示会员表</a></li>
        </ul>
        <form name="cz" action ="findServlet" ,method="post">
        </form>
    </body>
</html>