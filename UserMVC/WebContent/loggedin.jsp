<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.LTI.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
 
  User u=(User)session.getAttribute("user");

%>
<center>
<br>
<a href="AddUser.jsp">Add User</a>
<br>
<a href="http://localhost:9090/UserMVC/fetchallusers">Show Users</a>
<br>
<h2>Your Profile</h2>


Id:<%= u.getId() %>
<br><br>

Name:<%= u.getName() %>
<br><br>

Email:<%= u.getEmail() %>
<br><br>

Password:<%= u.getPassword() %>
<br><br>

<a href="logout.jsp">Logout</a>
</center>
</body>
</html>