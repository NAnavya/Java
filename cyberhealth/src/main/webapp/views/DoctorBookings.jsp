<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
<style type="text/css">
</style>
<title>Insert title here</title>  
</head>  
<body>
    <h2>Booking Details</h2>
<table border="1" cellpadding="1" width="100%">
<tr style="text-align: center;">
    <th>Id</th>
    <th>Date</th>
    <th>Time</th>
    <th>Patient Id</th>
    <th>Patient Name</th>
    <th>Problem</th>
    <th>Booking Status</th>
</tr>
<c:forEach var="books" items="${list}">
    <tr style="text-align: center;">
    <td>${books.bookingId}</td>
    <td>${books.date}</td>
    <td>${books.time}</td>
    <td>${books.patientId.id}</td>
    <td>${books.patientId.username}</td>
    <td>${books.patientId.specialization}</td>
    <td>${books.bookingStatus}</td>
</tr>
</c:forEach>
</table><br>
<button><a href="welcomeDoctor">Back</a></button>
</body>
</html>