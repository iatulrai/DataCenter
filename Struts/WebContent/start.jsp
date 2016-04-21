<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-nested" prefix="nested"%>
<html:html>
<head>
<title>start.jsp</title>
<html:base />
</head>
<body>
	<p>
		Message:
		<bean:message key="my.message" />
	</p>
	<a href="success.jsp">Go to myTest Success</a>
	<br />
	<a href="failure.jsp">Go to myTest Failure</a>
</body>
</html:html>