<%@page import="com.airlines.entity.Flight"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Flight</title>
<style>
	body
	{
		text-align: center;
	}
</style>
</head>
<body>
	<h3>Update Flight</h3><hr><br>
	<% Flight flt = (Flight)request.getAttribute("flight");%>
	<form action="updateFlt" method="get">
		<b>Enter Flight Code : </b><input type="number" name="fno" value="<%out.print(flt.getFid());%>">
		<br><br>
		<b>Enter Flight Airline : </b><input type="text" name="airline" value="<%out.print(flt.getAirline());%>">
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
  		<b>Enter Source Airport Code : </b><input type="text" name="src" value="<%out.print(flt.getSrc());%>">
  		<br><br>
  		<b>Enter Destination Airport Code : </b><input type="text" name="dest" value="<%out.print(flt.getDest());%>">
		<br><br>
		<b>Enter Price : </b><input type="text" name="dest" value="<%out.print(flt.getPrice());%>">
		<br><br>
		<input type="submit" name="Update">
	</form>
</body>
</html>