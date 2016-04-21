<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		String u = (String) session.getAttribute("id");
		if (u == null)
			response.sendRedirect("index.jsp?t=1");
		response.setHeader("Cache-Control", "no-cache");
		session.invalidate();
	%>
	<pre>
		<h2>
Hello <%=u%>, u r successfully Logout.
<hr size="4" color="red">
<a href="index.jsp">Click here for Login</a>


</body>
</html>