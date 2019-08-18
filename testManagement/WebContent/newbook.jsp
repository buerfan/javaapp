<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Book</title>
</head>
<body>

<h2>New Book...</h2>

<form action="/testManagement/book" method="post">
		<table align="center">
			
			<tr>
				<td>Title</td>
				<td><input type="text" name="title"  value="${books.title}"></td>
			</tr>
			
			<tr>
				<td>Author</td>
				<td><input type="text" name="author" value="${books.author}"></td>
			</tr>
			
			<tr>
				<td>Price</td>
				<td><input type="text" name="price" value="${books.price}"></td>
			</tr>
			
			<tr>
				<td>
				
				<c:if test="${action=='update'}">
				<input type="hidden" value="update" name="action">	
				</c:if>
				
				<c:if test="${action=='new'}">
				<input type="hidden" value="new" name="action">
				</c:if>
				
				<input type="hidden" value="${books.id}" name="bookId">
				</td>
				<td><input type="submit" value="Submit"></td>
			</tr>
		</table>
	</form>
	
	
</body>
</html>