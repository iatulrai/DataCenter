<%-- 
    Document   : Register
    Created on : Apr 22, 2016, 2:44:21 PM
    Author     : Atul Rai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register</title>
<script>
	function view() {
		document.forms[0].elements[0].value = "2";
		document.forms[0].submit();
	}

	function rollData() {
		document.forms[0].elements[0].value = "3";
		document.forms[0].submit();
	}
	function upd() {
		document.forms[0].elements[0].value = "4";
		document.forms[0].submit();
	}
	function del() {
		document.forms[0].elements[0].value = "5";
		document.forms[0].submit();
	}

	function report() {
		document.forms[0].elements[0].value = "6";
		document.forms[0].submit();
	}
</script>
</head>
<body bgcolor="lightgreen">
	<%
		String t = request.getParameter("t");
	%>
	<s:form action="Regis.action">
		<s:hidden name="ctr" value="1" />

		<%
			if (t != null) {
		%>
		<s:select name="roll" list="rollList" label="Roll No" headerKey=""
			headerValue="Apana Roll No select kara bachawa" onchange="rollData()" />
		<%
			}
		%>

		<s:textfield name="name" label="Name" />
		<s:textfield name="marks" label="Marks" />

		<%
			if (t != null) {
		%>

		<tr>
			<td></td>
			<td><button onclick="upd()">Update</button>

				<button onclick="del()">Delete</button>

				<button onclick="report()">Report</button>
		</tr>

		<%
			} else {
		%>
		<s:submit value="S a v e" />

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
</body>
</html>
