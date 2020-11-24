<%@ page import="java.util.*" contentType="text/html;charset=utf-8" pageEncoding="UTF-8"%>

<html>
    <head>
        <title>管理员登录</title>
        <style>
            body {
                background-image: url(img/Login.jpg);
                background-repeat: no-repeat;
                background-size: 100% 100%;
            }

            img {
                width: 50px;
                height: 50px;
                padding-bottom: 20px;
                padding-left: 25px;
            }

            #all {
                text-align: center;
                margin-top: 15%;
                padding-top: 10px;
            }
            
            .con1 {
                margin-top: -8px;
            }

            .sub {
                margin-top: -5px;
            }

        </style>
    </head>
    <script language = "JavaScript" type = "text/JavaScript">
        function check(form) {
            var fname = form.fname.value;
            if(fname.length == 0){
                alert("用户名不能为空！");
                form.fname.focus();
                return false;
            }
            var fpwd = form.fpwd.value;
            if(fpwd.length == 0) {
                alert("密码不能为空！");
                form.fpwd.focus();
                return false;
            }
        }
    </script>

    <body>
        <div id = "all">
            <img src = "img/Ad.png"/>
            <form name="form1" action="loginServlet" method="post" onSubmit = "return check(this)">
                <p class = "con">账号：<input type="text" name="fname"/></p>
                <p class = "con1">密码：<input type="password" name="fpwd"/></p>
                <p class = "sub"><input type="submit" name="submit" value="登录" style = "width: 80px"/></p>
            </form>
        </div>
    </body>
</html>