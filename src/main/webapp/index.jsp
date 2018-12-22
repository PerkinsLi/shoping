<%@ page language="java"  contentType="text/html; charset=UTF-8" %>

<html>
<body>
<h2>Hello World!</h2>

<form action="/manage/product/upload.do" method="post" enctype="multipart/form-data">
    <input type="file" name="file"/>
    <input type="submit" value="springMvc上传文件"/>
</form>

<form action="/manage/product/richtext_img_upload.do" method="post" enctype="multipart/form-data">
    <input type="file" name="upload_file"/>
    <input type="submit" value="富文本图片上传"/>
</form>
</body>
</html>
