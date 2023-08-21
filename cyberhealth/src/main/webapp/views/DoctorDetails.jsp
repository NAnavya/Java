<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
<title>Doctor Details</title>  
</head>  
<body>
        <h1 style="text-align: center;">Doctor Details</h1>
 <table border="1" cellpadding="1" width="100%">
   
    <tr style="text-align: center;">
        <th>id</th>
        <th>Name</th>
        <th>Mail</th>
        <th>Mobile Number</th>
        <th>specialization</th>
        <th>Active</th>
    </tr>
    <c:forEach var="userlist" items="${userlist}">
		<tr style="text-align:center">
            <td>${userlist.id}</td>
			<td>${userlist.username}</td>
			<td>${userlist.email}</td>
            <td>${userlist.mobileNumber}</td>
            <td>${userlist.specialization}</td>
            <td>${userlist.active}</td>
		</tr>
	</c:forEach>
 </table>
<button >
    <a href="/welcome">Back</a></button>
</body>
</html> 