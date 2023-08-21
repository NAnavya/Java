<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
<style type="text/css">
    

</style>
<title>Insert title here</title>  
</head>  
<body>
    <form action="/addcheckup" method="post"> 
        <h1 style="text-align: center;">Add CheckUp Details</h1>    
       Patient Id : <input type="number" name="patientId" /><br><br>
       Booking Id : <input type="number" name="bookingId" /><br><br>
        Disease :<input type="text" name="disease" /><br><br>
        Description :<input type="text" name="description" /><br><br>
        <button type="submit">Submit</button>&nbsp;&nbsp;
        <button><a href="/welcomeDoctor">Back</a></button>      
    </form>  
</body>
</html>