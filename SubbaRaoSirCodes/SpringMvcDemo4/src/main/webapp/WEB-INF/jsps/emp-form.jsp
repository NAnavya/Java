<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
	.error{
		color: red;
	}
</style>
</head>
<body>
	<f:form action="${pageContext.request.contextPath}/process" method="post" modelAttribute="emp">
		Name:<f:input path="name"/><span class="error"><f:errors path="name" cssClass="error">Please enter Correct name</f:errors></span><br>
		Address:<f:input path="address"/><span class="error"><f:errors path="address" cssClass="error">Address is required</f:errors></span><br>
		Age:<f:input path="age"/><span class="error"><f:errors path="age" cssClass="error">Please enter Correct Age</f:errors></span><br>
		<input type="submit" value="Submit">
	</f:form>
</body>
</html>