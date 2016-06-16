<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
</head>
<body>
    <div class="col-md-3">
        <form method="post" enctype="multipart/form-data">
            <div class="input-group" style="margin-top: 10px">
                <label>文件描述</label>
                <input type="text" name="fileDesc">
            </div>
            <div class="input-group" style="margin-top: 10px">
                <label>请选择文件</label>
                <input type="file" name="doc">
            </div>
            <div class="input-group" style="margin-top: 10px">
                <button>保存</button>
            </div>
        </form>
    </div>
</body>
</html>
