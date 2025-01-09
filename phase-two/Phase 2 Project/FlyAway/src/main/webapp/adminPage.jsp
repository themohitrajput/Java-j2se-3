<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome Admin</title>
<style>
	body
	{
		text-align: center;
	}
</style>
</head>
<body>
	<h3>Welcome <%out.print(request.getSession().getAttribute("adminname")); %></h3>
	<hr><br>
	<a href="addFlight.jsp">Add New Flights</a><br><br>
	<a href="getFlight.jsp">Update Flight</a><br><br>
</body>
</html>