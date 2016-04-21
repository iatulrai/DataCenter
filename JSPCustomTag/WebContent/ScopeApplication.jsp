<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<pre>
	<jsp:useBean id="o" class="com.mytag.Test" scope="application"></jsp:useBean>
	
	Date is - <%=o.getDate()%>
	
	Time is - <%=o.getTime()%>
	
	Counter is - <%=o.getCtr()%>
	
	Sum is - <%=o.sum(100,20)%>

</pre>

</body>
</html>