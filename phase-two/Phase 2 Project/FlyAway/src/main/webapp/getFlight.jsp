<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Updating Flight</title>
<style type="text/css">
	body
	{
		text-align: center;
	}
</style>
</head>
<body>
	<h3>Search Flight by FlightID</h3><hr>
	<form action="getFlight" method="get">
		<b>Enter Flight id : </b><input type="number" name="fid"><br>
		<input type="submit" value="Search">
	</form>
</body>
</html>