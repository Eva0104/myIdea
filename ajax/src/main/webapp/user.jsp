<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<button id="btn">读取Xml</button>
<div id="userBox">
    <%--<h2>tom <small>100</small></h2>--%>
    <%--<p>usa</p>--%>
</div>

<script>
    (function () {

        function createDiv(id,username,address){
            var div = document.createElement("div");
            var h2 = document.createElement("h2");
            var small = document.createElement("small");
            var p = document.createElement("p");

            var nameText = document.createTextNode(username);
            var idText = document.createTextNode(id);
            var addressText = document.createTextNode(address);

            small.appendChild(idText);
            h2.appendChild(nameText);
            p.appendChild(addressText);

            h2.appendChild(small);
            div.appendChild(h2);
            div.appendChild(p);
            document.getElementById("userBox").appendChild(div);

        }


        function createXmlHttp() {
            var xmlHttp = null;
            if (window.ActiveXObject) {
                xmlHttp = new ActiveXObject("Microsoft.XMLHTTP")
            } else {
                xmlHttp = new XMLHttpRequest();
            }
            return xmlHttp;
        }

        document.querySelector("#btn").onclick = function () {
            var xmlHttp = createXmlHttp();
            xmlHttp.open("get", "/user.xml", true);
            xmlHttp.onreadystatechange = function () {
                if (xmlHttp.readyState == 4) {
                    var httpState = xmlHttp.status;
                    if (httpState == 200) {
                        document.getElementById("userBox").innerText = "";
                        var xmlDoc = xmlHttp.responseXML;
                        var userArray = xmlDoc.getElementsByTagName("user");
                        for(var i = 0;i < userArray.length;i++){
                            var user = userArray[i];
                            var id = user.getAttribute("id");
                            var username = user.getElementsByTagName("username")[0].childNodes[0].nodeValue;
                            var address = user.getElementsByTagName("address")[0].childNodes[0].nodeValue;
                            createDiv(id,username,address);
                        }

                    } else {
                        alert("请求服务器异常：" + httpState);
                    }
                }
            };

            xmlHttp.send();
        }


    })();
</script>
</body>
</html>
