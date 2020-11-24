<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>

<html>
    <head>
        <title>异步请求：在数据表中模糊查询，得到多行结果的JavaBean，转化为json对象字符串回送</title>
        <script type = "text/javascript">
            function  findName() {
                //1.创建异步请求对象，调用创建函数
                var xmlHttp = createXmlHttpRequest();
                //2.封装和请求有关的内容，并打开
                //如果open用的是get，则url包括网址和？传送信息
                //为了获取id="jxm"对象的值
                var objInput = document.getElementById("jxm");
                //获取input的值
                var jxm = objInput.value;
                var url = "findNames?username="+jxm;
                xmlHttp.open("get", url, true);
                //3.发送，如果是post，请求体写在（）里面，如果是get
                xmlHttp.send(null);
                //4.利用异步对象不断侦听服务器的响应状态，响应结果状态
                xmlHttp.onreadystatechange=function() {
                    //侦听服务器状态
                    alert(xmlHttp.readyState);
                    if(xmlHttp.readyState == 4) {
                        //侦听服务器响应结果状态
                        alert(xmlHttp.status);
                        if(xmlHttp.status == 200) {
                            //响应结果正常，有效，js接收
                            var data = xmlHttp.responseText;
                            alert(data);
                            //将json对象字符串还原成json对象
                            var json = JSON.parse(data);
                            //解析json对象的数据
                            var tt = "<table>"
                            for(var i=0;i<json.size;i++) {
                                tt = tt+"<tr><td>"+json[i].uid+"</td></tr>"+json[i].uname+"</td></tr>";
                            }
                            tt = tt+"</table>";
                            //将tt表格放入div="t"
                            var 
                        }
                    }
                }
            }
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
        <div id = "sea">
            <input id = "jxm" type = "text"/><br/>

            <div id = "t">
            </div>

            <button onclick = "findName()">异步请求查找相近的用户名</button>
        </div>
    </body>
</html>