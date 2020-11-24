<%@ page import="java.util.*" contentType="text/html;charset=utf-8" pageEncoding="UTF-8"%>

<html>
    <head>
        <title>首页</title>
        <style>
            body {
                background-image: url(img/book.jpg);
                background-repeat: no-repeat;
                background-size: 100% 100%;
            }

            #all {
                margin-top: 50px;
                margin-left: 25px;
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

            ul {
                margin-bottom: 20px;
                margin-left: -40px;
            }

            ul li {
                list-style-type: none;
            }
        </style>
    </head>

    <body>
        <div id = "all">
            <ul>
                <li><a href="PageShowServlet">书籍表</a></li>
            </ul>
    
            <form name="search" action="NfindServlet" method="get">
                书籍名称：<input type="text" name="fname"/>
                <input type="submit" name="submit" value="查一查"/>
            </form>
        </div>
    </body>
</html>