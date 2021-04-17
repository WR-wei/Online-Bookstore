<%--
  Created by IntelliJ IDEA.
  User: 吴瑞
  Date: 2020/11/27
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%-- 分页码的开始 --%>
<div id="page_nav">

    <%-- 分页码的开始 --%>
    <div id="page_nav">

        <%--如果是第一页则不显示首页和上一页  --%>
        <c:if test="${requestScope.page.pageNo > 1}">
            <a href="${requestScope.page.url}">首页</a>
            <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo-1}">上一页</a>
        </c:if>

        【${requestScope.page.pageNo}】

        <%--  如果是最后一页则不显示下一页和末页  --%>
        <c:if test="${requestScope.page.pageNo < requestScope.page.pageTotal}">
            <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo+1}">下一页</a>
            <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageTotal}">末页</a>
        </c:if>

        共 ${requestScope.page.pageTotal} 页，总计 ${requestScope.page.pageTotalCount} 条记录
        到第<input value="${requestScope.page.pageNo}" name="pn" id="pn_input"/>页
        <input id="turnTo" type="button" value="跳转">

        <script type="text/javascript">
            $(function () {
                $("#turnTo").click(function () {

                    var pageNo = $("#pn_input").val();

                    location.href = "${basePath}${requestScope.page.url}&pageNo=" + pageNo;
                });
            });
        </script>

    </div>
</div>
