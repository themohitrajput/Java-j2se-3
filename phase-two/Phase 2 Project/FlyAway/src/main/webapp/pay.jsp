<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Payment Window</title>
<style>
	body
	{
		text-align: center;
	}
</style>
</head>
<body>
	<h3>Payment Window</h3><hr>
	<form action="ticket" method="get">
		Total Amount : <input type="number" name="totalAmount" value="<%out.print(session.getAttribute("totalAmount"));%>" readonly>
		<br><br>
		Enter Debit/Credit Card Details :
		<br><br>
		Card Number : <input type="number" name="card"><br><br>
		CVV : <input type="number" name="cvv"><br><br>
		<input type="submit" value="Pay">
	</form>
</body>
</html>