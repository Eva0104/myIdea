<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Title</title>
    <link rel="stylesheet" href="/static/js/webuploader/webuploader.css">
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <div class="page-header">
        <h3>Ajax文件上传</h3>
    </div>
    <div id="filebtn">
        上传文件
    </div>
    <ul id="fileList" class="list-inline">

    </ul>

    <button id="btn" class="btn-success">开始上传</button>

</div>

</body>
<script src="/static/js/jquery-1.11.3.min.js"></script>
<script src="/static/js/webuploader/webuploader.min.js"></script>

<script type="myTemplate" id="progressTemplate">
    <div class="progress">
        <div class="progress-bar progress-bar-success" role="progressbar" style="width: 0%"></div>
    </div>
</script>

<script>
    $(function () {
        var uploader = WebUploader.create({
            swf: "/static/js/webuploader/Uploader.swf",
            server: "/file",
            pick: "#filebtn",
            fileVal: "file",
            accept: {
                title: 'Images',
                extensions: 'gif,jpg,jpeg,bmp,png',
                mimeTypes: 'image/*'
            }


        });
        //将选择的文件放入到文件队列中
        uploader.on("fileQueued", function (file) {
            var $list = $("#fileList");
            var html = '<li id="' + file.id + '"><img class="img-thumbnail"></li>';
            $("#fileList").append(html);

            uploader.makeThumb(file, function (error, src) {
                if (error) {
                    return;
                }
                $("#" + file.id).find("img").attr('src', src);
            }, 100, 100);

        });
        //文件开始上传时调用
        uploader.on("uploadProgress", function (file, percentage) {
            percentage = parseInt(percentage * 100);
            var $li = $("#" + file.id);
            if ($li.find(".progress").length) {
                $li.find(".progress .progress-bar").css("width", percentage + "%");
            } else {
                var template = $("#progressTemplate").html();
                $li.append(template);
            }

        });
        //上传成功是调用
        uploader.on("uploadSuccess", function () {


        });
        //开启上传功能
        $("#btn").click(function () {
            uploader.upload();
        })


    })


</script>
</html>
