<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.LTI.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% User u=(User)session.getAttribute("userById");
if(u!=null)
{
	%>
	
	<center>
	<form method="post" action="http://Localhost:9090/UserMVC/UDUserController">
Enter your id:<input type= "number" name="id" value="<%= u.getId()%>">
<br><br>
Enter your name:<input type= "text" name="name"  value="<%= u.getName()%>">
<br><br>
Enter your email:<input type= "text" name="email" value="<%= u.getEmail()%>">
<br><br>
Enter your password:<input type= "password" name="password"  value="<%= u.getPassword()%>">
<br><br>
<input type="submit" name="button" value="updateUser">
<br><br>
<input type="submit" name="button" value="deleteUser">
</form> 
	
	
	</center>
	<%
}
else
{
	%>
	<h1>No records found</h1>
	<%
}
	%>




</body>
</html>