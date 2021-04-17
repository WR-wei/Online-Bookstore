<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>课程管理</title>

    <%--    静态包含   --%>
    <%@include file="/pages/common/head.jsp" %>

    <script type="text/javascript">
        $(function () {
            $("a.delete").click(function () {
                /**
                 * confirm是确认提示框函数
                 * 参数是它的提示内容
                 * 它有两个按钮，一个确认，一个是取消。
                 * 返回true表示点击了，确认，返回false表示点击取消。
                 */
                return confirm("你确定要删除【" + $(this).parent().parent().find("td:first").text() + "】这门课吗?");
                // return false// 阻止元素的默认行为===不提交请求
            });
        });
    </script>
</head>
<body>

<div id="header">
    <img class="logo_img" width="350" height="90" alt="" src="static/img/logo.gif">
    <span class="wel_word">课程管理系统</span>

    <%--    静态包含--%>
    <%@include file="/pages/common/select_course_menu.jsp" %>

</div>

<div id="main">
    <table>
        <tr>
            <td>课程名称</td>
            <td>课程学分</td>
            <td>课程老师</td>
            <td>选课人数</td>
            <td>课程容量剩余</td>
            <td colspan="2">操作</td>
        </tr>

        <c:forEach items="${requestScope.page.items}" var="course">
            <tr style="height: 47px">
                <td>${course.courseName}</td>
                <td>${course.courseCredit}</td>
                <td>${course.courseTeacher}</td>
                <td>${course.courseStuNum}</td>
                <td>${course.courseCapacity-course.courseStuNum}</td>
                <td><a href="pages/manager/course_edit.jsp?action=update&courseId=${course.courseId}&courseName=${course.courseName}&courseCredit=${course.courseCredit}&courseTeacher=${course.courseTeacher}&courseStuNum=${course.courseStuNum}&courseCapacity=${course.courseCapacity}&pageNo=${requestScope.page.pageNo}">修改</a></td>
                <td><a class="delete" href="courseServlet?action=delete&value=${course.courseId}&pageNo=${requestScope.page.pageNo}">删除</a></td>
            </tr>
        </c:forEach>

        <c:forEach begin="${requestScope.page.size}" end="3">
            <tr style="height: 47px">
                <td> </td>
                <td> </td>
                <td> </td>
                <td> </td>
                <td> </td>
                <td> </td>
                <td> </td>
            </tr>
        </c:forEach>

        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td><a href="pages/manager/course_edit.jsp?action=add&pageNo=${requestScope.page.pageTotal}&pageTotalCount=${requestScope.page.pageTotalCount}">添加课程</a></td>
        </tr>

    </table>

    <%--静态包含--%>
    <%@include file="/pages/common/page_nav.jsp"%>

</div>

<%@include file="/pages/common/footer.jsp" %>

</body>
</html>