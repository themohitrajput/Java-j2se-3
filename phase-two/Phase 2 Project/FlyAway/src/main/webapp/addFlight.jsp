<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Flight</title>
<style>
	body
	{
		text-align: center;
	}
</style>
</head>
<body>
	<h3>Adding a New Flight</h3><hr><br>
	<form action="addFlight" method="get">
		<b>Enter Flight Code : </b><input type="number" name="fno">
		<br><br>
		<b>Enter Flight Airline : </b><input type="text" name="airline">
		<br><br>
		<b>Select the Days : </b>
		<br><br>
		<input type="checkbox" name="weeks" value="Sun">Sunday
		<input type="checkbox" name="weeks" value="Mon">Monday
		<input type="checkbox" name="weeks" value="Tue">Tuesday
		<input type="checkbox" name="weeks" value="Wed">Wednesday
		<input type="checkbox" name="weeks" value="Thu">Thursday
		<input type="checkbox" name="weeks" value="Fri">Friday
		<input type="checkbox" name="weeks" value="Sat">Saturday
  		<br><br>
  		<b>Enter Source Airport Code : </b><input type="text" name="src">
  		<br><br>
  		<b>Enter Destination Airport Code : </b><input type="text" name="dest">
		<br><br>
		<b>Enter Price : </b><input type="number" name="price">
		<br><br>
		<input type="submit" name="Save">
	</form>
</body>
</html>