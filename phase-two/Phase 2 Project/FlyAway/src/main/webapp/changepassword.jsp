<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Change Password</title>
<style>
	body
	{
		text-align: center;
	}
</style>
</head>
<body>
	<h3>Change User Password</h3><hr><br>
	<form action="changepswd" method="post">
		Enter New Password : <input type="text" name="newpassword"><br>
		<input type="submit" value="Save">
	</form>
</body>
</html>