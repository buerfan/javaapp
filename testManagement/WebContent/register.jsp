<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Register...</title>
<link rel="stylesheet" href="css/registration.css" type="text/css">
</head>
<body>
	<form method="get">

		<div class="container">
			<label>First Name</label><br> <input type="text" placeholder="Enter Name"
				required="required" name="firstName"> 
				<br><label>Last
				Name</label><br> <input type="text" placeholder="Enter Last Name" required
				name="lastName">
				<label>Enter Email</label><br> <input type="text" placeholder="Enter Email" required
				name="email">
				
				<label>Password</label><br> <input type="password" placeholder="Enter Password"
				required="required" name="password"> 
				<br><label>Re-Type Password</label><br> <input type="password" placeholder="Enter Password Again" required
				name="lastName"><br>
				<label>Date of Birth</label><br> <input type="datetime-local" placeholder="Enter Last Name" required
				name="lastName">
				<br>
				<label>Sex</label><br> 
				<select>
					<option value="male">Male</option>
					<option value="female">Female</option>
				</select>
		</div>
	</form>
</body>
</html>