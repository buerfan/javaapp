<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Research Data...</title>
</head>
<body>

	<form action="/testManagement/research" method="post">
		<table align="center">

			<tr>
				<td>Research Title</td>
				<td><input type="text" name="researchTitle" value="${researchs.researchTitle}"></td>
			</tr>
			<tr>
				<td>Research Authors</td>
				<td><input type="text" name="researchAuthors" value="${researchs.researchAuthors}"></td>
			</tr>

			<tr>
				<td>Year of Publication</td>
				<td><input type="text" name="publicationYear" value="${researchs.publicationYear}"></td>
			</tr>

			<tr>
				<td>Name of Journal</td>
				<td><input type="text" name="publicationJournal" value="${researchs.publicationJournal}"></td>
			</tr>

			<tr>
				<td>Description of Research</td>
				<td><input type="text" name="researchDescription" value="${researchs.researchDescription}"></td>
			</tr>
			
			
			<tr>
				<td>Research Citetion</td>
				<td><input type="text" name="researchCitation" value="${researchs.researchCitation}"></td>
			</tr>
			
			<tr>
				<td>Research Domain</td>
				<td><input type="text" name="researchDomain" value="${researchs.researchDomain}"></td>
			</tr>
			
			
			<tr>
				<td><c:if test="${action=='update'}">
						<input type="hidden" value="update" name="action">
					</c:if> <c:if test="${action=='new'}">
						<input type="hidden" value="new" name="action">
					</c:if> <input type="hidden" value="${researchs.researchid}" name="researchId"></td>
				<td><input type="submit" value="Submit"></td>
			</tr>
		</table>
	</form>

</body>
</html>