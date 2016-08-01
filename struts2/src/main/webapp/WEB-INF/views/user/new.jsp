<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>User save.....</h1>

    <form action="/user/save" method="post">
        <input type="text" name="user.username">
        <input type="text" name="user.address">
        <button>保存</button>
    </form>
</body>
</html>
