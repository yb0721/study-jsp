<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
    <head>
        <title>显示所有会员的结果集（表格）</title>
    </head>

    <body>
        <h2>jstl+EL表达式显示bean数组的结果</h2>
        <table border="1"> 
            <tr>
                <td>学号</td>
                <td>姓名</td>
                <td>密码</td>
                <td>简介</td>
                <td>个人照片位置</td>
                <td>个人照片内容</td>
                <td>操作，修改删除</td>

            </tr>
            <c:forEach var="llb" items="${requestScope.llbs}">
            <tr>
                <td>${llb.uid}</td>
                <td>${llb.uname}</td>
                <td>${llb.upwd}</td>
                <td>${llb.udes}</td>
                <td>${llb.uimg}</td>
                <td><img src = "${llb.uimg}"/></td>
                <td><a href = "deleteservlet?uid=${llb.uid}">删除</a>
                    <a href = "updateservlet?uid=${llb.uid}">修改</a>
                </td>
            </tr>
            </c:forEach>
        </table>
        <hr/>
        <hr/>
        <h2>jstl+jsp:useBean显示bean数组的结果</h2>
        <table border="1"> 
            <tr>
                <td>学号</td>
                <td>姓名</td>
                <td>密码</td>
                <td>简介</td>
            </tr>
            <c:forEach var="llb" items="${requestScope.llbs}">
            <jsp:useBean id="llb" class="org.four.bean.LoginBean"></jsp:useBean>
            <tr>
                <td><jsp:getProperty name="llb" property="uid"></jsp:getProperty></td>
                <td><jsp:getProperty name="llb" property="unaem"></jsp:getProperty></td>
                <td><jsp:getProperty name="llb" property="upwd"></jsp:getProperty></td>
                <td><jsp:getProperty name="llb" property="udes"></jsp:getProperty></td>
            </tr>
            </c:forEach>
        </table>
        <hr/>
        <hr/>
        <h2>jstl+jsp:useBean显示bean数组的结果</h2>
        <table border="1"> 
            <tr>
                <td>学号</td>
                <td>姓名</td>
                <td>密码</td>
                <td>简介</td>
            </tr>
            <c:forEach var="llb" items="${requestScope.llbs}">
            <tr>
                <td><c:out value ="${llb.uid}"></c:out></td>
                <td><c:out value ="${llb.uname}"></c:out></td>
                <td><c:out value ="${llb.upwd}"></c:out></td>
                <td><c:out value ="${llb.udes}"></c:out></td>
            </tr>
            </c:forEach>
        </table>

    </body>
</html>