<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Search Student by Challan No.</title>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/userform.css" />
</head>

<body>

<h1>RSMT BOY'S HOSTEL</h1>

	<form method="post" action="userInfoByCh">
	
		Enter the Challan No.:
			<input name="challan" type="text" value="" size="10" maxlength="10" />
			<input name="submit" type="submit" value="Submit"/>
	</form>
</body>
</html>
