<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<form action="/testManagement/authentication" method="post">
	
	<%
	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Cache-Control", "no-store");
	response.setHeader("Expires", "0");
	%>
		${message}
		<div class="container_login">
			<table>
				<tr>
					<td>Email</td>
					<td><input type="text" name="login_id" placeholder="Enter email id"></td>
				</tr>
				
				
				<tr>
					<td>Password</td>
					<td><input type="password" placeholder="Enter password" name="login_password"></td>
				</tr>
				
				<tr>
					<td><c:if test="${event=='login'}">
					<input type="hidden" value="login" name="event">
				</c:if></td>
					<td><input type="submit" value="Submit"></td>
				</tr>
			</table>
		
		</div>

	</form>
</body>
</html>