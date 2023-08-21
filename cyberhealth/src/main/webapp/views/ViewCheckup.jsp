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
    <h2>CheckUp Details</h2>
<table border="1" cellpadding="1" width="100%">
    <tr style="text-align: center;">
    <th>CheckupId</th>
    <th>BookingId</th>
    <th>DoctorId</th>
    <th>Disease</th>
    <th>Description</th>
    </tr>
    <c:forEach var="checkuplist" items="${checkup}">
        <tr style="text-align: center;">
        <td>${checkuplist.checkupID}</td>
        <td>${checkuplist.bookingId}</td>
        <td>${checkuplist.did}</td>
        <td>${checkuplist.disease}</td>
        <td>${checkuplist.description}</td>     
        </tr>
    </c:forEach>
</table><br>
<button><a href="welcome">Back</a></button>
</body>
</html>