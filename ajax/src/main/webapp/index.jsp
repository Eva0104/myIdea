<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <title>RegForm</title>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
</head>

<body>

<div class="container">
    <div class="row">
        <div class="col-xs-3">
            <form name="myForm" id="regForm">
                <legend>用户注册表</legend>

                <div class="form-group">
                    <label>用户名</label>
                    <input class="form-control" name="username" id="name">
                </div>

                <div class="form-group">
                    <label>密码</label>
                    <input class="form-control" name="password" id="p">
                </div>

                <div class="form-group">
                    <label>个人简介</label>
                    <input class="form-control" name="other" id="o">
                </div>

                <button type="button" id="btn" class="btn btn-primary">注册</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>

<script src="/static/js/ajax.js"></script>
<script src="/static/js/jquery-1.11.3.min.js"></script>
<script src="/static/js/jquery.validate.js"></script>
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


//        document.querySelector("#username").onchange = function () {
//            Ajax.Get("checkUsername", function (result) {
//                if (result == "yes") {
//                    document.querySelector("#result").innerText = "√";
//                } else {
//                    document.querySelector("#result").innerText = "该用户名已存在";
//                }
//
//            }, {
//                username: myForm.username.value,
//                password: document.querySelector("#password").value,
//                address: myForm.other.value
//            })
//        }

        $("#regForm").validate({
            errorElement: "span",
            errorClass: "text-danger",
            rules: {
                username: {
                    required: true,
                    remote: "/checkUsername"

                },
                password: {
                    required: true
                },

            },
            messages: {
                username: {
                    required: "请输入用户名",
                    remote: "该用户名已被占用"
                },
                password: {
                    required: "请输入密码",
                }
            },
            submitHandler: function (form) {
                var $btn = $("#btn");
                $.getJSON("/reg",$(form).serialize())
                        .done(function(result){
                            if(result == "yes"){
                                $btn.text("注册中......").attr("disabled","disabled");
                                alert("注册成功")
                            }

                        })
                        .fail(function(){
                            alert("服务器繁忙，请稍后重试")
                        })
                        .always(function(){
                            $btn.text("注册").removeAttr("disabled");
                        })
            }
        });

        $("#btn").click(function () {
            $("#regForm").submit();
        })
    })();

</script>
</body>
</html>
