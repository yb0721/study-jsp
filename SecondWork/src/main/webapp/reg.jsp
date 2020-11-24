<%@ page import="java.util.*" contentType="text/html;charset=utf-8" pageEncoding="UTF-8"%>

<html>
    <head>
        <title>注册新用户</title>
        <style>
            body {
                background-image: url(img/reg.jpg);
                background-repeat: no-repeat;
                background-size: 100% 100%;
            }

            #all {
                width: 220px;
                margin: auto;
                margin-top: 190px;
                font-size: 17px;
                padding-left: 80px;
            }

            .sub {
                text-align: center;
            }

            img {
                width: 50px;
                height: 50px;
                padding-bottom: 10px;
                padding-left: 25px;
                margin-left: 75px;
            }

            .pic {
                margin-top: 10px;
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
            <p class = "pic"><img src = "img/reg.png"/></p>
            <form name="reg" action="regServlet" method="get" onSubmit = "return check(this)">
                <p>账号：<input type="text" name="fname"/></p>
                <p>密码：<input type="password" name="fpwd"/></p>
                <p class = "sub"><input type="submit" name="submit" value="注册用户"/></p>
            </form>
        </div>
    </body>
</html>