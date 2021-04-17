<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>课程列表</title>

    <%--    静态包含   --%>
    <%@include file="/pages/common/head.jsp" %>

    <script type="text/javascript">
        $(function () {
            $("a.deleteClass").click(function () {
                return confirm("你确定要将【"+ $(this).parent().parent().find("td:first").text() +"】移除选课列表吗？");
            });

            $("a.clearClass").click(function () {
                return confirm("你确定要将选课列表清空吗？");
            });

        });

    </script>

</head>
<body>

<div id="header">
    <img class="logo_img" width="350" height="90" alt="" src="static/img/logo.gif">
    <span class="wel_word">课程列表</span>

    <%--    静态包含    --%>
    <%@include file="../common/login_success_menu.jsp" %>

</div>

<div id="main">

    <table>

        <tr>
            <td>课程名称</td>
            <td>课程教师</td>
            <td>课程学分</td>
            <td>选课人数</td>
            <td>操作</td>
        </tr>

        <c:if test="${empty sessionScope.cart.items}">
            <tr>
                <td colspan="5"><a href="index.jsp">当前选课系统为空！前往首页进行选课吧！</a></td>
            </tr>
        </c:if>


        <c:forEach items="${sessionScope.cart.items}" var="entry">

            <tr>
                <td>${entry.value.name}</td>
                <td>${entry.value.teacher}</td>
                <td>${entry.value.credit}</td>
                <td>${entry.value.totalNum}</td>
                <td><a class="deleteClass" href="cartServlet?action=delete&id=${entry.value.id}">删除</a></td>
            </tr>

        </c:forEach>

    </table>

    <c:if test="${not empty sessionScope.cart.items}">
        <div class="cart_info">
            <span class="cart_span">课程列表中共有<span class="b_count">${sessionScope.cart.totalCount}</span>门课程</span>
            <span class="cart_span">总学分<span class="b_price">${sessionScope.cart.totalCredit}</span>分</span>
            <span class="cart_span"><a class="clearClass" href="cartServlet?action=clear">清空课程列表</a></span>
            <span class="cart_span"><a href="submitServlet?action=submit">确认选课</a></span>
        </div>
    </c:if>



</div>

<%@include file="/pages/common/footer.jsp" %>

</body>
</html>