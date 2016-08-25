<%@ page language="java"  pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
        <title>文件上传</title>

        <meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">
    </head>

    <body>
       
        <form action="blog_saveBlog.action" enctype="multipart/form-data" method="post">
            文件1:<input type="file" name="file"><br/>
            文件2:<input type="file" name="file"><br/>
            文件3:<input type="file" name="file"><br/>
                <input type="submit" value="上传" />
        </form>
    </body>
</html>