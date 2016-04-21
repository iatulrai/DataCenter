<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Page</title>
</head>
<body bgcolor="lightgreen ">

	<%
		String s = (String) request.getAttribute("msg");
		if (s != null) {
			out.print(s);
		}
	%>

	<form action="" method="post">
		<pre>
				
					Name     <input type="text" name="name" />
					
					Marks    <input type="number" name="marks" />
					
					Semester <input type="text" name="sem" />
					
					College  <input type="text" name="college" />
					
					Mobile   <input type="number" name="mobile" />
					
					<input type="submit" value="Submit" /> <input type="reset"
				value="Clear" />
 			</pre>

	</form>


</body>
</html>