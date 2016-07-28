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
        <h3>图书列表</h3>
    </div>
    <c:if test="${not empty message}">
        <div class="alert alert-success">${message}</div>
    </c:if>
    <form class="form-inline" action="">
        <div class="form-group">
            <input type="text" class="form-control" placeholder="书籍名称" name="bookname" value="${bookname}">
        </div>
        <div class="form-group">
            <select name="type" class="form-control">
                <option value="">请选择类别</option>
                <c:forEach items="${bookTypeList}" var="type">
                    <option value="${type.id}" ${type.id == typeid ? 'selected' : '' }>${type.booktype}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <select name="pub" class="form-control">
                <option value="">请选择出版社</option>
                <c:forEach items="${bookPubList}" var="pub">
                    <option value="${pub.id}" ${pub.id == pubid ? 'selected' : '' }>${pub.pubname}</option>
                </c:forEach>
            </select>
        </div>
        <button class="btn btn-info">搜索</button>
    </form>
    <a class="btn btn-success" href="/books/new">添加书籍</a>
    <table class="table">
        <thead>
        <tr>
            <th>书名</th>
            <th>作者</th>
            <th>价格</th>
            <th>数量</th>
            <th>出版社</th>
            <th>分类</th>
            <th>#</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${bookList}" var="book">
            <tr>
                <td>${book.bookname}</td>
                <td>${book.bookauthor}</td>
                <td>${book.bookprice}</td>
                <td>${book.booknum}</td>
                <td>${book.publisher.pubname}</td>
                <td>${book.booktype.booktype}</td>
                <td>
                    <a href="/books/${book.id}/update">修改</a>
                    <a href="/books/${book.id}/del">删除</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <ul id="page" class="pagination"></ul>
</div>
<script src="/static/js/jquery-1.11.3.min.js"></script>
<script src="/static/js/jquery.twbsPagination.min.js"></script>
<script>
    $(function () {
        $(function () {
            $("#page").twbsPagination({
                totalPages:${page.totalPageSize},
                first: '首页',
                prev: '<<',
                next: '>>',
                last: '末页',
                visiblePages: 10,
                href: '?bookname=' + encodeURIComponent('${bookname}') + '&type=${typeid}&pub=${pubid}&p={{number}}'
            })
        });
    });
</script>
</body>
</html>
