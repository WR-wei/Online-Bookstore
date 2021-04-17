<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>选课页面</title>

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
    <span class="wel_word">选课结果</span>

    <%--    静态包含    --%>
    <%@include file="../common/login_success_menu.jsp"%>

</div>

<div id="main">

    <h1>选课成功！<a href="submitServlet?action=showCourse">点击我的课程查看选课结果</a></h1>


</div>

<%@include file="/pages/common/footer.jsp"%>

</body>
</html>