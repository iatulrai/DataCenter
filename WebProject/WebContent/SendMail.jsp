<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Send Mail from Java Mail API</title>
</head>
<body bgcolor="lightyellow">

	<form action="MailAction">

		<pre>
		
    To     <input type="text" name="to" />
    
    Subject<input type="text" name="sub" />
    
    Message 
           <textarea name="msg" rows="5" cols="70"></textarea>
    
    <input type="submit" value="Send">
    
    </pre>

	</form>



</body>
</html>