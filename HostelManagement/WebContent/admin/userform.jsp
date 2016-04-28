<html>

<head>
<title>New Student User Registration Form- RSMT BOY'S HOSTEL</title>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/userform.css" />
</head>
<body>

	<h1>RSMT BOY'S HOSTEL</h1>

	<marquee direction="right">
		<h3>New Student User Registration Form</h3>
	</marquee>

	<form action="userservlet" method="post">

		<table cellspacing="9">

			<tr>
				<td>Entry Date in HOstel:</td>
				<td><input type="date" name="doe" min="2015-01-01"></td>
			</tr>

			<tr>
				<td>Challan No.:</td>
				<td><input type="text" name="challan" value="" size="10"
					maxlength="20" /></td>
			</tr>

			<tr>
				<td>Name:</td>
				<td><input type="text" name="name" /></td>
			</tr>

			<tr>
				<td>Father Name:</td>
				<td><input type="text" name="f_name" /></td>
			</tr>

			<tr>
				<td>Date of Birth:</td>
				<td><input type="date" name="dob" min="1985-01-02"></td>
			</tr>


			<tr>
				<td>Mobile No.:</td>
				<td><input type="text" name="mob" maxlength="10" /></td>
			</tr>

			<tr>
				<td>Father Mobile No.:</td>
				<td><input type="text" name="f_mob" maxlength="10" /></td>
			</tr>

			<tr>
				<td>E-mail:</td>
				<td><input type="email" name="email" maxlength="21"></td>
			</tr>

			<tr>
				<td>Address:</td>
				<td><textarea name="address" cols="20" rows="3"></textarea></td>
			</tr>

			<tr>
				<td>Course:</td>
				<td><select name="course">
						<option value="0">Select</option>
						<option value="mca">MCA</option>
						<option value="mba">MBA</option>
						<option value="bca">BCA</option>
						<option value="bba">BBA</option>
				</select></td>
			</tr>


			<tr>
				<td>Semester:</td>
				<td><select name="sem">
						<option value="0">Select</option>
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
						<option value="6">6</option>
				</select></td>
			</tr>


			<tr align="center">
				<td><input name="Submit" type="submit" value="Submit " /> <input
					type="reset" value="Reset" /></td>
			</tr>
		</table>


	</form>
</body>
</html>