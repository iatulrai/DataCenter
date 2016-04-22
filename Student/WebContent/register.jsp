<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Registration page</title>

<script>
	function report() {
		document.forms[0].elements[0].value = "5";
		document.forms[0].submit();
	}
	function update() {
		document.forms[0].elements[0].value = "3";
		document.forms[0].submit();
	}
	function ddelete() {
		document.forms[0].elements[0].value = "4";
		document.forms[0].submit();
	}
	function view() {
		document.forms[0].ctr.value = "2";
		document.forms[0].submit();
	}
	function viewCity() {
		document.forms[0].elements[0].value = "6";
		document.forms[0].submit();
	}
</script>


</head>
<body>

	<%
		String t = request.getParameter("t");
	%>

	<s:form action="StudentAction.action">

		<s:hidden name="ctr" value="1" />
		<%
			if (t != null) {
		%>
		<s:select list="rollList" name="roll" label="Roll No" headerKey="" headerValue="Select Roll No" onchange="view()" />
		<%
			}
		%>
		<s:textfield name="name" label="Name" />
		<s:select list="collList" name="college" label="College" headerKey=""
			headerValue="Select College" />
		<s:select list="stList" name="state" label="State" headerKey=""
			headerValue="Select State" onchange="viewCity()" />
		<s:select list="ctList" name="city" label="City" headerKey=""
			headerValue="Select City" />

		<%
			if (t == null) {
		%>
		<s:submit value="S a v e" />

		<%
			} else {
		%>

		<tr>
			<td></td>
			<td><input type="button" value="Update" onclick="update()" /> <input
				type="button" value="Delete" onclick="ddelete()" /></td>
		</tr>
		<%
			}
		%>
	</s:form>
	<%
		String msg = (String) request.getAttribute("msg");
		if (msg != null) {
			out.print(msg);
		}
	%>
	<br />
	<hr>
	<a href="#" onclick="report()">List Of Records</a>
</body>
</html>