<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
    <style>
        body{
            font-size: 24px;
            margin-top: 20px;
            margin-left: 10px;
        }
    </style>
</head>
<body>
<div>
    <form method="post" enctype="multipart/form-data" action="/servlet3">
        <input type="text" placeholder="请输入文件描述" name="fileDesc">
        <input type="file" name="doc"></br>
        <div>
            <button>上传</button>
        </div>
    </form>
</div>
</body>
</html>
