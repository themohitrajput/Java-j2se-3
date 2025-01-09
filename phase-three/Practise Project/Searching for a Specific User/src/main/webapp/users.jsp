<%@tagliburi="http://java.sun.com/jsp/jstl/core"prefix="c"%>

<html>
<head>
<style>
table,th,td {
	border: 1px solid black;
}
</style>
</head>
<body>
	<h2>Users</h2>

	<tablestyle="float: left">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Email</th>
			<th>Password</th>
		</tr>
		<c:forEachitems="${users}"var="user"varStatus="count">
			<trid="${count.index}">
				<td>${user.id}</td>
				<td>${user.name}</td>
				<td>${user.email}</td>
				<td>${user.password}</td>
			</tr>
		</c:forEach>
	</table>

	<formaction="/users"method="post">
	
	<br><br><br><br><br><br><br><br><br><br>
		<labelfor="id">ID:</label><inputtype="text"id="id"name="id"><br>
		<br>

		<inputtype="submit"value="Enter">
	</form>



</body>
</html>
