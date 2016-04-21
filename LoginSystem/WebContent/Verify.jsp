<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Verify your User id</title>
</head>
<body bgcolor="lightgreen">
 <pre><h3>
 <%
    String t = (String)request.getAttribute("msg");
    if(t!=null)
      out.print(t);  
    String uid = (String)request.getAttribute("id");
 %>
   <form action="VerifyStatus" method="POST">
       <input type="hidden" name="userid" value="<%=uid%>">
       <input type="password" name="scode" placeholder="Enter ur Security Code" required="true" />
       
    <input type="submit" value="Verify" />
       
       <a href="index.jsp">Sign In</a> 
       
       
       
   </form> 
 </h3></pre>  
</body>
</html>