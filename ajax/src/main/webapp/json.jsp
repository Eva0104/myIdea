<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<button id="btn">获取JSON</button>
<ul id="list">

</ul>
</body>

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

        document.querySelector("#btn").onclick = function () {
            var xmlHttp = createXmlHttp();
            xmlHttp.open("get", "/user.json", true);
            xmlHttp.onreadystatechange = function () {
                if (xmlHttp.readyState == 4) {
                    var status = xmlHttp.status;
                    if (status == 200) {
                        var result = xmlHttp.responseText;
                        var json = JSON.parse(result);

                        for (var i = 0; i < json.length; i++) {
                            var user = json[i];
                            var name = user.name;
                            var address = user.address;
                            var password = user.password;

                            var li = document.createElement("li");
                            var text = document.createTextNode(name + address + password);

                            li.appendChild(text);

                            document.querySelector("#list").appendChild(li);

                            console.log(name, address, password);
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
</html>
