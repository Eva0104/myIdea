<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
    <style>
        body {
            margin-left: 20px;
            margin-top: 20px;
        }

    </style>
</head>
<body>
<button id="btn">读取Xml</button>
<div id="userBox">
    <%--<h2>tom <small>100</small></h2>--%>
    <%--<p>usa</p>--%>
</div>

<hr>
<button id="postBtn">post提交</button>

<hr>
<input id="name">
<span id="result"></span>

<hr>
<button id="jsonBtn">读取JSON</button>
<ul id="list">

</ul>

<script src="/static/js/jquery-1.11.3.min.js"></script>
<script>
    $(function () {
        $("#btn").click(function () {
            var $userBox = $("#userBox");
            $userBox.html("");
            $.get("/user.xml", function (xml) {
                $(xml).find("user").each(function () {
                    var id = $(this).attr("id");
                    var name = $(this).find("username").text();
                    var address = $(this).find("address").text();
                    console.log(id, name, address);
                    $userBox.append("<h4>" + name + "<small>" + id + "</small></h4><p>" + address + "</p>");
                });
            });
        });

        $("#name").change(function () {
            var name = $(this).val();
            $.get("/checkUsername", {"username": name}, function (result) {
                if (result == "yes") {
                    $("#result").text("√");
                } else {
                    $("#result").text("该用户名已存在");
                }
            })
        });

        $("#postBtn").click(function () {
            $.post("/ajax", {"name": "eric"});
        });

        $("#jsonBtn").click(function () {
            var $ul = $("#list");
            $ul.html("");
            $.get("/user.json", function (json) {
                for (var i = 0; i < json.length; i++) {
                    var user = json[i];

                    var name = user.name;
                    var address = user.address;
                    var password = user.password;

                   $ul.append("<li>" + name + address + password + "</li>");
                }
            });
        });

    });
</script>
</body>
</html>
