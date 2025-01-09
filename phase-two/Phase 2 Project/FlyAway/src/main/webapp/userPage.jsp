<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome User</title>
<style>
	body{
		text-align: center;
	}
</style>
</head>
<body>
	<h3>Welcome Back, <%out.print(request.getSession().getAttribute("username")); %></h3>
	<hr>
	<br>
	<a href="changepassword.jsp">Change Password</a><br><br>
	<a href="searchFlight.jsp">Search and Book Flight</a><br><br>
	<a href="fetchbooking">Check Previous Bookings</a><br><br>
</body>
</html>