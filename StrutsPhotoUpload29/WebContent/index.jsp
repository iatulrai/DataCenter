<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
</head>
<body bgcolor="lightyellow">
	<s:form action="UploadAction.action" enctype="multipart/form-data">
		<s:textfield name="ename" required="true" label="Emp Name" />
		<s:file name="photo" label="Photo" required="true" />
		<s:submit value="U P L O A D" />

	</s:form>

	<%
		String m = (String) request.getAttribute("msg");
		if (m != null) {
			out.print(m);
		}
	%>

	<hr size="5" color="red" />
	<a href="List.jsp">Employee List</a>
</body>
</html>