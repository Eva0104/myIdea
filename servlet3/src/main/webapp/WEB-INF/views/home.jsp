<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Title</title>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
</head>
<style>
    body{
        background-color: #5cb85c;
    }
</style>
<body>
    <div class="container">
        <div class="page-header">
            <h3>分页</h3>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading">
                电影列表
            </div>
            <div class="panel-body">
                <table class="table">
                    <thead>
                        <tr>
                            <th>电影名称</th>
                            <th>评分</th>
                            <th>导演</th>
                            <th>发行时间</th>
                            <th>上映时间</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${requestScope.page.items}" var="movie">
                            <tr>
                                <td width="400">${movie.title}</td>
                                <td>${movie.rate}</td>
                                <td width="200">${movie.daoyan}</td>
                                <td>${movie.releaseyear}</td>
                                <td>${movie.sendtime}</td>
                            </tr>
                        </c:forEach>
                    </tbody>

                </table>
            </div>
            <div class="panel-footer text-right">
                <ul>
                    <a href="/home?p=1">首页</a>
                    <a href="/home?p=${page.pageNum-1}">上一页</a>
                    <a href="/home?p=${page.pageNum+1}">下一页</a>
                    <a href="/home?p=${page.totalPageSize}">末页</a>
                </ul>
            </div>
        </div>
    </div>
</body>
</html>
