<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Here</title>
</head>
<body>


	<form action="SaveEmp">

		<pre>
      Ename  <input type="text" name="ename" placeholder="Enter Ename" />
      
      Salary <input type="text" name="sal" placeholder="Enter Salary" />
      
      Deptno <input type="text" name="deptno" placeholder="Enter Deptno" />
      
      Mobile <input type="text" name="mobile" placeholder="9990046906"
				maxlength="10" />
      
         <input type="submit" value="Save">
         
      <%
               	String s = (String) request.getAttribute("msg");
               	if (s != null)
               		out.print(s);
               %>  
               
               </pre>
	</form>
	<hr size="4" color="red">
	<a href="TblList">List of all Employee</a>


</body>
</html>