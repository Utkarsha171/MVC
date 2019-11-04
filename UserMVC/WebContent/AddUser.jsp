<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<form method="post" action="http://Localhost:9090/UserMVC/AddUserController">
Enter your id:<input type= "number" name="id">
<br><br>
Enter your name:<input type= "text" name="name">
<br><br>
Enter your email:<input type= "text" name="email">
<br><br>
Enter your password:<input type= "password" name="password">
<br><br>
<input type="submit" value="adduser">
</form>
</center>
</body>
</html>