<%--
  Created by IntelliJ IDEA.
  User: 吴瑞
  Date: 2020/11/24
  Time: 20:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div>
    <span>欢迎用户：<span class="um_span">${sessionScope.user.username}</span>光临！</span>
    <a href="submitServlet?action=showCourse">我的课程</a>
    <a href="userServlet?action=logout">注销</a>&nbsp;&nbsp;
    <a href="index.jsp">返回</a>
</div>
