<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Flight</title>
<style>
	body
	{
		text-align: center;
	}
</style>
</head>
<body>
	<h3>Search Flight</h3><hr><br>
	<form action="searchFlight" method="get">
		<label for="fromLocation">From:</label>
  		<select name="fromLocation" id="fromLocation">
    		<option value="BOM">Mumbai</option>
    		<option value="DEL">Delhi</option>
    		<option value="BLR">Bangalore</option>
    		<option value="STV">Surat</option>
  		</select>
  		<br><br>
  		<label for="toLocation">To:</label>
  		<select name="toLocation" id="toLocation">
    		<option value="BOM">Mumbai</option>
    		<option value="DEL">Delhi</option>
    		<option value="BLR">Bangalore</option>
    		<option value="STV">Surat</option>
  		</select>
  		<br><br>
  		Travel Date : <input type="date" name="travelDate">
  		<br><br>
  		No. of Passengers : <input type="number" name="passengers">
  		<br><br>
  		<input type="submit" value="Search">
	</form>
</body>
</html>