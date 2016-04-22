<%@page import="java.sql.ResultSet"%>
<body>
	<%
		String empno = request.getParameter("n");
		ResultSet rs = com.db.Admin.getEmp(empno);
		if (rs.next()) // if record exist hai to 
		{
	%>
	<pre>
		<h3>
    Employee exist with following details.  
    <form action="UpdEmp">
      Empno  <input type="text" name="empno" readonly="true"
					value="<%=empno%>" size="5" />
    
      Ename  <input type="text" name="ename"
					value="<%=rs.getString(2)%>" />
      
      Salary <input type="text" name="sal" value="<%=rs.getString(3)%>"
					size="8" />
      
      Deptno <input type="text" name="deptno"
					value="<%=rs.getString(4)%>" size="2" />
      
      Mobile <input type="text" name="mobile"
					value="<%=rs.getString(6)%>" size="15" />
      
         <input type="submit" value="Update">
    </form>
  <%
  	}
  %> <hr size="4" color="red">
   <a href="List">List of all Employee</a>
  </h3>
	</pre>
</body>