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
		String u = "";
		String d = "";
		Cookie c[] = request.getCookies(); // get all req cookies for current page 
		if (c != null) // if cookies exist
		{
			for (int i = 0; i < c.length; i++) {
				if (c[i].getName().equals("uname"))
					u = c[i].getValue();
				if (c[i].getName().equals("dob"))
					d = c[i].getValue();
			}
		}
	%>
	


	<form action="Cookies2.jsp" method="post">
		<pre>

           User id <input type="text" name="uid" value="<%=u%>">

           DOB     <input type="text" name="uid" value="<%=d%>">

          Password <input type="password" name="uid">
          
          <input type="submit" value="Submit">


</pre>
	</form>

</body>
</html>