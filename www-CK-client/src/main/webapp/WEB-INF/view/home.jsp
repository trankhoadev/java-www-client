<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<input type="button"
		onclick="window.location.href='showFormAdd';return false" value="ADD">

	<table>
		<tr>
			<td>FirstName</td>
			<td>LastName</td>
			<td>Email</td>
			<td>Action</td>
		</tr>
		<c:forEach var="temp" items="${LIST}">
			<c:url var="updateLink" value="showFormUpdate">
				<c:param name="id" value="${temp.id}"></c:param>
			</c:url>
			<c:url var="deleteLink" value="delete">
				<c:param name="id" value="${temp.id}"></c:param>
			</c:url>
			<tr>
				<td>${temp.firstName}</td>
				<td>${temp.lastName}</td>
				<td>${temp.email}</td>
				<td><a href="${updateLink}">Update</a>|<a href="${deleteLink}"
					onclick="if(!(confirm('Are you sure want to delete this student?'))) return false">Delete</a>
			</tr>
		</c:forEach>
	</table>


</body>
</html>