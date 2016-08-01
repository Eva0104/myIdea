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
            <input type="text" class="form-control" placeholder="书籍名称或作者" name="q_s_like_bookname_or_bookauthor" value="${q_s_like_bookname_or_bookauthor}">
        </div>
        <div class="form-group">
            <input type="text" class="form-control" placeholder="最低价格" name="q_f_ge_bookprice" value="${q_f_ge_bookprice}"> - <input type="text" class="form-control" placeholder="最高价格" name="q_f_le_bookprice" value="${q_f_le_bookprice}">
        </div>
        <div class="form-group">
            <select name="q_i_eq_booktype.id" class="form-control">
                <option value="">请选择类别</option>
                <c:forEach items="${booktypeList}" var="type">
                    <option value="${type.id}" ${requestScope['q_i_eq_booktype.id'] == type.id ? 'selected' : '' }>${type.booktype}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <select name="q_i_eq_publisher.id" class="form-control">
                <option value="">请选择出版社</option>
                <c:forEach items="${publisherList}" var="pub">
                    <option value="${pub.id}" ${requestScope['q_i_eq_publisher.id'] == pub.id ? 'selected' : '' }>${pub.pubname}</option>
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
        <c:forEach items="${page.items}" var="book">
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
                visiblePages: 5,
                href: '?&p={{number}}&q_s_like_bookname_or_bookauthor=${q_s_like_bookname_or_bookauthor}&q_f_ge_bookprice=${q_f_ge_bookprice}&q_f_le_bookprice=${q_f_le_bookprice}&q_i_eq_booktype.id=${requestScope['q_i_eq_booktype.id']}&q_i_eq_booktype.id=${requestScope['q_i_eq_booktype.id']}'
            })
        });
    });
</script>
</body>
</html>