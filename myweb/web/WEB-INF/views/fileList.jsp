<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta charset="utf-8">
    <title>Title</title>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <div class="page-header">
            <h3>File List</h3>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading">
                文件列表
                <a href="/upload" class="btn btn-success btn-sm pull-right">上传文件</a>
            </div>
            <div class="panel-body">
                <table class="table">
                    <thead>
                        <tr>
                            <th>文件名</th>
                            <th>文件大小</th>
                            <th>MD5</th>
                            <th>#</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${requestScope.list}" var="doc">
                        <tr>
                            <td>${doc.filename}</td>
                            <td>${doc.displaysize}</td>
                            <td>${doc.md5}</td>
                            <td><a href="/preview?file=${doc.md5}&down=true" >下载</a></td>
                            <td><a target="_blank" href="/preview?file=${doc.md5}">预览</a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>

        </div>

    </div>
</body>
</html>
