<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>编辑课程信息</title>

    <%--    静态包含   --%>
    <%@include file="/pages/common/head.jsp"%>

    <style type="text/css">
        h1 {
            text-align: center;
            margin-top: 200px;
        }

        h1 a {
            color:red;
        }

        input {
            text-align: center;
        }
    </style>
</head>
<body>
<div id="header">
    <img class="logo_img" width="350" height="90" alt="" src="static/img/logo.gif">
    <span class="wel_word">编辑课程信息</span>

    <%--    静态包含--%>
    <%@include file="/pages/common/select_course_menu.jsp"%>

</div>

<div id="main">
    <form action="courseServlet" method="post">

        <input type="hidden" name="courseId" value="${param.courseId}">

        <input type="hidden" name="action" value="${param.action}">

        <input type="hidden" name="pageNo" value="${param.pageNo}">

        <input type="hidden" name="pageTotalCount" value="${param.pageTotalCount}">

        <table>

            <tr>
                <td>课程名称</td>
                <td>课程学分</td>
                <td>课程老师</td>
                <td>选课人数</td>
                <td>课程容量</td>
                <td colspan="2">操作</td>
            </tr>

            <tr>
                <td><input name="courseName"     type="text" value="${param.courseName}"/></td>
                <td><input name="courseCredit"   type="text" value="${param.courseCredit}"/></td>
                <td><input name="courseTeacher"  type="text" value="${param.courseTeacher}"/></td>
                <td><input name="courseStuNum"   type="text" value="${param.courseStuNum}"/></td>
                <td><input name="courseCapacity" type="text" value="${param.courseCapacity}"/></td>
                <td><input type="submit" value="提交"/></td>

        </table>
    </form>
</div>

<%@include file="/pages/common/footer.jsp"%>

</body>
</html>