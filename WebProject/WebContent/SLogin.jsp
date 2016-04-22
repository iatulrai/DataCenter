<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Page Redirect</title>
</head>
<body bgcolor="lightyellow">

	<%
		String u = "", p = "";
		String t = request.getParameter("t");
		if (t != null) {

			if (t.equals("0")) {

				out.print("<font color=red> Sorry! This is invalid login id and password. Try again</font>");
			} else if (t.equals("1")) {

				out.print("<font color=red>Sorry you cant continue withot login id and password. Please Login</font>");
			} else {

				u = "User id cant balank";
				p = "Password Cant blank";

			}
		}
	%>


	<form action="SValidate" method="post">

		User ID: <input type="text" name="uid" /></br>
		<%=u%></br> Password: <input type="password" name="pass" /></br>
		<%=p%></br> <input type="submit" value="Sign In" />

	</form>

</body>
</html>