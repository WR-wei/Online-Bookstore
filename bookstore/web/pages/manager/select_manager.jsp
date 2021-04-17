<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户信息管理</title>

    <%--    静态包含   --%>
    <%@include file="/pages/common/head.jsp"%>

    <script type="text/javascript">
        $(function () {

            $("a.delete").click(function () {
                var userId = $(this).parent().parent().find("td:first").text();
                var managerId = 1;
                if (userId == managerId){
                    alert("该用户为管理员，无法删除！");
                    return false;
                }else{
                    return confirm("您确认删除用户名为【"+ $(this).parent().parent().find("td:eq(1)").text()+"】的用户吗？");
                }
            })

        });
    </script>

</head>
<body>

<div id="header">
    <img class="logo_img" width="350" height="90" alt="" src="static/img/logo.gif">
    <span class="wel_word">用户信息管理</span>

    <%--    静态包含--%>
    <%@include file="/pages/common/select_course_menu.jsp"%>

</div>

<div id="main">
    <table>

        <tr>
            <td>用户ID</td>
            <td>用户名</td>
            <td>密码</td>
            <td>邮箱</td>
            <td>删除用户信息</td>
        </tr>

        <c:forEach items="${requestScope.usersMsg}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.username}</td>
                <td>${user.password}</td>
                <td>${user.email}</td>
                <td><a class="delete" href="userServlet?action=delete&id=${user.id}">删除用户</a></td>
            </tr>

        </c:forEach>

    </table>
</div>

<%@include file="/pages/common/footer.jsp"%>

</body>
</html>