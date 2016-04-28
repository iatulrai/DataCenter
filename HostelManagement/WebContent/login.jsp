<html>
<head>
	<title>Welcome to Login Page-RSMT BOYS HOSTEL</title>
	
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/login_page.css" />
	
</head>
<body>

<h1>RSMT BOY'S HOSTEL</h1>

<h3>Admin and Student Form</h3>

<form name="loginpage" method="post" action="j_security_check">

<table cellspacing="9">

<tr><th>Select Your Loing Credential:</th>
<td><select name="login">

<option value="admin">Admin Login</option>
<option value="student">Student Login</option>
</select></td></tr>

<tr><th>User ID:</th>
<td><input type="text" name="j_username" size="20"></td></tr>

<tr><th>Password:</th>
<td><input type="password" name="j_password" size="20"></td></tr>

<td align="center"><input type="submit" name="submit" value="Login"></td>

</table>

</form>


</body>
</html>