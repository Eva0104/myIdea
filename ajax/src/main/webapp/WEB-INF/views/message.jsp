<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Title</title>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
</head>
<style>
    body {
        font-size: 20px;
    }
</style>
<body>
<div class="container">
    <div class="page-header">
        轮询信息
    </div>
    <a href="javaScript:;" id="upload">
        <div class="alert text-info" style="display: none"></div>
    </a>
    <div id="message">
        <c:forEach items="${messageList}" var="msg">
            <div class="panel panel-default">
                <div class="panel panel-heading">
                    作者:${msg.author}
                </div>
                <div class="panel panel-body">
                    信息:${msg.message}
                </div>
            </div>
        </c:forEach>
    </div>
</div>

<script src="/static/js/jquery-1.11.3.min.js"></script>
<script src="/static/js/handlebars-v4.0.5.js"></script>

<script type="xxx" id="msgTemplate">
    <div class="panel panel-default">
            <div class="panel panel-heading">
            作者:{{author}}
    </div>
    <div class="panel panel-body">
            信息:{{msg}}
    </div>
    </div>
</script>
<script>
    $(function () {
        var maxId = ${maxId};
        var newData = null;

        $("#upload").click(function () {
            var $message = $("#message");

            if(newData){
                for(var i = newData.length-1;i >= 0;i--){
                    var msg = newData[i];

                    var template = $("#msgTemplate").html();
                    template = template.replace("{{author}}",msg.author);
                    template = template.replace("{{msg}}",msg.message);

                    $message.prepend(template);
                }
                maxId = newData[0].id;
                newData = null;
                $(".alert").fadeOut();
            }

        });

        setInterval(function () {
            $.post("/message", {"maxId": maxId}, function (data) {
                if (data.length > 0) {
                    newData = data;
                    $(".alert").text("你有" + data.length + "新消息").fadeIn();
                }
            });

        }, 10000)
    })
</script>
</body>
</html>
