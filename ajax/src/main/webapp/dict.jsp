<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
</head>
<style>
    body {
        font-size: 24px;
        margin-top: 20px;
        background-color: #5cb85c;
    }

</style>
<body>
<div class="container">
    <div>电子词典</div>
    <input type="text" id="word" placeholder="请输入要查询的单词">
    <button id="btn">翻译</button>
    <p id="p"></p>
</div>

<script>
    (function () {
        function createXmlHttp() {
            var xmlHttp = null;
            if (window.ActiveXObject) {
                xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
            } else {
                xmlHttp = new XMLHttpRequest();
            }
            return xmlHttp;
        }

        document.querySelector("#word").onkeyup = function () {
            if (event.keyCode == 13) {
                var xmlHttp = createXmlHttp();
                var word = document.querySelector("#word").value;
                xmlHttp.open("get", "/dict?word=" + encodeURIComponent(word), true);
                xmlHttp.onreadystatechange = function () {
                    if (xmlHttp.readyState == 4) {
                        var status = xmlHttp.status;
                        if (status == 200) {
                            document.querySelector("#p").innerHTML = "";
                            var xmlDoc = xmlHttp.responseXML;

                            var basic = xmlDoc.getElementsByTagName("basic")[0];
                            var explain = basic.getElementsByTagName("explains")[0];
                            var exs = explain.getElementsByTagName("ex");

                            for (var i = 0;i < exs.length;i++) {
                                var ex = exs[i].firstChild.nodeValue;
                                document.querySelector("#p").appendChild(document.createTextNode(ex))
                            }

                        } else {
                            alert("请求异常：" + status);
                        }
                    }
                };
                xmlHttp.send();
            }

        }


    })();

</script>
</body>
</html>
