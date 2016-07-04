/**
 * Created by Eric on 2016/6/20.
 */

var Ajax = (function () {

    function createXmlHttp() {
        var xmlHttp = null;
        if (window.ActiveXObject) {
            xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
        } else {
            xmlHttp = new XMLHttpRequest();
        }
        return xmlHttp;
    }

    function buildqueryParam(isPost, objectParam) {
        var queryParam = "?";
        if (isPost) {
            queryParam = "";
        }
        for (var index in objectParam) {
            queryParam += (index + "=" + objectParam[index] + "&");
        }
        if (!isPost) {
            queryParam += ("_=" + new Date().getTime());
        } else {
            if (queryParam.lastIndexOf("&") == queryParam.length - 1) {
                queryParam = queryParam.substring(0, queryParam.length - 1);
            }
        }
        return queryParam;
    }

    function sendGetRequest(url, callback, queryParam) {
        var xmlHttp = createXmlHttp();
        xmlHttp.open("get", url + buildqueryParam(false,queryParam), true);
        xmlHttp.onreadystatechange = function () {
            var readyState = xmlHttp.readyState;
            if (readyState == 4) {
                var httpState = xmlHttp.status;
                if (httpState == 200) {
                    var result = xmlHttp.responseText;
                    callback(result);
                } else {
                    alert("服务器请求异常" + httpState);
                }
            }
        };
        xmlHttp.send();
    }

    function sendPostRequest(url, callback, queryParam) {
        var queryParam;
        var xmlHttp = createXmlHttp();
        xmlHttp.open("post", url, true);
        xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        xmlHttp.onreadystatechange = function () {
            var readyState = xmlHttp.readyState;
            if (readyState == 4) {
                var httpState = xmlHttp.status;
                if (httpState == 200) {
                    var result = xmlHttp.responseText;
                    callback(result);
                } else {
                    alert("服务器请求异常" + httpState);
                }
            }
        };
        xmlHttp.send(buildqueryParam(true, queryParam));
    }

    return {
        Get: sendGetRequest,
        Post: sendPostRequest
    };

})();
