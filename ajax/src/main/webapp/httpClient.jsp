<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
</head>
<body>
<div class="container">

    <button id="btn">访问hao123</button>
    <ul class="list-unstyled" id="ul">

    </ul>
</div>

<script>
    (function () {
        function createUl(title, link) {
            var li = document.createElement("li");
            var a = document.createElement("a");
            var titleText = document.createTextNode(title);

            a.appendChild(titleText);
            a.setAttribute("href", link);
            a.setAttribute("target","_blank");
            li.appendChild(a);

            document.querySelector("#ul").appendChild(li);
        }


        function createXmlHttp() {
            var xmlHttp = null;
            if (window.ActiveXObject) {
                xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
            } else {
                xmlHttp = new XMLHttpRequest();
            }
            return xmlHttp;
        }

        document.querySelector("#btn").onclick = function () {
            var xmlHttp = createXmlHttp();
            xmlHttp.open("get", "/load", true);
            xmlHttp.onreadystatechange = function () {
                if (xmlHttp.readyState == 4) {
                    var status = xmlHttp.status;
                    if (status == 200) {
                        var xmlDoc = xmlHttp.responseXML;
                        var items = xmlDoc.getElementsByTagName("item");
                        for (var i = 0; i < items.length; i++) {
                            var item = items[i];
                            var title = item.getElementsByTagName("title")[0].childNodes[0].nodeValue;
                            var link = item.getElementsByTagName("link")[0].childNodes[0].nodeValue;
                            createUl(title, link);
                        }
                    } else {
                        alert("请求异常：" + status);
                    }
                }
            };

            xmlHttp.send();
        }


    })();


</script>
</body>
</html>
