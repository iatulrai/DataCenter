<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>

	<%
		String u = request.getParameter("uid");
		String d = request.getParameter("dob");
		Cookie c1 = new Cookie("uname", u);
		Cookie c2 = new Cookie("dob", d);
		c1.setMaxAge(30 * 24 * 60 * 60); // cookies age set for one month 
		c2.setMaxAge(30 * 24 * 60 * 60); // cookies age set for one month 
		response.addCookie(c1);
		response.addCookie(c2);
	%>

	<h3 style="color: green;">Cookies created successfully !</h3>

</body>
</html>