<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>

<html>
    <head>
        <title>显示所有会员的结果集（表格）</title>

  </head>
  
  <body>
        <div id="p">
            <a href="allShowPage?pageCurrent=1">首页</a>
            <c:if test="${requestScope.m.pb.pageCurrent>1}">
            <a href="allShowPage?pageCurrent=${requestScope.m.pb.pageCurrent-1 }">上一页</a>
            </c:if>
            <a href="allShowPage?pageCurrent=${requestScope.m.pb.pageCurrent}">${requestScope.m.pb.pageCurrent}</a>/${requestScope.m.pb.pages}
            <c:if test="${requestScope.m.pb.pageCurrent<requestScope.m.pb.pages}">
            <a href="allShowPage?pageCurrent=${requestScope.m.pb.pageCurrent+1 }">下一页</a>
            </c:if>
            <a href="allShowPage?pageCurrent=${requestScope.m.pb.pages }">尾页</a>
        </div>
  </body>
</html>