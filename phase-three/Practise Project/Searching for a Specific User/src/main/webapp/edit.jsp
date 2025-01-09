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
	<h2>Edit User</h2>

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
	<formaction="/edit"method="post">
	<br><br><br>

		<labelfor="name">Name: </label><inputtype="text"id="name"
			name="name"><br><br><labelfor="email">Email:</label>
		<inputtype="text"id="email"name="email"><br><br>
		<labelfor="password">Password:</label><inputtype="text"
			id="password"name="password"><br><br><input
			type="submit"value="Enter">
	</form>
	<ahref="users">Back</a>
</body>
</html>
