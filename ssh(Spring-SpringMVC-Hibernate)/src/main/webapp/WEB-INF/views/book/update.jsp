<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
</head>
<body>
<div class="container">

    <div class="page-header">
        <h3>修改书籍信息</h3>
    </div>
    <c:if test="${not empty message}">
        <div class="alert alert-success">${message}</div>
    </c:if>

    <div class="row">
        <div class="col-xs-4">

            <form method="post" action="">
                <div class="form-group">
                    <label>书籍名称</label>
                    <input class="form-control" type="text" name="bookname" value="${book.bookname}">
                </div>
                <div class="form-group">
                    <label>作者</label>
                    <input class="form-control" type="text" name="bookauthor" value="${book.bookauthor}">
                </div>
                <div class="form-group">
                    <label>价格</label>
                    <input class="form-control" type="text" name="bookprice" value="${book.bookprice}">
                </div>
                <div class="form-group">
                    <label>数量</label>
                    <input class="form-control" type="text" name="booknum" value="${book.booknum}">
                </div>
                <div class="form-group">
                    <label>分类</label>

                    <select class="form-control" name="booktype.id">
                        <c:forEach items="${booktypeList}" var="type">
                            <option value="${type.id}" ${book.booktype.id == type.id ? 'selected':''}>${type.booktype}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label>出版社</label>
                    <select class="form-control" name="publisher.id">
                        <c:forEach items="${publisherList}" var="pub">
                            <option value="${pub.id}" ${book.publisher.id==pub.id ? 'selected':""}>${pub.pubname}</option>
                        </c:forEach>
                    </select>
                </div>

                <button class="btn btn-primary">保存</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
