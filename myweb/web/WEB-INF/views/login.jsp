<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<c:choose>
    <c:when test="${param.code==1001}">
        <div class="alert alert-danger">
            验证码错误！
        </div>
    </c:when>
</c:choose>

<div class="split-pane-divider">
    <form action="/login" method="post">
        <div>
            <label class="label">用户名</label>
            <input class="split-pane" type="text" name="username">
        </div></br>
        <div>
            <lable>密&nbsp;码</lable>
            <input class="split-pane" type="password" name="pwd">
        </div></br>
        <div>
            <label>验证码</label>
            <input type="text" class="split-pane" name="captcha">
        </div>
        <a href="javascript:;" id="changePic"><img id="captcha" src="/captcha.png" alt=""></a>
        <button>登录</button>
    </form>
</div>
<script src="/static/js/jquery-1.12.3.min.js"></script>
<script>
    $(function () {
        $("#changePic").click(function () {
            $("#captcha").attr("src", "/captcha.png?t=" + new Date().getTime());
        })
    })
</script>
</body>
</html>
