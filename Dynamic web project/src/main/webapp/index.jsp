<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Log IN!" %>
</h1>
<br/>

<form action="hello-servlet" method="post">
    User Name: <input type="text" name="uname">
    Password: <input type="text" name="pwd">
    <button type="submit">Submit</button>
</form>
</body>
</html>