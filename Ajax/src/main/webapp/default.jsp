<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>

<html>
    <head>
        <title>模仿正常网页，局部更新:Ajax+servlet+响应信息是字符串</title>
        <style>
            #header ul li {display: inline-block;
                           list-style: none;
                           width: 160px;
                           text-align: center;}
            #footer {text-align: center;}

            #mid #left {width: 30%;float: left;border: 1px red solid;}
            #mid #right {width: 69%;float: right;border: 1px blue solid;}
        </style>
        <script>
            //自定义的用户名输入框失去焦点时事件触发该函数的调用
            function checkxm() {
                //获取用户输入的用户名作为请求信息传送到后台servlet
                //获取用户输入的用户名，js是用id
                //先获取input id = jxm
                var objInput = document.getElementById("jxm");
                //利用变量jxm获取input对象的值
                var jxm;
                jxm = objInput.value;
                alert("用户名："+jxm);
                if (jxm == null) {
                    alert("用户名不能为空！");
                    //将光标焦点放入该input中
                    objInput.focus();
                    return false;
                }
                else {
                    //异步请求：4步
                    //1.创建异步请求对象XMLHttpRequest
                    //不同浏览器创建方式不同，判断浏览器，一般会利用自定义
                    var xmlHttp = createXMLHttp();
                    //2.封装请求信息，open()+get,请求信息要用？连接
                    var url = "checkLoginServlet?username="+jxm;
                    xmlHttp.open("get",url,true);
                    //3.发送请求send（如果时post，就有请求体【类似于get中的？部分】；否则就写null）
                    xmlHttp.send(null);
                    //4.侦听请求对象的状态变化,调用回调函数【可以是自定义函数或者写匿名函数】
                    //获取回调函数返回的响应结果
                    xmlHttp.onreadystatechange = function() {
                        //侦听异步请求对象的readyState
                        //为4时，响应结束
                        alert("readyState:"+xmlHttp.readyState);
                        if (xmlHttp.readyState == 4) {
                            //侦听异步请求响应的状态status
                             alert("status:"+xmlHttp.status);
                            if(xmlHttp.status == 200) {
                                //获取成功响应结果
                                var data = xmlHttp.responseText;
                                alert(data);
                                //将响应结果放入网页指定id的位置
                                var objSpan = document.getElementById("res");
                                objSpan.innerHTML = data;
                            }
                        }
                    }
                }

            }

            function findLogin() {
                //获取用户输入的用户名作为请求信息传送到后台servlet
                //获取用户输入的用户名，js是用id
                //先获取input id = jxm
                var objInput = document.getElementById("find");
                //利用变量jxm获取input对象的值
                var jfind;
                jfind = objInput.value;
                alert("用户名："+jfind);
                if (jfind == null) {
                    alert("用户名不能为空！");
                    //将光标焦点放入该input中
                    objInput.focus();
                    return false;
                }
                else {
                    //异步请求：4步
                    //1.创建异步请求对象XMLHttpRequest
                    //不同浏览器创建方式不同，判断浏览器，一般会利用自定义
                    var xmlHttp = createXMLHttp();
                    //2.封装请求信息，open()+get,请求信息要用？连接
                    var url = "findLoginServlet?username="+jfind;
                    xmlHttp.open("get",url,true);
                    //3.发送请求send（如果时post，就有请求体【类似于get中的？部分】；否则就写null）
                    xmlHttp.send(null);
                    //4.侦听请求对象的状态变化,调用回调函数【可以是自定义函数或者写匿名函数】
                    //获取回调函数返回的响应结果
                    xmlHttp.onreadystatechange = function() {
                        //侦听异步请求对象的readyState
                        //为4时，响应结束
                        alert("readyState:"+xmlHttp.readyState);
                        if (xmlHttp.readyState == 4) {
                            //侦听异步请求响应的状态status
                             alert("status:"+xmlHttp.status);
                            if(xmlHttp.status == 200) {
                                //获取成功响应结果
                                var data = xmlHttp.responseText;
                                alert(data);
                                //将响应结果放入网页指定id的位置
                                var objSpan = document.getElementById("dlist");
                                //因为响应字符串是数组的串加，现在要分割
                                var strs = new Array();
                                strs=data.split(";");
                                var liststr = "";
                                for (var i = 0;i<strs.length;i++) {
                                    liststr = liststr+"<option value="+strs[i]+">";
                                    //放到datalist里面
                                    objSpan.innerHTML = liststr;
                                }
                               
                            }
                        }
                    }
                }

            }

            //自定义创建XMLHttpRequest对象的函数
            function createXMLHttp() {
                var req;
                if (window.XMLHttpRequest) {
                    //IE7,Firefox,Opera支持
                    req = new XMLHttpRequest();
                }
                else if(window.ActiveXObject) {
                    //IE5,IE6支持
                    req = new ActiveXObject("Microsoft.XMLHTTP");
                }


                return req;
            }
        </script>
    </head>

    <body>
        <div id = "header">
            <ul>
                <li>首页1</li>
                <li>首页2</li>
                <li>首页3</li>
                <li>首页4</li>
                <li>首页5</li>
                <li>首页6</li>
            </ul>
        </div>

        <div id = "sea">
            <form name = "sea" action = "" method = "post">
                <input list = "dlist" type = "text" name = "find" id = "find"/>
                <datalist id = "dlist">
                    <option value = "111">
                    <option value = "222">
                </datalist>
            </form>
            <button onclick = "findLogin()">搜一搜</button>
        </div>

        <div id = "mid">
            <div id = "left">
                资讯1<br/>
                资讯2<br/>
                资讯3<br/>
                资讯4<br/>
            </div>

            <div id = "right">
                <h2>注册/登录</h2>
                <form name = "reg" action = "" method = "post">
                    用户名:<input type = "text" name = "fxm" id = "jxm" onblur = "checkxm()"/><span id = "res"></span><br/>
                    ......
                </form>
            </div>
        </div>

        <div id = "footer">
            <a href = "http://www.baidu.com">百度</a>&nbsp;&nbsp;&nbsp;&nbsp;
            <a href = "http://www.baidu.com">百度</a>&nbsp;&nbsp;&nbsp;&nbsp;
            <a href = "http://www.baidu.com">百度</a>&nbsp;&nbsp;&nbsp;&nbsp;
            <a href = "http://www.baidu.com">百度</a>&nbsp;&nbsp;&nbsp;&nbsp;
        </div>
    </body>
</html>