<%@ page import="java.util.*" contentType="text/html;charset=utf-8" pageEncoding="UTF-8"%>

<html>
    <head>
        <title>首页</title>
    </head>

    <body>
        <form name="reg" action="doRegServlet" method="post" enctype = "multipart/form-data">
            学号：<input type="text" name="fid"/><br/>
            姓名：<input type="text" name="fname"/><br/>
            密码：<input type="text" name="fpwd"/><br/>
            简介：<input type="text" name="fdes"/><br/>
            个人照片：<input type="file" name="fimg" /><br/>
            <input type="submit" name="submit" value="注册会员"/><br/>
            <input type = "button" />
        </form>

        <div>
            学号：${gb.uid}<br/>
            姓名：${gb.uname}<br/>
            密码：${gb.upwd}<br/>
            简介：${gb.udes}<br/>
            个人照片：${gb.uimg}<br/>
            个人照片：<img src="{$lb.uimg}"/><br/>
            <input type="submit" name="submit" value="注册会员"/><br/>
            <input type = "button" name = "yes" value ="确认注册信息，再次提交" onclick="re()"/>
        </div>
    </body>
</html>
<script>
    function re() {
        window.location.href = "insertServlet?lb="+${request.gb};
    }
</script>