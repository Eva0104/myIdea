<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="/repo/css/bootstrap.min.css">
</head>
<body>
<div class="container">

    <div class="page-header">
        <h3>添加书籍</h3>
    </div>

    <div class="row">
        <div class="col-xs-4">

            <form method="post" action="/book/save">
                <div class="form-group">
                    <label>书籍名称</label>
                    <input class="form-control" type="text" name="book.bookname">
                </div>
                <div class="form-group">
                    <label>作者</label>
                    <input class="form-control" type="text" name="book.bookauthor">
                </div>
                <div class="form-group">
                    <label>价格</label>
                    <input class="form-control" type="text" name="book.bookprice">
                </div>
                <div class="form-group">
                    <label>数量</label>
                    <input class="form-control" type="text" name="book.booknum">
                </div>
                <div class="form-group">
                    <label>分类</label>

                    <select class="form-control" name="book.booktype.id">
                        <c:forEach items="${booktypeList}" var="type">
                            <option value="${type.id}">${type.booktype}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label>出版社</label>
                    <select class="form-control" name="book.publisher.id">
                        <c:forEach items="${publisherList}" var="pub">
                            <option value="${pub.id}">${pub.pubname}</option>
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
