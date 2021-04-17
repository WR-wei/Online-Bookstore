<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>注册页面</title>

    <%--    静态包含   --%>
    <%@include file="/pages/common/head.jsp" %>

    <style type="text/css">
        .login_form {
            height: 420px;
            margin-top: 25px;
        }
    </style>

    <!-- 检查注册信息是否合法有效-->
    <script>
        $(function () {

            $("#username").blur(function () {
                var username = this.value;

                $.getJSON("http://localhost:8080/course/userServlet" ,
                    "action=ajaxExistUsername&username=" + username,
                    function (date) {
                        if (date.existUsername) {
                            $("span.errorMsg").text("用户名已经存在！");
                        }else {
                            $("span.errorMsg").text("用户名可用！");

                        }
                    });
            });

            $("#sub_btn").click(function () {

                //判断用户名是否规范
                var usernameText = $("#username").val();
                var patt = /^[a-z0-9_-]{4,10}$/;
                if (!usernameText) {
                    $("span.errorMsg").text("用户名不能为空！");
                    return false;
                } else if (!patt.test(usernameText)) {
                    $("span.errorMsg").text("用户名不规范！");
                    return false;
                }

                //判断两次密码输入是否一致
                if (!$("#password").val()) {
                    $("span.errorMsg").text("密码不能为空！");
                    return false;
                } else if (!($("#password").val() == $("#repwd").val())) {
                    // alert("两次密码输入不一致！");
                    $("span.errorMsg").text("两次密码输入不一致！");
                    return false;
                }

                //判断邮箱号是否规范
                var email = $("#email").val();
                patt = /^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/;
                if (!email) {
                    $("span.errorMsg").text("邮箱账号不能为空！");
                    return false;
                } else if (!patt.test(email)) {
                    // alert("邮箱号不正确！");
                    $("span.errorMsg").text("邮箱账号不规范！");
                    return false;
                }

                //判断邮箱是否为空
                var code = $("#code").val();
                if (!code) {
                    $("span.errorMsg").text("验证码不能为空！");
                    return false;
                }
            });
        });
    </script>

</head>
<body>
<div id="login_header">
    <img class="logo_img" width="350" height="90" alt="" src="static/img/logo.gif">
</div>

<div class="login_banner">

    <div id="l_content">
        <span class="login_word">欢迎注册</span>
    </div>

    <div id="content">
        <div class="login_form">
            <div class="login_box">
                <div class="tit">
                    <h1>注册账号</h1>
                    <span class="errorMsg"></span>
                </div>
                <div class="form">
                    <form action="userServlet" method="post">
                        <input type="hidden" name="action" value="regist">
                        <label>用户名称：</label>
                        <input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off"
                               tabindex="1" name="username" id="username"/>
                        <br/>
                        <br/>
                        <label>用户密码：</label>
                        <input class="itxt" type="password" placeholder="请输入密码" autocomplete="off"
                               tabindex="1" name="password" id="password"/>
                        <br/>
                        <br/>
                        <label>确认密码：</label>
                        <input class="itxt" type="password" placeholder="确认密码" autocomplete="off"
                               tabindex="1" name="repwd" id="repwd"/>
                        <br/>
                        <br/>
                        <label>电子邮件：</label>
                        <input class="itxt" type="text" placeholder="请输入邮箱地址" autocomplete="off"
                               tabindex="1" name="email" id="email"
                               value="${empty requestScope.email?"":requestScope.email}"
                        />
                        <br/>
                        <br/>
                        <label>验证码：</label>
                        <input class="itxt" type="text" style="width: 80px;" id="code" name="code"/>
                        <img alt="" src="kaptcha.jsp"
                             style="float: right; margin-right: 40px;width: 130px;height: 36px;">
                        <br/>
                        <br/>
                        <input type="submit" value="注册" id="sub_btn"/>

                    </form>
                </div>

            </div>
        </div>
    </div>
</div>

<%@include file="/pages/common/footer.jsp" %>

</body>
</html>