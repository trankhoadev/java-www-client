<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form action="saveCustomer" modelAttribute="customer" method="GET">
		<form:hidden path="id" value="${customer.id}" />
		<table>
			<tr>
				<td>FirstName</td>
				<td><form:input type="text" path="firstName"
						value="${customer.firstName}" /></td>
			</tr>
			<tr>
				<td>LastName</td>
				<td><form:input type="text" path="lastName"
						value="${customer.lastName}" /></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><form:input type="text" path="email"
						value="${customer.email}" /></td>
			</tr>
			<tr>
				<td><label></label></td>
				<td><input type="submit" value="Submit" /></td>
			</tr>


		</table>
	</form:form>


	<a href="">back to home</a>
</body>
</html>