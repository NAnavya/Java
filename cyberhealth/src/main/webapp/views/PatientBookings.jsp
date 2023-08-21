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
    <h2>My Bookings</h2>
<table border="1" cellpadding="1" width="100%">
    <tr style="text-align: center;">
    <th>Id</th>
    <th>Date</th>
    <th>Time</th>
    <th>Booking Status</th>
    <th>Doctor Id</th>
    <th>Doctor Name</th>
    <th>Specialization</th>
    </tr>
    <c:forEach var="book" items="${output}">
        <tr style="text-align: center;">
        <td>${book.bookingId}</td>
        <td>${book.date}</td>
        <td>${book.time}</td>
        <td>${book.bookingStatus}</td>
        <td>${book.usermodel.id}</td>
        <td>${book.usermodel.username}</td>
        <td>${book.usermodel.specialization}</td>
       
        
        </tr>
    </c:forEach>
</table><br>
<button><a href="welcome">Back</a></button>
</body>
</html>