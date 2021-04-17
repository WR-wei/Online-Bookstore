<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>我的课程</title>

    <%--    静态包含   --%>
    <%@include file="/pages/common/head.jsp"%>

    <style type="text/css">
        h1 {
            text-align: center;
            margin-top: 200px;
        }
    </style>
</head>
<body>
<div id="header">
    <img class="logo_img" width="350" height="90" alt="" src="static/img/logo.gif">
    <span class="wel_word">我的课程</span>

    <%--    静态包含    --%>
    <%@include file="../common/login_success_menu.jsp"%>

</div>

<div id="main">

    <table>
        <tr>
            <td>课程</td>
            <td>教师</td>
            <td>学分</td>
            <td>状态</td>
            <td>详情</td>
        </tr>

        <c:forEach items="${sessionScope.myCourse.items}" var="entry">
        <tr>
            <td>${entry.value.name}</td>
            <td>${entry.value.teacher}</td>
            <td>${entry.value.credit}</td>
            <td>已选上</td>
            <td><a href="https://baike.baidu.com/item/${entry.value.name}" target="_blank">查看课程详情</a></td>
        </tr>
    </c:forEach>

    </table>
</div>

<%@include file="/pages/common/footer.jsp"%>

</body>
</html>