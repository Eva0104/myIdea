<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <div class="row">
        <legend class="form-signin-heading">登录页</legend>
        <div class="col-xs-4">
            <form id="form">
                <div class="form-group">
                    <label>用户名</label>
                    <input class="form-control" type="text" name="username">
                </div>
                <div class="form-group">
                    <label>密码</label>
                    <input class="form-control" type="text" name="password">
                </div>
                <button type="button" class="btn btn-primary" id="btn">登录</button>
            </form>
        </div>

    </div>
</div>
<script src="/static/js/jquery-1.11.3.min.js"></script>
<script src="/static/js/jquery.validate.js"></script>
<script>
    $(function () {
        $("#form").validate({
            errorElement: "span",
            errorClass: "text-danger",
            rules: {
                username: {
                    required: true,
                },
                password: {
                    required: true
                }
            },
            messages: {
                username: {
                    required: "请输入用户名"
                },
                password: {
                    required: "请输入密码"
                }
            },
            submitHandler: function (form) {
                $.ajax({
                    url:"/userlog",
                    type:"get",
                    data:$("#form").serialize(),
                    beforeSend:function(){
                        $("#btn").text("登录中......").attr("disabled","disabled");
                    },
                    success:function(){
                        alert("登录成功");
                        location.href="blog";

                    },
                    error:function(){
                        alert("用户名或密码错误");
                    },
                    complete:function(){
                        $("#btn").text("登录").removeAttr("disabled");
                    }

                })
            }
        });
        $("#btn").click(function () {
            $("#form").submit();
        })
    })

</script>

</body>
</html>
