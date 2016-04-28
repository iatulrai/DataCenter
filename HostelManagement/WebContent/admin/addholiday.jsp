<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Add Holiday</title>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/holiday.css" />

</head>

<body>

<h1>RSMT BOY'S HOSTEL</h1>

	<form method="post" action="addholiday">
	
	<b >Please enter the detail to add Holidays</b>
	
	<table cellspacing="5">
   
   <tr><td> <input name="challan" type="hidden" value="<%=request.getParameter("challan")%>" size="10" maxlength="10" /> </td></tr><br />	
	
	<tr><td>Challan No. : <%=request.getParameter("challan")%></td></tr>
	
	<br/>
	
	
	<tr>
	<td>Select Year:</td>
 		<td><select name="year">
		  <option value="0">Select</option>
		  <option value="2013">2013</option>
		  <option value="2014">2014</option>
		  <option value="2015">2015</option>
		  <option value="2016">2016</option>
		  <option value="2017">2017</option>
		</select>  </td>
		
		</tr><br />
	
	<tr>
	<td>Select Month:</td>
		<td><select name="month" >
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
		</select> </td>
		
		</tr><br />
	<tr>
		
	<td>Enter No. of Holiday:</td>
		<td><input name="holiday" type="text" value="" size="10" maxlength="10" /></td> 
		
		</tr>
		
	<tr><td><input name="submit" type="submit" value="Add" /></td></tr>	
	
	</table>
		

	</form>		
</body>
</html>
