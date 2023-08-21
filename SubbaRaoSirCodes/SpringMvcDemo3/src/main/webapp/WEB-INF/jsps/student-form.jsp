<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<f:form action="${pageContext.request.contextPath}/add" method="post" modelAttribute="student">
		Name:<f:input path="name"/><br>
		Address:<f:input path="address"/><br>
		DateOfBirth:<f:input path="dateOfBirth"/><br>
		<input type="submit" value="Submit">
	</f:form>
</body>
</html>