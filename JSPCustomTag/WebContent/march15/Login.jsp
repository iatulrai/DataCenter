<body bgcolor="lightgreen">
	<pre>
		<h3>
<%
	String t = request.getParameter("t");
	if (t != null)
		out.print("Sorry this is invalid Login Id & Password, re-enter Plz");
%>    
<form action="IncludeT.jsp" method="post">
  User Id  <input type="text" name="uid" required="true"
					placeholder="Enter User Id" />
  
  Password <input type="password" name="ps" placeholder="Enter Password"
					required="true" />
  
     <input type="submit" value="Sign In" />
</form>
    