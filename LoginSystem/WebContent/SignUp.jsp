<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Here</title>
</head>
<body bgcolor="lightgreen">
 <pre><h3>
 <%
    String t = (String)request.getAttribute("msg");
    if(t!=null)
      out.print(t);  
 %>
   <form action="Register" method="POST">
       User Id  <input type="text" name="uid" placeholder="Enter User Id" required="true" />
       
       Password <input type="password" name="pass" placeholder="Enter Password" required="true" />
       
       Mail Id  <input type="text" name="mailid" placeholder="Enter Mail Id" required="true" />
       
       <input type="submit" value="Sign Up" />
       
       <a href="index.jsp">Sign In</a> 
   </form> 
 </h3></pre>  
</body>
</html>