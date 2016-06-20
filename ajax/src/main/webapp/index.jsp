<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <title>Signin Template for Bootstrap</title>
    <link href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
    <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
</head>

<body>

<div class="container">

    <form class="form-signin col-md-4" name="myForm">
        <h2 class="form-signin-heading">请注册</h2>
        <label for="username" class="sr-only">用户名</label>
        <span id="result" style="color: red"></span>
        <input type="text" id="username" class="form-control" placeholder="请输入用户名" required autofocus>
        <label for="password" class="sr-only">密码</label>
        <input type="password" id="password" class="form-control" placeholder="请输入密码" required>
        <label for="email" class="sr-only">邮箱</label>
        <input type="password" id="email" class="form-control" placeholder="请输入邮箱" required>
        <div class="checkbox">
            <label>
                <input type="checkbox" value="remember-me"> Remember me
            </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">注册</button>
    </form>
</div>
</body>
</html>

<script src="/static/js/ajax.js"></script>
<script>
    (function () {
//        function createXmlHttp(){
//            var xmlHttp = null;
//            if(window.ActiveXObject){
//                xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
//            }else{
//                xmlHttp = new XMLHttpRequest();
//            }
//            return xmlHttp;
//        }
//        document.querySelector("#userName").onblur = function(){
//            var username = this.value;
//            var xmlHttp = createXmlHttp();
//
//            xmlHttp.open("get","/checkUsername?username="+encodeURIComponent(username),true);
//
//            xmlHttp.onreadystatechange = function(){
//
//                var readyState = xmlHttp.readyState;
//                console.log(readyState);
//                if(readyState == 4){
//                    var httpState = xmlHttp.status;
//                    if(httpState == 200){
//                        var result = xmlHttp.responseText;
//                        if(result == "yes"){
//                            document.querySelector("#result").innerText="√";
//                        }else{
//                            document.querySelector("#result").innerText="该用户名已被占用";
//                        }
//                    }else{
//                        alert("服务器请求异常：" + httpState);
//                    }
//                }
//            };
//            xmlHttp.send();
//        }
        document.querySelector("#username").onchange = function () {
            Ajax.Get("checkUsername", function (result) {
                    if (result == "yes") {
                        document.querySelector("#result").innerText = "√";
                    } else {
                        document.querySelector("#result").innerText = "该用户名已存在";
                    }

            }, {username:myForm.username.value, password: document.querySelector("#password").value, address: myForm.email.value})
        }
    })();

</script>
</body>
</html>
