<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
</head>
<body>
<button id="btn">读取Xml</button>
<div id="userBox">
    <%--<h2>tom <small>100</small></h2>--%>
    <%--<p>usa</p>--%>
</div>
<script src="/static/js/jquery-1.11.3.min.js"></script>
<script>
    $(function () {
        $("#btn").click(function () {
            var $userBox = $("#userBox");
            $.get("/user.xml", function (xml) {
                $(xml).find("user").each(function () {
                    var id = $(this).attr("id");
                    var name = $(this).find("username").text();
                    var address = $(this).find("address").text();
                    console.log(id, name, address);
                    $userBox.append("<h4>"+name+"<small>"+id+"</small></h4><p>"+address+"</p>");
                });
            });
        });




    });
</script>
</body>
</html>
