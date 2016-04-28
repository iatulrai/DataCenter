<%@ page import="dao.UserDAO,java.util.List, dto.UserDTO"%>
<html>
<head>
<title>Mess Money Report</title>
</head>
<body>
	<form method="post" action="">
		Select Year: <select name="year">
			<option value="0">Select</option>
			<option value="2013">2013</option>
			<option value="2014">2014</option>
			<option value="2015">2015</option>
			<option value="2016">2016</option>
			<option value="2017">2017</option>
		</select> <br /> Select Month: <select name="month">
			<option value="0">Select</option>
			<option value="1">January</option>
			<option value="2">February</option>
			<option value="3">March</option>
			<option value="4">April</option>
			<option value="5">May</option>
			<option value="6">June</option>
			<option value="7">July</option>
			<option value="8">August</option>
			<option value="9">September</option>
			<option value="10">October</option>
			<option value="11">November</option>
			<option value="12">December</option>
		</select><br /> Course: <select name="course">
			<option value="mca">MCA</option>
			<option value="mba">MBA</option>
			<option value="bca">BCA</option>
			<option value="bba">BBA</option>
		</select> <br /> <input name="submit" type="submit" value="Display" />

	</form>
	<table>
		<tr>
			<th>Challan</th>
			<th>Name</th>
			<th>Father Name</th>
			<th>Course</th>
			<th>Mess Amount</th>
		</tr>
		<%
			UserDAO userDao = new UserDAO();
			String year = request.getParameter("year");
			String month = request.getParameter("month");
			String course = request.getParameter("course");
			if (year != null) {
				List<UserDTO> list = userDao.stdMessMoneyt(year, month, course);
				for (UserDTO ob : list) {
		%>
		<tr>
			<td><%=ob.getChallan()%></td>
			<td><%=ob.getName()%></td>
			<td><%=ob.getFname()%></td>
			<td><%=ob.getCourse()%></td>
			<td><%=ob.getMessAmount()%></td>
		</tr>
		<%
			}
			}
		%>
	</table>
</body>
</html>