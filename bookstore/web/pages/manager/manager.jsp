<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>后台管理</title>

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
    <span class="wel_word">后台管理系统</span>

    <%--    静态包含--%>
    <%@include file="/pages/common/select_course_menu.jsp"%>

</div>

<div id="main">
    <h1>欢迎管理员进入后台管理系统</h1>
</div>

<%@include file="/pages/common/footer.jsp"%>

</body>
</html>