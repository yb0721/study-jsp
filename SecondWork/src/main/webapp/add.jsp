<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
    <head>
        <title>添加书籍信息</title>
        <style>
            body {
                background-image: url(img/update.jpg);
                background-repeat: no-repeat;
                background-size: 100% 100%;
            }

            #all {
                width: 260px;
                margin: auto;
                margin-top: 280px;
            }

            .sub {
                text-align: center;
            }

            p {
                font-size: 17px;
            }

        </style>
    </head>

    <body>
        <div id = "all">
            <form name = "updaForm" action = "doaddServlet" method = "get">
                <p>书籍序号：<input type = "text" name = "fid" value = "${bb.id}"/></p>
                <p>书籍名称：<input type = "text" name = "fbookname" value = "${bb.bookname}"/></p>
                <p>书籍作者：<input type = "text" name = "fbookauthor" value = "${bb.bookauthor}"/></p>
                <p>书籍简介：<input type = "text" name = "fbookdes" value = "${bb.bookdes}"/></p>
                <p class = "sub"><input type = "submit" name = "submit" value = "添加图书" style = "width: 140px"/></p>
            </form>
        </div>
    </body>
</html>