<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <div class="panel panel-default">
        <div>
            <div class="panel-heading">
                文件列表
                <a href="/servlet3" class="btn btn-success btn-sm pull-right">上传文件</a>
            </div>
        </div>
        <table class="table">
            <thead>
            <tr>
                <th>编号</th>
                <th>文件名称</th>
                <th>文件大小</th>
                <th>MD5值</th>
                <th>#</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${list}" var="doc">
                <tr>
                    <th>${doc.id}</th>
                    <td>${doc.filename}</td>
                    <td>${doc.displaysize}</td>
                    <td>${doc.md5}</td>
                    <td><a href="/preview?file=${doc.md5}">预览</a>
                        <a href="/preview?file=${doc.md5}&down=true">下载</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
