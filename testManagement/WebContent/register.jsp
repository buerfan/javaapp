<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Register...</title>
<link rel="stylesheet" href="css/registration.css" type="text/css">
</head>
<body>
	<form action="/testManagement/authentication" method="post">

		<div class="container">
			<label>First Name</label><br> <input type="text"
				placeholder="Enter Name" required="required" name="firstName">
			<br>
			<label>Last Name</label><br> <input type="text"
				placeholder="Enter Last Name" required name="lastName"> <label>Enter
				Email</label><br> <input type="text" placeholder="Enter Email" required
				name="email"> <label>Password</label><br> <input
				type="password" placeholder="Enter Password" required="required"
				name="password"> <br>
			<label>Re-Type Password</label><br> <input type="password"
				placeholder="Enter Password Again" required name="retype_pass"><br>
			<label>Date of Birth</label><br> 
			
			
			<input type="date"
				placeholder="Enter Last Name" required name="datetime"> <br>
			<label>Sex   </label><br> <select name="sex">
				<option value="male">Male</option>
				<option value="female">Female</option>
			</select> <br>
			<p>
				By creating an account you agree to our <a href="#"
					style="color: dodgerblue">Terms & Privacy</a>.
			</p>
			<div>
			
				<c:if test="${event=='register'}">
					<input type="hidden" value="register" name="event">
				</c:if>
				
				<button type="button" class="cancelbtn">Cancel</button>
				<button type="submit" class="signupbtn">Sign Up</button>
			</div>
		</div>
	</form>
</body>
</html>