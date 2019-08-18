<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>

	<a href="/testManagement/authentication?event=login">Login</a>
	<a href="/testManagement/authentication?event=register">Register</a>
	<h2 align="center">Product Management...</h2>
	<a href="/testManagement/book?action=new">Add New Book</a>

	<table align="center" border="1">
		<tr>
			<td>ID</td>
			<td>Title</td>
			<td>Author</td>
			<td>Price</td>
			<td>Update</td>
			<td>Delete</td>

		</tr>

		<c:forEach items="${books}" var="book">
			<tr>
				<td>${book.id}</td>
				<td>${book.title}</td>
				<td>${book.author}</td>
				<td>${book.price}</td>
				<td><a href="/testManagement/book?action=update&id=${book.id}">Update</a></td>
				<td><a href="/testManagement/book?action=delete&id=${book.id}">Delete</a></td>
			</tr>
		</c:forEach>

	</table>

	</br>
	</br>
	<h2>Reseacrh Work...</h2>
	<h4>
		<a href="/testManagement/research?action=new">Add New Research</a>
	</h4>

	<table align="center" border="1">
		<tr>
			<td>ID</td>
			<td>Title</td>
			<td>Author</td>
			<td>Year Of Publication</td>
			<td>Journal Name</td>
			<td>Description</td>
			<td>Citation</td>
			<td>Domain</td>
			<td>Action Update</td>
			<td>Action Delete</td>

		</tr>

		<c:forEach items="${researchs}" var="research">
			<tr>
				<td>${research.researchid}</td>
				<td>${research.researchTitle}</td>
				<td>${research.researchAuthors}</td>
				<td>${research.publicationYear}</td>
				<td>${research.publicationJournal}</td>
				<td>${research.researchDescription}</td>
				<td>${research.researchCitation}</td>
				<td>${research.researchDomain}</td>

				<td><a
					href="/testManagement/research?action=update&id=${research.researchid}">Update</a></td>
				<td><a
					href="/testManagement/research?action=delete&id=${research.researchid}">Delete</a></td>
			</tr>
		</c:forEach>

	</table>




</body>
</html>