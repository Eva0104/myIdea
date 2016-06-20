<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!
<html>
<head>
    <meta charset="UTF-8">
    <title>Document</title>
</head>
<body>
<input type="text" id="userName"><span id="result"></span>

<script>
    (function(){
        function createXmlHttp(){
            var xmlHttp = null;
            if(window.ActiveXObject){
                xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
            }else{
                xmlHttp = new XMLHttpRequest();
            }
            return xmlHttp;
        }
        document.querySelector("#userName").onblur = function(){
            var username = this.value;
            var xmlHttp = createXmlHttp();

            xmlHttp.open("get","/checkUsername?username="+encodeURIComponent(username),true);

            xmlHttp.onreadystatechange = function(){

                var readyState = xmlHttp.readyState;
                console.log(readyState);
                if(readyState == 4){
                    var httpState = xmlHttp.status;
                    if(httpState == 200){
                        var result = xmlHttp.responseText;
                        if(result == "yes"){
                            document.querySelector("#result").innerText="√";
                        }else{
                            document.querySelector("#result").innerText="该用户名已被占用";
                        }
                    }else{
                        alert("服务器请求异常：" + httpState);
                    }
                }
            };
            xmlHttp.send();
        }
    })();

</script>
</body>
</html>
