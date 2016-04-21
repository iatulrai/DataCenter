<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome Page</title>
</head>
<body>
	<%
		String u = (String) session.getAttribute("id");
		if (u == null)
			response.sendRedirect("index.jsp?t=1");
	%>
	<pre>
		<h2>
Hello <%=u%>, Welcome's U.
<hr size="4" color="red">
<a href="SProduct.jsp">Click here for selecting products</a>

</body>
</html>