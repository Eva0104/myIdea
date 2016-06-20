<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<button id="btn">post方式提交</button>
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
            xmlHttp.open("post","/ajax?",true);
            xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
            xmlHttp.onreadystatechange = function(){
              alert("post提交");
            };
            xmlHttp.send("name=Tom");
        };


    })();

</script>
</body>
</html>
