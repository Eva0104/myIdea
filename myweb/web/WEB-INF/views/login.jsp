<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
</head>
<body>
<c:choose>
    <c:when test="${param.code==1001}">
        <div class="alert alert-danger">
            验证码错误！
        </div>
    </c:when>
    <c:when test="${param.code==1002}">
        <div class="alert alert-danger">
            用户名或密码错误！
        </div>
    </c:when>
</c:choose>

<div class="split-pane-divider" style="margin-top: 20px">
    <form action="/login" method="post">
        <div>
            <label>用户名</label>
            <input class="split-pane" type="text" name="username">
        </div>
        <div style="margin-top: 10px">
            <lable>密&nbsp;&nbsp;&nbsp;&nbsp;码</lable>
            <input class="split-pane" type="password" name="pwd">
        </div>
        <div style="margin-top: 10px">
            <label>验证码</label>
            <input type="text" class="split-pane" name="captcha">
        </div>
        <a href="javascript:;" id="changePic"><img id="captcha" src="/captcha.png" alt=""></a>
        <button>登录</button>
    </form>
</div>
<script src="/static/js/jquery-1.11.3.min.js"></script>
<script>
    $(function () {
        $("#changePic").click(function () {
            $("#captcha").attr("src", "/captcha.png?t=" + new Date().getTime());
        })
    })
</script>
</body>
</html>
