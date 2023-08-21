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
 <form action="aupdatebookingstatus">
    <h1 style="text-align: center;">Update Booking Status</h1>
  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;BookingId : <input name="id" type="text" /> <br><br>
  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;Status : <input type="radio" name="status"  value="1" />Confirmed
  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;<input type="radio" name="status" value="0"/>Rejected <br><br>
   &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;<button type="submit">Submit</button>
   <button ><a href="/welcomeDoctor">Back</a></button>
 </form>
</body>
</html>