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
 <form action="/saveUser" method="post" >
    <h1 style="text-align: center;">Registration</h1>
  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;UserName : <input name="username" type="text" /><br><br>
  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;Email : <input name="email" type="text" /> <br><br>
  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp; Password : <input name="password" type="text" /> <br><br>
  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;Conform Password : <input name="confirmpassword" type="text" /> <br><br>
  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;MobileNumber : <input name="mobileNumber" type="text" /><br><br>
  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;Description of Disease : <input name="specialization" type="text" /> <br><br>
  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp; Active: <input name="active" type="radio" value="1" /> Yes
   <input name="active" type="radio" value="0" /> No <br><br>
   &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp; Role :<select name="role"><br><br>
       <option value="patient">Patient</option>
   </select><br><br>
   &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;LoggedIn: <input name="LoggedIn" type="radio" value="1" /> Yes
   <input name="LoggedIn" type="radio" value="0" /> No<br><br>
   &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;<button >Submit</button>
 
<button><a href="/home"> Back</a></button>

 </form>
   
</body>
</html>