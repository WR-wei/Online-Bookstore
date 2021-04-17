<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>选课首页</title>

    <%--静态包含页首信息--%>
    <%@ include file="/pages/common/head.jsp" %>

    <script type="text/javascript">
        $(function () {
            if (${not empty sessionScope.user}) {

                $("button.addToCart").click(function () {
                    var courseId = $(this).attr("courseId");
                    location.href = "${basePath}cartServlet?action=addCart&id=" + courseId;
                });

            } else {

                $("button.addToCart").click(function () {
                    alert("您还未登陆，请您登陆后再试！");
                    location.href = "${basePath}index.jsp" ;
                });

            }

            // 判断用户是否为管理员
            $("a.managerClass").click(function () {
                if (${sessionScope.user.username != "wurui"}){
                    alert("您还不是管理员！")
                    return false;
                }
            });

        });

    </script>

</head>

<body>
<div id="header">
    <img class="logo_img" width="350" height="90" alt="" src="static/img/logo.gif">
    <span class="wel_word">选课系统</span>
    <div>

        <c:if test="${empty sessionScope.user}">
            <a href="pages/user/login.jsp">登录</a> |
            <a href="pages/user/regist.jsp">注册</a>
        </c:if>

        <c:if test="${not empty sessionScope.user}">
            <span>欢迎用户：<span class="um_span">${sessionScope.user.username}</span> 光临！</span>
            <a href="pages/cart/cart.jsp">选课列表</a>&nbsp;
            <a href="pages/manager/manager.jsp" class="managerClass">后台管理</a>
            <a href="userServlet?action=logout">注销</a>&nbsp;
        </c:if>

    </div>

</div>

<div id="main">
    <div id="book">

        <%-- 按学分搜索课程--%>
        <div class="book_cond">
            <form action="clientServlet" method="get">
                <input type="hidden" name="action" value="pageByCredit">
                学分范围查找：<input id="min" type="text" name="min" value="${param.min}"> -
                <input id="max" type="text" name="max" value="${param.max}">
                <input type="submit" value="查询"/>
            </form>
        </div>

        <c:if test="${not empty sessionScope.cart.items}">
            <%-- 显示操作信息--%>
            <div style="text-align: center">
                <span>您的选课列表中有${sessionScope.cart.totalCount}门课程</span>
                <c:if test="${empty sessionScope.alreadyAdd}">
                    <div>
                        您刚刚将<span style="color: red">${sessionScope.lastCourse}</span>加入到了选课列表中
                    </div>
                </c:if>

                <c:if test="${not empty sessionScope.alreadyAdd}">
                    <div>
                        <span style="color: red">您已经将${sessionScope.alreadyAdd}加入到了选课列表中!!!</span>
                    </div>
                </c:if>

            </div>

        </c:if>

        <c:if test="${empty sessionScope.cart.items}">
            <%-- 显示操作信息--%>
            <div style="text-align: center">
                <span>您的选课列表中没有课程</span>
                <div>
                    <span style="color: red">赶快添加课程吧！</span>
                </div>
            </div>

        </c:if>


        <c:forEach items="${requestScope.page.items}" var="course">
            <div class="b_list">
                <div class="img_div">
                    <img class="book_img" alt="" src="static/img/default.jpg"/>
                </div>
                <div class="book_info">
                    <div class="book_name">
                        <span class="sp1">课程名:</span>
                        <span class="sp2">${course.courseName}</span>
                    </div>
                    <div class="book_author">
                        <span class="sp1">教师:</span>
                        <span class="sp2">${course.courseTeacher}</span>
                    </div>
                    <div class="book_price">
                        <span class="sp1">学分:</span>
                        <span class="sp2">${course.courseCredit}</span>
                    </div>
                    <div class="book_sales">
                        <span class="sp1">选课人数:</span>
                        <span class="sp2">${course.courseStuNum}</span>
                    </div>
                    <div class="book_amount">
                        <span class="sp1">课程容量剩余:</span>
                        <span class="sp2">${course.courseCapacity-course.courseStuNum}</span>
                    </div>
                    <div class="book_add">
                        <button courseId="${course.courseId}" class="addToCart">加入选课列表</button>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>

    <%-- 静态包含分页信息--%>
    <%@include file="/pages/common/page_nav.jsp" %>

</div>

<%--静态包含页脚信息--%>
<%@include file="/pages/common/footer.jsp" %>

</body>
</html>