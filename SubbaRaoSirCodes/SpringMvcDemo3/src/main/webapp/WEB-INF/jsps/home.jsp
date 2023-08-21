<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Student Management System</h1>
	<a href="${pageContext.request.contextPath}/students">Get Students</a>
	<a href="${pageContext.request.contextPath}/show">Add Student</a>
	<table>
		<tr>
			<td>Sid</td>
			<td>Name</td>
			<td>Address</td>
			<td>DateOfBirth</td>
		</tr>
		<c:forEach var="student" items="${students}">
			<tr>
				<td>${student.sid}</td>
				<td>${student.name}</td>
				<td>${student.address}</td>
				<td>${student.dateOfBirth}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>