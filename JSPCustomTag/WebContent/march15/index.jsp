<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="lightgreen">
	<pre>
		<h3>
<%
	String t = request.getParameter("t");
	if (t != null) {
		if (t.equals("1"))
			out.print("Sorry U can't Contd.. without Login Plz login with ur Id");
		else
			out.print("Sorry this is invalid Login Id & Password, re-enter Plz");
	}
%>    
<form action="SValidate.jsp" method="post">
  User Id  <input type="text" name="uid" required="true"
					placeholder="Enter User Id" />
  
  Password <input type="password" name="ps" placeholder="Enter Password"
					required="true" />
  
     <input type="submit" value="Sign In" />
</form>
    

</html>