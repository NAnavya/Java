<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Welcome to Home Page</h1>
	<a href="${pageContext.request.contextPath}/employees">Get
		Employees</a>
	<a href="${pageContext.request.contextPath}/show">Insert Employee</a>
	<hr>
	<table>
		<tr>
			<th>Eno</th>
			<th>Name</th>
			<th>Address</th>
			<th>Age</th>
		</tr>

		<c:forEach var="e" items="${employees}">
			<c:url var="deleteLink"
				value="${pageContext.request.contextPath}/delete/${e.eno}" />
			<c:url var="updateLink"
				value="./update">
				<c:param name="eno" value="${e.eno}" />
			</c:url>
			<tr>
				<td>${e.eno}</td>
				<td>${e.name}</td>
				<td>${e.address}</td>
				<td>${e.age}</td>
				<td><a href="${deleteLink}">Delete</a></td>
				<td><a href="${updateLink}">Update</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>