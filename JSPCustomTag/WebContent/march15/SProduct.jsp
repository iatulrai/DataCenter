<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Choose Product</title>
</head>
<body>
	<%
		String u = (String) session.getAttribute("id");
		if (u == null)
			response.sendRedirect("index.jsp?t=1");
		response.setHeader("Cache-Control", "no-cache");
	%>
	<pre>
		<h2>
Hello <%=u%>, Thanx for choosing us.
<hr size="4" color="red">
<a href="SLogout.jsp">Click here for Logout</a>


</body>
</html>