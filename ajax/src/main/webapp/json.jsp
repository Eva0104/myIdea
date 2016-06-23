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
<script src="/static/js/jquery-1.11.3.min.js"></script>
<script>
    //    (function () {
    //        function createXmlHttp() {
    //            var xmlHttp = null;
    //            if (window.ActiveXObject) {
    //                xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
    //            } else {
    //                xmlHttp = new XMLHttpRequest();
    //            }
    //            return xmlHttp;
    //        }
    //
    //        document.querySelector("#btn").onclick = function () {
    //            var xmlHttp = createXmlHttp();
    //            xmlHttp.open("get", "/user.json", true);
    //            xmlHttp.onreadystatechange = function () {
    //                if (xmlHttp.readyState == 4) {
    //                    var status = xmlHttp.status;
    //                    if (status == 200) {
    //                        var result = xmlHttp.responseText;
    //                        var json = JSON.parse(result);
    //
    //                        for (var i = 0; i < json.length; i++) {
    //                            var user = json[i];
    //                            var name = user.name;
    //                            var address = user.address;
    //                            var password = user.password;
    //
    //                            var li = document.createElement("li");
    //                            var text = document.createTextNode(name + address + password);
    //
    //                            li.appendChild(text);
    //
    //                            document.querySelector("#list").appendChild(li);
    //
    //                            console.log(name, address, password);
    //                        }
    //                    } else {
    //                        alert("请求异常：" + status);
    //                    }
    //                }
    //
    //            };
    //            xmlHttp.send();
    //        }
    //
    //
    //    })();

    $(function () {
//        $("#btn").click(function () {
//
//            $.getJSON("/user.json")
//                    .done(function(result){
//                        for(var i = 0;i<result.length;i++){
//                            var user = result[i];
//                            console.log(user.name);
//                        }
//                    })
//                    .fail(function(){
//                        alert("失败！");
//                    })
//                    .always(function(){
//                        console.log("always~~~~~~~~~~~")
//                    })
//
//        })
        $("#btn").click(function () {
            $.ajax({
                url: "/user.json",
                type: "get",
                success: function (json) {
                    for (var i = 0; i < json.length; i++) {
                        var user = json[i];
                        console.log(user.name);
                    }
                },
                complete: function () {
                    alert("complete")
                },
                statusCode: {
                    404: function () {
                        alert("page not found");
                    },
                    500: function () {
                        alert("服务器运行时出错");
                    }
                },
                error: function () {
                    alert("error");
                },
                beforeSend: function () {
                    alert("还未发送Ajax")
                },
                timeout: 3000


            });

        });
    })


</script>
</html>
