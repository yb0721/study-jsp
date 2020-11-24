<%@ page import="java.util.*" contentType="text/html;charset=utf-8" pageEncoding="UTF-8"%>

<html>
    <head>
        <title>首页</title>
        <audio src="vid/music.mp3" autoplay="autoplay"></audio>
        <style>
            body {
                background-image: url(img/default.jpg);
                background-repeat: no-repeat;
                background-size:100% 100%;
            }

            .index {
                color: #500050;
                font-size: 24px;
                font-family: Roboto, "Helvetica Neue", sans-serif;
                text-align: center;
                padding-top: 20px;
            }

            .con {
                width: 300px;
                height: 30px;
                background-color: white;
                border-radius: 0px 10px 10px 0px;
                border-radius: 500em/500em;
                text-align: center;
                margin: auto;
                margin-bottom: 10px;
                font-size: 17px;
            }

            .con1 {
                width: 200px;
                height: 30px;
                background-color: white;
                border-radius: 0px 10px 10px 0px;
                border-radius: 500em/500em;
                text-align: center;
                margin: auto;
                margin-bottom: 20px;
                font-size: 16px;
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

            #all {
                margin-top: 100px;
            }
        </style>
    </head>

    <body>
        <p class = "index">无止境斋</p>
            <div id = "all">
                <p class = "con"><a href = "Login.jsp">管理员登录</a></p>
                <p class = "con"><a href = "netizensLogin.jsp">用户登录</a></p>
                <p class = "con1"><a href = "reg.jsp">注册新用户</a></p>
            </div>   
    </body>
</html>