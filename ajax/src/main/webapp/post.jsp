<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<button id="getBtn">get方式提交</button>
<button id="btn">post方式提交</button>
<script src="/static/js/ajax.js"></script>
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
            xmlHttp.open("post", "/ajax", true);
            xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            xmlHttp.onreadystatechange = function () {
                var readyState = xmlHttp.readyState;
                if (readyState == 4) {
                    var httpState = xmlHttp.status;
                    if (httpState == 200) {
                        var result = xmlHttp.responseText;
                        alert("post方法提交");
                    } else {
                        alert("服务器请求异常" + httpState);
                    }
                }
            };

            xmlHttp.send("name=Tom");
        };
        document.querySelector("#getBtn").onclick = function () {
            Ajax.Get("/ajax", function (result) {
                alert(result + "get方式提交");
            })
        };
//        document.querySelector("#btn").onclick = function (){
//            Ajax.Post("/ajax",function(){
//                alert("post方式提交");
//            },{name:"jack"})
//        };
    })();

</script>
</body>
</html>
