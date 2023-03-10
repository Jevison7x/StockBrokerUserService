<%--
    Document   : testingUpload
    Created on : Mar 2, 2023, 12:12:42 PM
    Author     : BLAZE
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Test</title>
    </head>
    <body>
        <h1 align ="center">Upload Image</h1>
        <div>
            <form action="upload-image" method="POST" enctype="multipart/form-data">
                Select Image
                <input type="file" name="file"/>
                <button type="submit">Submit</button>
            </form>
        </div>
    </body>
</html>
