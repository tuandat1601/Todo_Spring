<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
<title>login page</title>
<link href="webjars/bootstrap/5.3.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
<pre>${errorlogin}</pre>

<form method="post">
Name: <input type="text" name="name"><br>
Password: <input type="password" name="password">
<input type="submit"class ="btn btn-success">
</form>
</div>
</body>
</html>